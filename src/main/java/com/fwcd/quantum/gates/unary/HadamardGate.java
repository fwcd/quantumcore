package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.ComplexMatrix;
import com.fwcd.quantum.gates.MatrixGate;

/**
 * Inverts around the hypercomplex x+z-axis.
 */
public class HadamardGate extends MatrixGate {
	@Override
	protected ComplexMatrix getMatrix() {
		return new ComplexMatrix(new float[][] {
				{1, 1},
				{1, -1}
		}).multiply((float) (1 / Math.sqrt(2)));
	}

	@Override
	public String getSymbol() {
		return "H";
	}
}
