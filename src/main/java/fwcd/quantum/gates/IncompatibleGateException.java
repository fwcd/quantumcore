package fwcd.quantum.gates;

import fwcd.fructose.math.Complex;
import fwcd.fructose.math.Matrix;
import fwcd.fructose.math.Vector;

public class IncompatibleGateException extends RuntimeException {
	private static final long serialVersionUID = -48723648763L;
	
	public IncompatibleGateException(String gateName, Vector<Complex> superpos, Matrix<Complex> incompatibleMatrix) {
		super(
				"The quantum gate "
				+ gateName
				+ " requires a superposition with "
				+ Integer.toString(superpos.size())
				+ " states, not "
				+ Integer.toString(incompatibleMatrix.width())
				+ "!"
		);
	}
}
