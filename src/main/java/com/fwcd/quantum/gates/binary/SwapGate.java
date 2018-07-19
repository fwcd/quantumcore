package com.fwcd.quantum.gates.binary;

import com.fwcd.fructose.math.ComplexMatrix;
import com.fwcd.quantum.gates.MatrixGate;

/**
 * Swaps the input qubits.
 */
public class SwapGate extends MatrixGate {
	@Override
	protected ComplexMatrix getMatrix() {
		return new ComplexMatrix(new float[][] {
				{1, 0, 0, 0},
				{0, 0, 1, 0},
				{0, 1, 0, 0},
				{0, 0, 0, 1}
		});
	}
}
