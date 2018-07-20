package com.fwcd.quantum.gates;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Vector;

/**
 * A quantum gates takes a superposition vector as it's
 * input and produces a new superposition vector as it's
 * output.
 */
public interface QuantumGate {
	/**
	 * Applies this quantum gate to a given vector.
	 * 
	 * @param possibleStates - The input superposition (or list of probabilities for possible qubit states)
	 * @param qubitIndex - The start qubit index of the qubits on which the gate will be applied
	 * @return An output superposition
	 */
	Vector<Complex> apply(Vector<Complex> possibleStates, int qubitIndex);
	
	default void accept(QuantumGateVisitor visitor) {
		visitor.visitGate(this);
	}
	
	default String getSymbol() {
		return "?";
	}
}
