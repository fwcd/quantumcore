package com.fwcd.quantum.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.OptionalInt;

import org.junit.Test;

public class ArrayUtilsTest {
	@Test
	public void testIntRange() {
		assertArrayEquals(new int[] {1, 2, 3}, ArrayUtils.intRange(1, 4));
		assertArrayEquals(new int[] {-1, 0}, ArrayUtils.intRange(-1, 1));
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(OptionalInt.of(1), ArrayUtils.indexOf(23, new int[] {-3, 23, 9}));
		assertEquals(OptionalInt.empty(), ArrayUtils.indexOf(9, new int[] {2}));
	}
}
