package com.fwcd.quantum.utils;

import java.util.OptionalInt;

public final class ArrayUtils {
	private ArrayUtils() {}
	
	public static final OptionalInt indexOf(int element, int[] array) {
		for (int i=0; i<array.length; i++) {
			if (array[i] == element) { return OptionalInt.of(i); }
		}
		return OptionalInt.empty();
	}
}
