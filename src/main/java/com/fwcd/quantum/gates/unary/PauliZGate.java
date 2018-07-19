package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.ComplexMatrix;
import com.fwcd.quantum.gates.MatrixGate;

/**
 * Inverts around the hypercomplex z-axis.
 */
public class PauliZGate extends MatrixGate {
	@Override
	protected ComplexMatrix getMatrix() {
		return new ComplexMatrix(new float[][] {
				{1, 0},
				{0, -1}
		});
	}

	@Override
	public String getSymbol() {
		return "Z";
	}
}
