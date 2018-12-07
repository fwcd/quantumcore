package fwcd.quantum.gates.unary;

import fwcd.fructose.math.Complex;
import fwcd.quantum.gates.MatrixGate;
import fwcd.quantum.gates.QuantumGateVisitor;
import fwcd.quantum.gates.StateMappingTable;
import fwcd.quantum.wrapper.Ket;

/**
 * Inverts around the hypercomplex y-axis.
 */
public class PauliYGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |0> */ .mapTo(Ket.ONE.multiply(Complex.I))
			/* |1> */ .mapTo(Ket.ZERO.multiply(Complex.I.negate()))
			/* --- */ .build();
	}

	@Override
	public String getSymbol() {
		return "Y";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitPauliY(this);
	}
}
