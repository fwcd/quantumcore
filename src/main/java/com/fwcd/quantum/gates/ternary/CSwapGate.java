package com.fwcd.quantum.gates.ternary;

import com.fwcd.fructose.math.ComplexMatrix;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

/**
 * Performs a controlled swap of the last two bits.<br><br>
 * 
 * Also called FredkinGate.
 */
public class CSwapGate extends MatrixGate {
	@Override
	protected ComplexMatrix getMatrix() {
		return new ComplexMatrix(new float[][] {
				{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1}
		});
	}
	
	@Override
	public String getSymbol() {
		return "CSwap";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitCSwap(this);
	}
}
