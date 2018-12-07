package fwcd.quantum.wrapper;

import java.util.Arrays;

import fwcd.quantum.core.QubitSuperposition;

public final class Qubits {
	private Qubits() {}
	
	public static Qubit[] from(QubitSuperposition superpos) {
		int count = superpos.qubitCount();
		Qubit[] qubits = new Qubit[count];
		Arrays.setAll(qubits, i -> new Qubit(superpos, i));
		return qubits;
	}
}
