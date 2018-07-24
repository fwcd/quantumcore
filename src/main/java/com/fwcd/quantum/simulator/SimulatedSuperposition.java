package com.fwcd.quantum.simulator;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import com.fwcd.fructose.ListUtils;
import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.ExtMath;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.fructose.math.Vector;
import com.fwcd.quantum.core.ClassicalState;
import com.fwcd.quantum.core.QubitSuperposition;
import com.fwcd.quantum.exception.QuantumException;
import com.fwcd.quantum.gates.QuantumGate;

public class SimulatedSuperposition implements QubitSuperposition {
	private final int qubitCount;
	/** Contains the probabilities for the possible states; Size = 2^qubitCount */
	private Vector<Complex> state;
	
	public SimulatedSuperposition(int... initialQubitValues) {
		this(ClassicalState.of(initialQubitValues));
	}
	
	public SimulatedSuperposition(boolean... initialQubitValues) {
		this(ClassicalState.of(initialQubitValues));
	}
	
	/**
	 * Constructs a new qubit superposition from the given
	 * input state. Note that the superposition requires
	 * exponentially (2^n) more space for each qubit.
	 * 
	 * @param state - The initial qubits state
	 */
	public SimulatedSuperposition(ClassicalState state) {
		qubitCount = state.bitCount();
		double[] probabilities = new double[(int) Math.pow(2, qubitCount)];
		int givenState = state.toInt();
		
		for (int i=0; i<probabilities.length; i++) {
			probabilities[i] = (i == givenState) ? 1 : 0;
		}
		
		this.state = Numbers.complexVector(probabilities);
	}
	
	public SimulatedSuperposition(Vector<Complex> state) {
		this.state = state;
		qubitCount = ExtMath.log2Floor(state.size());
		
		if (!isValid(0.01D)) {
			throw new IllegalArgumentException("Tried to create a simulated superposition from the invalid state vector " + state);
		}
	}
	
	@Override
	public boolean isValid(double tolerance) {
		double sumOfSquaredMagnitudes = 0;
		for (Complex probability : state) {
			sumOfSquaredMagnitudes += probability.absSquared();
		}
		return Math.abs(sumOfSquaredMagnitudes - 1) < tolerance;
	}

	@Override
	public void apply(QuantumGate gate, int... qubitIndices) {
		state = gate.apply(state, qubitIndices);
	}
	
	@Override
	public void merge(QubitSuperposition other) {
		state = state.kronecker(other.getState());
	}
	
	@Override
	public int qubitCount() {
		return qubitCount;
	}
	
	private void collapseAs(int classicalBinaryState) {
		List<Complex> newState = ListUtils.makeList(state.size(), i -> Complex.ZERO);
		newState.set(classicalBinaryState, Complex.ONE);
		state = new Vector<>(newState);
	}
	
	@Override
	public ClassicalState measure() {
		double random = ThreadLocalRandom.current().nextDouble();
		int states = state.size();
		for (int i=0; i<states; i++) {
			random -= state.get(i).absSquared();
			if (random <= 0) {
				collapseAs(i);
				return ClassicalState.ofBinary(i, qubitCount);
			}
		}
		throw new QuantumException("Could not measure invalid quantum superposition.");
	}
	
	@Override
	public double probabilityOf(ClassicalState state) {
		try {
			return this.state.get(state.toInt()).absSquared();
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Not a valid qubit state!");
		}
	}
	
	@Override
	public Optional<ClassicalState> asClassical(double tolerance) {
		// Tries to match a state vector similar to this:
		// [0, 0, 0, 1, 0, 0, 0, 0, ...]
		
		Optional<ClassicalState> classical = Optional.empty();
		int states = state.size();
		for (int i=0; i<states; i++) {
			double probability = state.get(i).absSquared();
			boolean isOne = Math.abs(probability - 1) < tolerance;
			boolean isZero = Math.abs(probability - 0) < tolerance;
			
			if (classical.isPresent()) {
				if (!isZero) {
					// After the determined state was found, no non-zero values should follow
					return Optional.empty();
				}
			} else { // classical is not present
				if (isOne) {
					// i == binary representation of the determined state
					classical = Optional.of(ClassicalState.ofBinary(i, qubitCount));
				} else if (!isZero) {
					// Values except for 0 and 1 are not allowed
					return Optional.empty();
				}
			}
		}
		return classical;
	}
	
	@Override
	public Vector<Complex> getState() {
		return state;
	}
	
	@Override
	public String toString() {
		String result = "[Superposition]:\n";
		
		for (int i=0; i<state.size(); i++) {
			double probability = state.get(i).absSquared();
			result += "    " + ExtMath.binaryString(i, qubitCount) + " -> " + probability + "\n";
		}
		
		return result;
	}
}
