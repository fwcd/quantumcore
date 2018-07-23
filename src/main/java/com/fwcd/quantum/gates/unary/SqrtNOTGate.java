package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;
import com.fwcd.quantum.gates.StateMappingTable;

public class SqrtNOTGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |0> */ .mapTo(Numbers.complexVector(new double[][] {{0.5, 0.5}, {0.5, -0.5}}))
			/* |1> */ .mapTo(Numbers.complexVector(new double[][] {{0.5, -0.5}, {0.5, 0.5}}))
			/* --- */ .build();
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
