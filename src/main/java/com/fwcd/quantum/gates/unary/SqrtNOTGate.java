package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

public class SqrtNOTGate extends MatrixGate {
	@Override
	protected Matrix<Complex> getMatrix() {
		return Numbers.complexMatrix(new double[][][] {
				{{0.5, 0.5}, {0.5, -0.5}},
				{{0.5, -0.5}, {0.5, 0.5}}
		});
	}

	@Override
	public String getSymbol() {
		return "sqrt(NOT)";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitSqrtNOT(this);
	}
}
