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
	 * @param quantumState - The input superposition (or list of probabilities for possible qubit states)
	 * @param qubitIndices - The qubits in order to which this gate will be applied to
	 * @return An output superposition
	 */
	Vector<Complex> apply(Vector<Complex> quantumState, int... qubitIndices);
	
	default void accept(QuantumGateVisitor visitor) {
		visitor.visitGate(this);
	}
	
	default String getSymbol() {
		return "?";
	}
}
