package fwcd.quantum.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitMathTest {
	@Test
	public void extractBitsTest() {
		int[] indices = {0, 2, 1};
		assertEquals(0b101, BitMath.extractBits(0b11001, 5, indices));
		int[] indices2 = {0, 1};
		assertEquals(0b01, BitMath.extractBits(0b010, 3, indices2));
	}
	
	@Test
	public void getBitTest() {
		assertEquals(1, BitMath.getBit(0b11011, 5, 1));
		assertEquals(0, BitMath.getBit(0b110, 3, 2));
		assertEquals(1, BitMath.getBit(0b010, 3, 1));
		assertEquals(0, BitMath.getBit(0b0100, 4, 0));
	}
	
	@Test
	public void appendBitTest() {
		assertEquals(0b1011, BitMath.appendBit(0b101, 1));
		assertEquals(0b111110, BitMath.appendBit(0b11111, 0));
	}
}
