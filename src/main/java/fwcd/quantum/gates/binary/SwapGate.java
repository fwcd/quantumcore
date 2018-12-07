package fwcd.quantum.gates.binary;

import fwcd.quantum.gates.MatrixGate;
import fwcd.quantum.gates.QuantumGateVisitor;
import fwcd.quantum.gates.StateMappingTable;
import fwcd.quantum.wrapper.Ket;

/**
 * Swaps the input qubits.
 */
public class SwapGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |00> */ .mapTo(Ket.ZERO, Ket.ZERO)
			/* |01> */ .mapTo(Ket.ONE, Ket.ZERO)
			/* |10> */ .mapTo(Ket.ZERO, Ket.ONE)
			/* |11> */ .mapTo(Ket.ONE, Ket.ONE)
			/* ---- */ .build();
	}
	
	@Override
	public String getSymbol() {
		return "Swap";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitSwap(this);
	}
}
