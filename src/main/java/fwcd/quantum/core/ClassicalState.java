package fwcd.quantum.core;

import java.util.Arrays;
import java.util.List;

import fwcd.fructose.ListUtils;
import fwcd.fructose.math.Complex;
import fwcd.fructose.math.ExtMath;
import fwcd.fructose.math.Vector;

/**
 * An immutable sequence of bits.<br><br>
 * 
 * Thus it can contain a collapsed superposition.
 * If the original {@link QubitSuperposition} was initialized
 * with 3 qubits and it's superposition consisted of
 * 2^3 values, then this result will contain 3 values
 * again.
 */
public class ClassicalState {
	private final boolean[] bits;
	
	private ClassicalState(int binaryRepresentation, int totalBits) {
		char[] bitChars = ExtMath.binaryString(binaryRepresentation, totalBits).toCharArray();
		bits = new boolean[bitChars.length];
		
		int i = 0;
		for (char bitChar : bitChars) {
			bits[i] = (bitChar == '1');
			i++;
		}
	}
	
	private ClassicalState(boolean... bits) {
		this.bits = bits;
	}
	
	public static ClassicalState empty() {
		return new ClassicalState();
	}
	
	public static ClassicalState ofBinary(int binaryRepresentation, int totalBits) {
		return new ClassicalState(binaryRepresentation, totalBits);
	}
	
	public static ClassicalState of(boolean... bits) {
		return new ClassicalState(bits);
	}
	
	public static ClassicalState of(int... bits) {
		boolean[] boolBits = new boolean[bits.length];
		for (int i=0; i<bits.length; i++) {
			int bit = bits[i];
			if (bit == 1) {
				boolBits[i] = true;
			} else if (bit == 0) {
				boolBits[i] = false;
			} else {
				throw new IllegalArgumentException("Tried to create a classical state of non [1, 0]-values");
			}
		}
		return new ClassicalState(boolBits);
	}
	
	/**
	 * Creates a new {@link ClassicalState} containing all the bits of
	 * this state plus a given bit.
	 * 
	 * @param bit - The appended bit
	 * @return The concatenated state
	 */
	public ClassicalState withBit(boolean bit) {
		int bitsAmount = bits.length;
		boolean[] newQubits = new boolean[bitsAmount + 1];
		
		System.arraycopy(bits, 0, newQubits, 0, bitsAmount);
		newQubits[bitsAmount] = bit;
		
		return new ClassicalState(newQubits);
	}
	
	public ClassicalState kronecker(ClassicalState rhs) {
		boolean[] combined = new boolean[bits.length + rhs.bits.length];
		System.arraycopy(bits, 0, combined, 0, bits.length);
		System.arraycopy(rhs.bits, 0, combined, bits.length, rhs.bits.length);
		return new ClassicalState(combined);
	}
	
	public Vector<Complex> asStateVector() {
		List<Complex> result = ListUtils.makeList(bits.length, i -> Complex.ZERO);
		result.set(toInt(), Complex.ONE);
		return new Vector<>(result);
	}
	
	public boolean bitAt(int index) {
		return bits[index];
	}
	
	/**
	 * @return The bits in this register.
	 */
	public boolean[] getBits() {
		return bits;
	}
	
	/**
	 * @return An integer containing the binary representation of this qubit state
	 */
	public int toInt() {
		int v = 0;
		
		for (boolean bit : bits) {
			v = (v << 1) | (bit ? 1 : 0);
		}
		
		return v;
	}
	
	@Override
	public String toString() {
		String result = "[Classical] ";
		
		for (boolean bit : bits) {
			result += bit ? "1" : "0";
		}
		
		return result;
	}

	public int bitCount() {
		return bits.length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bits);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ClassicalState other = (ClassicalState) obj;
		if (!Arrays.equals(bits, other.bits)) {
			return false;
		}
		return true;
	}
}

