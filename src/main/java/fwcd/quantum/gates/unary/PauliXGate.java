package fwcd.quantum.gates.unary;

import fwcd.quantum.gates.MatrixGate;
import fwcd.quantum.gates.QuantumGateVisitor;
import fwcd.quantum.gates.StateMappingTable;
import fwcd.quantum.wrapper.Ket;

/**
 * Inverts around the hypercomplex x-axis.<br><br>
 * 
 * Also referred to as a NOT-Gate.
 */
public class PauliXGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |0> */ .mapTo(Ket.ONE)
			/* |1> */ .mapTo(Ket.ZERO)
			/* --- */ .build();
	}

	@Override
	public String getSymbol() {
		return "X";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitPauliX(this);
	}
}
