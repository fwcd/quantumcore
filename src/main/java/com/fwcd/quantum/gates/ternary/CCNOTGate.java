package com.fwcd.quantum.gates.ternary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

/**
 * If the first two bits are true it flips the third bit.<br><br>
 * 
 * Also called ToffoliGate.
 */
public class CCNOTGate extends MatrixGate {
	@Override
	protected Matrix<Complex> getMatrix() {
		return Numbers.complexMatrix(new double[][] {
				{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 1, 0}
		});
	}
	
	@Override
	public String getSymbol() {
		return "CCNOT";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitCCNOT(this);
	}
}
