package com.fwcd.quantum.gates.binary;

import com.fwcd.fructose.math.ComplexMatrix;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

/**
 * Inverts the second input qubit if the first
 * input qubit is enabled.<br><br>
 * 
 * Thus it XOR's the bits, stores the result in the
 * second bit and leaves the first bit unchanged.
 */
public class CNOTGate extends MatrixGate {
	@Override
	protected ComplexMatrix getMatrix() {
		return new ComplexMatrix(new float[][] {
				{1, 0, 0, 0},
				{0, 1, 0, 0},
				{0, 0, 0, 1},
				{0, 0, 1, 0}
		});
	}
	
	@Override
	public String getSymbol() {
		return "CNOT";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitCNOT(this);
	}
}
