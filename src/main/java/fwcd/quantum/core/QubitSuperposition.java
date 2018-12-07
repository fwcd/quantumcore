package fwcd.quantum.core;

import java.util.Optional;

import fwcd.fructose.math.Complex;
import fwcd.fructose.math.Vector;
import fwcd.quantum.gates.QuantumGate;

/**
 * A mutable system of one or more non-determined, possibly entangled qubits.<br><br>
 * 
 * Thus it encapsulates a superposition of every possible combination of the given qubits
 * (as binary index in the vector) mapped to it's probability
 * (as the value of the given index in the vector).<br><br>
 * 
 * The size of this superposition vector grows exponentially
 * (2^n) to the amount of qubits.
 */
public interface QubitSuperposition {
	/**
	 * Applies the given quantum gate to this superposition.
	 * 
	 * @param gate - The gate
	 * @param qubits - The qubits (in order) to which the gate will be applied
	 */
	void apply(QuantumGate gate, int... qubitIndices);
	
	/**
	 * Checks whether this is a valid
	 * quantum superposition. Validity can decrease
	 * due to rounding errors with floating point operations.
	 * 
	 * @param tolerance - The allowable qubit error
	 * @return Whether this superpositions satisfies the sum of abs squares criterium
	 */
	boolean isValid(double tolerance);
	
	/**
	 * Appends the qubits from the other superposition to
	 * this one. Whether this operation "destroys" the other instance
	 * or not is up to the implementor.
	 */
	void merge(QubitSuperposition other);
	
	/**
	 * @return The amount of qubits in this superposition.
	 */
	int qubitCount();
	
	/**
	 * Collapses this superposition to a series of
	 * zeros and ones.
	 * 
	 * @return Whether measurement was successful
	 */
	ClassicalState measure();
	
	/**
	 * Represents this quantum superposition as a
	 * classical state if possible (e.g. when it
	 * has been measured or directly after it was
	 * created). Otherwise returns an empty optional.
	 */
	Optional<ClassicalState> asClassical(double tolerance);
	
	/**
	 * Fetches the probability of a given state of
	 * qubits, provided this superposition has this state.
	 * 
	 * @param state - The searched state
	 * @return The probability of it being the state used when collapsing this superposition
	 */
	double probabilityOf(ClassicalState state);
	
	/**
	 * Fetches the representation of this quantum superposition
	 * as a vector of complex numbers. Each index corresponds
	 * to a possible outcome in binary form and the squared
	 * magnitude of the value at this position to the probability
	 * of that result when measured.
	 */
	Vector<Complex> getState();
}
