package fwcd.quantum.gates.unary;

import fwcd.fructose.math.Complex;
import fwcd.quantum.gates.MatrixGate;
import fwcd.quantum.gates.QuantumGateVisitor;
import fwcd.quantum.gates.StateMappingTable;
import fwcd.quantum.wrapper.Ket;

/**
 * Inverts around the hypercomplex x+z-axis.
 */
public class HadamardGate extends MatrixGate {
	private static final Complex INV_SQRT_2 = Complex.ofReal(1.0 / Math.sqrt(2));
	
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |0> */ .mapTo(Ket.ZERO.add(Ket.ONE).multiply(INV_SQRT_2))
			/* |1> */ .mapTo(Ket.ZERO.sub(Ket.ONE).multiply(INV_SQRT_2))
			/* --- */ .build();
	}

	@Override
	public String getSymbol() {
		return "H";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitHadamard(this);
	}
}
