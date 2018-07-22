package com.fwcd.quantum.wrapper;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.fructose.math.Vector;

/**
 * Convenience class to create state vectors. The name is
 * derived from the Dirac notation which can be used to represent
 * quantum state vectors compactly.
 */
public final class Ket {
	public static final Vector<Complex> ONE = Numbers.complexVector(0, 1);
	public static final Vector<Complex> ZERO = Numbers.complexVector(1, 0);
	
	private Ket() {}
	
	public static Vector<Complex> ofBit(int bit) {
		if (bit == 0) {
			return ZERO;
		} else if (bit == 1) {
			return ONE;
		} else {
			throw new IllegalArgumentException(bit + " is not a bit (1 or 0)");
		}
	}
}
