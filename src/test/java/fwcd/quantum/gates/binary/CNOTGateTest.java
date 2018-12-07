package fwcd.quantum.gates.binary;

import static fwcd.quantum.test.TestUtils.approxEquals;
import static org.junit.Assert.assertThat;

import fwcd.fructose.math.Complex;
import fwcd.fructose.math.Matrix;
import fwcd.fructose.math.Numbers;
import fwcd.quantum.gates.MatrixGate;

import org.junit.Test;

public class CNOTGateTest {
	@Test
	public void testCNOT() {
		MatrixGate gate = new CNOTGate();
		int[] indices = {0, 2};
		Matrix<Complex> mat = gate.createGateMatrix(3, indices);
		
		assertThat(mat, approxEquals(Numbers.complexMatrix(new double[][] {
			{1, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 1, 0}
		}), 0.1D));
	}
}
