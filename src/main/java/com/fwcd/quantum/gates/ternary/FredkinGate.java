package com.fwcd.quantum.gates.ternary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

/**
 * Performs a controlled swap of the last two bits.<br><br>
 * 
 * Also called CSwapGate.
 */
public class FredkinGate extends MatrixGate {
	@Override
	protected Matrix<Complex> getMatrix() {
		return Numbers.complexMatrix(new double[][] {
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
		visitor.visitFredkin(this);
	}
}
