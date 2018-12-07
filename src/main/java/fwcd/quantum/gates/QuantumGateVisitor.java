package fwcd.quantum.gates;

import fwcd.quantum.gates.binary.CNOTGate;
import fwcd.quantum.gates.binary.SwapGate;
import fwcd.quantum.gates.ternary.FredkinGate;
import fwcd.quantum.gates.ternary.ToffoliGate;
import fwcd.quantum.gates.unary.HadamardGate;
import fwcd.quantum.gates.unary.IdentityGate;
import fwcd.quantum.gates.unary.PauliXGate;
import fwcd.quantum.gates.unary.PauliYGate;
import fwcd.quantum.gates.unary.PauliZGate;
import fwcd.quantum.gates.unary.SqrtNOTGate;

public interface QuantumGateVisitor {
	void visitGate(QuantumGate gate);
	
	default void visitCNOT(CNOTGate gate) { visitGate(gate); }
	
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
