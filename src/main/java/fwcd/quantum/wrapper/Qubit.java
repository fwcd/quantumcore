package fwcd.quantum.wrapper;

import static fwcd.quantum.wrapper.QuantumGates.CNOT;
import static fwcd.quantum.wrapper.QuantumGates.FREDKIN;
import static fwcd.quantum.wrapper.QuantumGates.H;
import static fwcd.quantum.wrapper.QuantumGates.SQRT_NOT;
import static fwcd.quantum.wrapper.QuantumGates.SWAP;
import static fwcd.quantum.wrapper.QuantumGates.TOFFOLI;
import static fwcd.quantum.wrapper.QuantumGates.X;
import static fwcd.quantum.wrapper.QuantumGates.Y;
import static fwcd.quantum.wrapper.QuantumGates.Z;

import fwcd.quantum.core.QubitSuperposition;
import fwcd.quantum.exception.QuantumException;
import fwcd.quantum.gates.QuantumGate;

/**
 * A convenience wrapper representing a Qubit in a superposition.
 */
public class Qubit {
	private final QubitSuperposition superposition;
	private final int index;
	
	public Qubit(QubitSuperposition superposition, int index) {
		this.superposition = superposition;
		this.index = index;
	}
	
	private void assertSameSuperposition(Qubit... others) {
		for (Qubit other : others) {
			if (superposition != other.superposition) {
				throw new QuantumException("Can't operate on qubits from different superpositions!");
			}
		}
	}
	
	private void apply(QuantumGate gate, Qubit... others) {
		assertSameSuperposition(others);
		int[] indices = new int[others.length + 1];
		int i = 0;
		indices[i++] = index;
		for (Qubit other : others) {
			indices[i++] = other.index;
		}
		superposition.apply(gate, indices);
	}
	
	/**
	 * Measures this Qubit.
	 */
	public boolean measure() {
		// TODO: This approach will collapse the entire superposition
		//       associated with this Qubit, even when these Qubits are not
		//       entangled. Instead, only this Qubit should be measured somehow.
		return superposition.measure().bitAt(index);
	}
	
	public void cnot(Qubit target) { apply(CNOT, target); }
	
	public void h() { apply(H); }
	
	public void swap(Qubit target) { apply(SWAP, target); }
	
	public void toffoli(Qubit control2, Qubit target) { apply(TOFFOLI, control2, target); }
	
	public void fredkin(Qubit target1, Qubit target2) { apply(FREDKIN, target1, target2); }
	
	public void x() { apply(X); }
	
	public void y() { apply(Y); }
	
	public void z() { apply(Z); }
	
	public void sqrtNot() { apply(SQRT_NOT); }
}
