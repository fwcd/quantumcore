package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

/**
 * Inverts around the hypercomplex x+z-axis.
 */
public class HadamardGate extends MatrixGate {
	@Override
	protected Matrix<Complex> getMatrix() {
		return Numbers.complexMatrix(new double[][] {
				{1, 1},
				{1, -1}
		}).multiply(Complex.ofReal(1 / Math.sqrt(2)));
	}

	@Override
	public String getSymbol() {
		return "H";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitHadamard(this);
	}
}
