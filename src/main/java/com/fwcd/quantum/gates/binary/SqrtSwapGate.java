package com.fwcd.quantum.gates.binary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;

/**
 * Half swaps the input qubits.
 */
public class SqrtSwapGate extends MatrixGate {
	@Override
	protected Matrix<Complex> getMatrix() {
		return new Matrix<>(new Complex[][] {
				{Complex.ONE, Complex.ZERO, Complex.ZERO, Complex.ZERO},
				{Complex.ZERO, Complex.of(0.5, 0.5), Complex.of(0.5, -0.5), Complex.ZERO},
				{Complex.ZERO, Complex.of(0.5, -0.5), Complex.of(0.5, 0.5), Complex.ZERO},
				{Complex.ZERO, Complex.ZERO, Complex.ZERO, Complex.ONE}
		});
	}
	
	@Override
	public String getSymbol() {
		return "sqrt(Swap)";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitSqrtSwap(this);
	}
}
