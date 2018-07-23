package com.fwcd.quantum.gates.ternary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;
import com.fwcd.quantum.gates.StateMappingTable;
import com.fwcd.quantum.wrapper.Ket;

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
