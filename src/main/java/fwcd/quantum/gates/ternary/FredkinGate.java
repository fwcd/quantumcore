package fwcd.quantum.gates.ternary;

import fwcd.quantum.gates.MatrixGate;
import fwcd.quantum.gates.QuantumGateVisitor;
import fwcd.quantum.gates.StateMappingTable;
import fwcd.quantum.wrapper.Ket;

/**
 * Performs a controlled swap on the last two bits.<br><br>
 * 
 * Also called CSwapGate.
 */
public class FredkinGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |000> */ .mapTo(Ket.ZERO, Ket.ZERO, Ket.ZERO)
			/* |001> */ .mapTo(Ket.ZERO, Ket.ZERO, Ket.ONE)
			/* |010> */ .mapTo(Ket.ZERO, Ket.ONE, Ket.ZERO)
			/* |011> */ .mapTo(Ket.ZERO, Ket.ONE, Ket.ONE)
			/* |100> */ .mapTo(Ket.ONE, Ket.ZERO, Ket.ZERO)
			/* |101> */ .mapTo(Ket.ONE, Ket.ONE, Ket.ZERO)
			/* |110> */ .mapTo(Ket.ONE, Ket.ZERO, Ket.ONE)
			/* |111> */ .mapTo(Ket.ONE, Ket.ONE, Ket.ONE)
			/* ---- */ .build();
	}
	
	@Override
	public String getSymbol() {
		return "CSwap";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitFredkin(this);
	}
}
