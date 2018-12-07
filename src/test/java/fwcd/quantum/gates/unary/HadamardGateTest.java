package fwcd.quantum.gates.unary;

import static fwcd.quantum.test.TestUtils.approxEquals;
import static org.junit.Assert.assertThat;

import fwcd.fructose.math.Complex;
import fwcd.fructose.math.Matrix;
import fwcd.fructose.math.Numbers;
import fwcd.quantum.gates.MatrixGate;
import fwcd.quantum.gates.unary.HadamardGate;

import org.junit.Test;

public class HadamardGateTest {
	@Test
	public void testHadamard() {
		MatrixGate gate = new HadamardGate();
		int[] indices = {0};
		Matrix<Complex> mat = gate.createGateMatrix(1, indices);
		
		assertThat(mat, approxEquals(Numbers.complexMatrix(new double[][] {
			{1, 1},
			{1, -1}
		}).multiply(Complex.ofReal(1.0 / Math.sqrt(2))), 0.1D));
	}
}
