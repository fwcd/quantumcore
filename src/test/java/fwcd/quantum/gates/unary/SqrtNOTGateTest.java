package fwcd.quantum.gates.unary;

import static fwcd.quantum.test.TestUtils.approxEquals;
import static org.junit.Assert.assertThat;

import fwcd.fructose.math.Complex;
import fwcd.fructose.math.Matrix;
import fwcd.fructose.math.Numbers;
import fwcd.quantum.gates.MatrixGate;

import org.junit.Test;

public class SqrtNOTGateTest {
	@Test
	public void testSqrtNOT() {
		MatrixGate gate = new SqrtNOTGate();
		int[] indices = {0};
		Matrix<Complex> mat = gate.createGateMatrix(1, indices);
		
		assertThat(mat, approxEquals(Numbers.complexMatrix(new double[][][] {
			{{0.5, 0.5}, {0.5, -0.5}},
			{{0.5, -0.5}, {0.5, 0.5}}
		}), 0.01D));
	}
}
