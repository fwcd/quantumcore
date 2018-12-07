package fwcd.quantum.utils;

import java.util.OptionalInt;

public final class ArrayUtils {
	private ArrayUtils() {}
	
	public static final OptionalInt indexOf(int element, int[] array) {
		for (int i=0; i<array.length; i++) {
			if (array[i] == element) { return OptionalInt.of(i); }
		}
		return OptionalInt.empty();
	}
	
	public static final int[] intRange(int inclusiveStart, int exclusiveEnd) {
		int length = exclusiveEnd - inclusiveStart;
		int[] range = new int[length];
		for (int i=0; i<length; i++) {
			range[i] = i + inclusiveStart;
		}
		return range;
	}
}
