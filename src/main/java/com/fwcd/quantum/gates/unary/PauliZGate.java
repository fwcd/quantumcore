package com.fwcd.quantum.gates.unary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;
import com.fwcd.quantum.gates.StateMappingTable;
import com.fwcd.quantum.wrapper.Ket;

/**
 * Inverts around the hypercomplex z-axis.
 */
public class PauliZGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |0> */ .mapTo(Ket.ZERO)
			/* |1> */ .mapTo(Ket.ONE.negate())
			/* --- */ .build();
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
