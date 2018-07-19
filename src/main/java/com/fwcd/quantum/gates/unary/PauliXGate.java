package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.ComplexMatrix;
import com.fwcd.quantum.gates.MatrixGate;

/**
 * Inverts around the hypercomplex x-axis.<br><br>
 * 
 * Also referred to as NOT-Gate.
 */
public class PauliXGate extends MatrixGate {
	@Override
	protected ComplexMatrix getMatrix() {
		return new ComplexMatrix(new float[][] {
				{0, 1},
				{1, 0}
		});
	}

	@Override
	public String getSymbol() {
		return "X";
	}
}
