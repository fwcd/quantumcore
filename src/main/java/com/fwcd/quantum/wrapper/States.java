package com.fwcd.quantum.wrapper;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.Numbers;
import com.fwcd.fructose.math.Vector;

public final class States {
	public static final Vector<Complex> ONE = Numbers.complexVector(0, 1);
	public static final Vector<Complex> ZERO = Numbers.complexVector(1, 0);
	
	private States() {}
}
