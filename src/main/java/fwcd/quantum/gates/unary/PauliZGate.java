package fwcd.quantum.gates.unary;

import fwcd.quantum.gates.MatrixGate;
import fwcd.quantum.gates.QuantumGateVisitor;
import fwcd.quantum.gates.StateMappingTable;
import fwcd.quantum.wrapper.Ket;

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
