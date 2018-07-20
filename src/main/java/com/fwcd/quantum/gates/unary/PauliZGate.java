package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

/**
 * Inverts around the hypercomplex z-axis.
 */
public class PauliZGate extends MatrixGate {
	@Override
	protected Matrix<Complex> getMatrix() {
		return Numbers.complexMatrix(new double[][] {
				{1, 0},
				{0, -1}
		});
	}

	@Override
	public String getSymbol() {
		return "Z";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitPauliZ(this);
	}
}
