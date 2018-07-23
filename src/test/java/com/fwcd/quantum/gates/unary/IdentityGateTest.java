package com.fwcd.quantum.gates.unary;

import static com.fwcd.quantum.test.TestUtils.approxEquals;
import static org.junit.Assert.assertThat;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;

import org.junit.Test;

public class IdentityGateTest {
	@Test
	public void testIdentity() {
		MatrixGate gate = new IdentityGate();
		int[] indices = {1};
		Matrix<Complex> mat = gate.createGateMatrix(2, indices);
		
		assertThat(mat, approxEquals(Numbers.complexMatrix(new double[][] {
			{1, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 1}
		}), 0.1D));
	}
}
