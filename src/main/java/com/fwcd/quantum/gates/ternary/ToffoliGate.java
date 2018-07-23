package com.fwcd.quantum.gates.ternary;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.quantum.gates.MatrixGate;
import com.fwcd.quantum.gates.QuantumGateVisitor;
import com.fwcd.quantum.gates.StateMappingTable;
import com.fwcd.quantum.wrapper.Ket;

/**
 * If the first two bits are true it flips the third bit.<br><br>
 * 
 * Also called CCNOTGate.
 */
public class ToffoliGate extends MatrixGate {
	@Override
	protected StateMappingTable getMappings() {
		return new StateMappingTable.Builder()
			/* |000> */ .mapTo(Ket.ZERO, Ket.ZERO, Ket.ZERO)
			/* |001> */ .mapTo(Ket.ZERO, Ket.ZERO, Ket.ONE)
			/* |010> */ .mapTo(Ket.ZERO, Ket.ONE, Ket.ZERO)
			/* |011> */ .mapTo(Ket.ZERO, Ket.ONE, Ket.ONE)
			/* |100> */ .mapTo(Ket.ONE, Ket.ZERO, Ket.ZERO)
			/* |101> */ .mapTo(Ket.ONE, Ket.ZERO, Ket.ONE)
			/* |110> */ .mapTo(Ket.ONE, Ket.ONE, Ket.ONE)
			/* |111> */ .mapTo(Ket.ONE, Ket.ONE, Ket.ZERO)
			/* ---- */ .build();
	}
	
	@Override
	public String getSymbol() {
		return "CCNOT";
	}
	
	@Override
	public void accept(QuantumGateVisitor visitor) {
		visitor.visitToffoli(this);
	}
}
