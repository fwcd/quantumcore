package com.fwcd.quantum.utils;

public final class BitMath {
	private BitMath() {}
	
	public static int extractBits(int number, int totalBits, int... bitIndices) {
		int result = 0;
		for (int i : bitIndices) {
			result = appendBit(result, getBit(number, totalBits, i));
		}
		return result;
	}
	
	public static int getBit(int number, int totalBits, int index) {
		return (number >> ((totalBits - 1) - index)) & 0b1;
	}
	
	public static int appendBit(int number, int bit) {
		return (number << 0b1) | bit;
	}
}
