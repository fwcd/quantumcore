package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.ComplexMatrix;
import com.fwcd.quantum.gates.MatrixGate;

/**
 * Inverts around the hypercomplex y-axis.
 */
public class PauliYGate extends MatrixGate {
	@Override
	protected ComplexMatrix getMatrix() {
		return new ComplexMatrix(new Complex[][] {
				{Complex.ZERO, Complex.I.invertImag()},
				{Complex.I, Complex.ZERO}
		});
	}

	@Override
	public String getSymbol() {
		return "Y";
	}
}
