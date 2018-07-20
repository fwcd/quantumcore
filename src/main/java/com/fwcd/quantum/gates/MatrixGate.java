package com.fwcd.quantum.gates;

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
	private final Matrix<Complex> identity = Numbers.complexMatrix(new double[][] {
			{1, 0},
			{0, 1}
	});
	private final Matrix<Complex> matrix = getMatrix();
	private final int minQubits = minQubits();
	
	@Override
	public Vector<Complex> apply(Vector<Complex> possibleStates, int qubitIndex) {
		int totalQubits = ExtMath.log2Floor(possibleStates.size());
		
		if (qubitIndex > (totalQubits - minQubits)) {
			throw new IllegalArgumentException(
					"Qubit index "
					+ Integer.toString(qubitIndex)
					+ " too large for an input of "
					+ Integer.toString(totalQubits)
					+ " qubits and a gate requiring "
					+ Integer.toString(minQubits)
					+ " qubits!"
			);
		}
		
		Matrix<Complex> customMatrix = getCustomMatrix(totalQubits, qubitIndex);
		try {
			return customMatrix.multiply(possibleStates);
		} catch (IllegalArgumentException e) {
			// TODO: Rework this case
			throw new IncompatibleGateException(getClass().getSimpleName(), possibleStates, matrix);
		}
	}

	private Matrix<Complex> getCustomMatrix(int totalQubits, int qubitIndex) {
		Matrix<Complex> result = null;
		
		int i = 0;
		while (i < totalQubits) {
			Matrix<Complex> factor;
			
			if (i == qubitIndex) {
				factor = matrix;
				i += minQubits - 1;
			} else {
				factor = identity;
			}
			
			if (result == null) {
				result = factor;
			} else {
				result = result.tensorProduct(factor);
			}
			
			i++;
		}
		
		return result;
	}
	
	/**
	 * Fetches the permutation matrix for this gate.
	 * 
	 * @return The permutation matrix
	 */
	protected abstract Matrix<Complex> getMatrix();
	
	public int minQubits() {
		return ExtMath.log2Floor(matrix.width());
	}
}
