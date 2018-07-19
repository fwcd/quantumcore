package com.fwcd.quantum.gates.binary;

import com.fwcd.fructose.math.ComplexMatrix;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

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
	
	@Override
	public String getSymbol() {
		return "Swap";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitSwap(this);
	}
}
