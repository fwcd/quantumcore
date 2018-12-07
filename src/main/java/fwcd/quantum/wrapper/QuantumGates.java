package fwcd.quantum.wrapper;

import fwcd.quantum.gates.QuantumGate;
import fwcd.quantum.gates.binary.CNOTGate;
import fwcd.quantum.gates.binary.SwapGate;
import fwcd.quantum.gates.ternary.FredkinGate;
import fwcd.quantum.gates.ternary.ToffoliGate;
import fwcd.quantum.gates.unary.HadamardGate;
import fwcd.quantum.gates.unary.PauliXGate;
import fwcd.quantum.gates.unary.PauliYGate;
import fwcd.quantum.gates.unary.PauliZGate;
import fwcd.quantum.gates.unary.SqrtNOTGate;

/**
 * A collection of common quantum gates.
 */
public final class QuantumGates {
	public static final QuantumGate CNOT = new CNOTGate();
	public static final QuantumGate H = new HadamardGate();
	public static final QuantumGate SWAP = new SwapGate();
	public static final QuantumGate SQRT_NOT = new SqrtNOTGate();
	public static final QuantumGate X = new PauliXGate();
	public static final QuantumGate Y = new PauliYGate();
	public static final QuantumGate Z = new PauliZGate();
	public static final QuantumGate FREDKIN = new FredkinGate();
	public static final QuantumGate TOFFOLI = new ToffoliGate();
	
	private QuantumGates() {}
}
