package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

/**
 * Inverts around the hypercomplex x-axis.<br><br>
 * 
 * Also referred to as NOT-Gate.
 */
public class PauliXGate extends MatrixGate {
	@Override
	protected Matrix<Complex> getMatrix() {
		return Numbers.complexMatrix(new double[][] {
				{0, 1},
				{1, 0}
		});
	}

	@Override
	public String getSymbol() {
		return "X";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitPauliX(this);
	}
}
