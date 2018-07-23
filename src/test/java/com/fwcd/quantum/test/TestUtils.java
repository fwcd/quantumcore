package com.fwcd.quantum.test;

import static org.junit.Assert.assertThat;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.fructose.operations.ToleranceEquatable;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.utils.ArrayUtils;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public final class TestUtils {
	private TestUtils() {}
	
	public static <V extends ToleranceEquatable<V>> Matcher<V> approxEquals(V expected, double tolerance) {
		return new BaseMatcher<V>() {
			@Override
			@SuppressWarnings("unchecked")
			public boolean matches(Object item) {
				return ((V) item).equals(expected, tolerance);
			}
			
			@Override
			public void describeTo(Description description) {
				description
						.appendValue(expected.getClass())
						.appendText(" should equal ")
						.appendValue(expected);
			}
		};
	}
	
	public static void assertMatrixEquals(MatrixGate gate, double[][] complexMatrixOfReals) {
		assertMatrixEquals(gate, Numbers.complexMatrix(complexMatrixOfReals));
	}
	
	public static void assertMatrixEquals(MatrixGate gate, double[][][] complexMatrix) {
		assertMatrixEquals(gate, Numbers.complexMatrix(complexMatrix));
	}
	
	public static void assertMatrixEquals(MatrixGate gate, Matrix<Complex> expected) {
		int qubits = gate.qubitCount();
		int[] indices = ArrayUtils.intRange(0, qubits);
		Matrix<Complex> mat = gate.createGateMatrix(qubits, indices);
		assertThat(mat, approxEquals(expected, 0.01D));
	}
}
