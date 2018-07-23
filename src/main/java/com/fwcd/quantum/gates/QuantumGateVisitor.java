package com.fwcd.quantum.gates;

import com.fwcd.quantum.gates.binary.CNOTGate;
import com.fwcd.quantum.gates.binary.SqrtSwapGate;
import com.fwcd.quantum.gates.binary.SwapGate;
import com.fwcd.quantum.gates.ternary.FredkinGate;
import com.fwcd.quantum.gates.ternary.ToffoliGate;
import com.fwcd.quantum.gates.unary.HadamardGate;
import com.fwcd.quantum.gates.unary.IdentityGate;
import com.fwcd.quantum.gates.unary.PauliXGate;
import com.fwcd.quantum.gates.unary.PauliYGate;
import com.fwcd.quantum.gates.unary.PauliZGate;
import com.fwcd.quantum.gates.unary.SqrtNOTGate;

public interface QuantumGateVisitor {
	void visitGate(QuantumGate gate);
	
	default void visitCNOT(CNOTGate gate) { visitGate(gate); }
	
	default void visitSqrtSwap(SqrtSwapGate gate) { visitGate(gate); }
	
	default void visitSwap(SwapGate gate) { visitGate(gate); }
	
	default void visitToffoli(ToffoliGate gate) { visitGate(gate); }
	
	default void visitFredkin(FredkinGate gate) { visitGate(gate); }
	
	default void visitHadamard(HadamardGate gate) { visitGate(gate); }
	
	default void visitPauliX(PauliXGate gate) { visitGate(gate); }
	
	default void visitPauliY(PauliYGate gate) { visitGate(gate); }
	
	default void visitPauliZ(PauliZGate gate) { visitGate(gate); }
	
	default void visitSqrtNOT(SqrtNOTGate gate) { visitGate(gate); }
	
	default void visitIdentity(IdentityGate gate) { visitGate(gate); }
}
