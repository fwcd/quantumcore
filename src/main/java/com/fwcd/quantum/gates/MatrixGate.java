package com.fwcd.quantum.gates;

import java.util.Arrays;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Vector;
import com.fwcd.fructose.math.ExtMath;
import com.fwcd.fructose.math.Matrix;
import com.fwcd.fructose.math.Numbers;

/**
 * A convenience class to represent matrix based
 * quantum gates.
 */
public abstract class MatrixGate implements QuantumGate {
	private final Vector<Complex>[][] mappings = getMappings();
	private final int qubitCount = ExtMath.log2Floor(mappings.length);
	
	@Override
	public Vector<Complex> apply(Vector<Complex> quantumState, int... qubitIndices) {
		assertCorrectGateSize(qubitIndices.length);
		Matrix<Complex> gateMatrix = createGateMatrix(qubitIndices);
		return gateMatrix.multiply(quantumState);
	}
	
	private Matrix<Complex> createGateMatrix(int... qubitIndices) {
		
	}
	
	/**
	 * <p>Fetches the mappings in a "truth table" form.
	 * The outer array contains the "rows" of the mapped results.
	 * Example of a 2-qubit identity gate:</p>
	 * 
	 * <pre>
	 * |00> to [|0>, |0>],
	 * |01> to [|0>, |1>],
	 * |10> to [|1>, |0>],
	 * |11> to [|1>, |1>]
	 * </pre>
	 * 
	 * <p><b>Note for implementors:</b>
	 * Kets can be conveniently created using States.ONE or States.ZERO.
	 * The main difference between this approach and a matrix-based approach
	 * is that this function yields the results of each mapping in
	 * factorized form (they can then be combined as needed using the Kronecker product).</p>
	 */
	protected abstract Vector<Complex>[][] getMappings();
	
	private void assertCorrectGateSize(int inputQubitCount) {
		if (qubitCount != inputQubitCount) {
			throw new IllegalArgumentException(
				"Tried to apply a "
				+ getClass().getSimpleName()
				+ " gate that operates on "
				+ qubitCount
				+ " qubits to "
				+ inputQubitCount
				+ " qubits"
			);
		}
	}
}
