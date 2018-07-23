package com.fwcd.quantum.gates.unary;

import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;
import com.fwcd.quantum.gates.StateMappingTable;
import com.fwcd.quantum.wrapper.Ket;

/**
 * A quantum gate that maps every state to itself.
 */
public class IdentityGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |0> */ .mapTo(Ket.ZERO)
			/* |1> */ .mapTo(Ket.ONE)
			/* --- */ .build();
	}

	@Override
	public String getSymbol() {
		return "I";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitIdentity(this);
	}
}
