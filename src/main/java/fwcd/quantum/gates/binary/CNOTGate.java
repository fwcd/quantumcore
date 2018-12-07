package fwcd.quantum.gates.binary;

import fwcd.quantum.gates.MatrixGate;
import fwcd.quantum.gates.QuantumGateVisitor;
import fwcd.quantum.gates.StateMappingTable;
import fwcd.quantum.wrapper.Ket;

/**
 * Inverts the second input qubit if the first
 * input qubit is enabled.<br><br>
 * 
 * Thus it XOR's the bits, stores the result in the
 * second bit and leaves the first bit unchanged.
 */
public class CNOTGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |00> */ .mapTo(Ket.ZERO, Ket.ZERO)
			/* |01> */ .mapTo(Ket.ZERO, Ket.ONE)
			/* |10> */ .mapTo(Ket.ONE, Ket.ONE)
			/* |11> */ .mapTo(Ket.ONE, Ket.ZERO)
			/* ---- */ .build();
	}
	
	@Override
	public String getSymbol() {
		return "CNOT";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitCNOT(this);
	}
}
