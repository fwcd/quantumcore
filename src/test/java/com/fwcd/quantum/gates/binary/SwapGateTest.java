package com.fwcd.quantum.gates.binary;

import static com.fwcd.quantum.test.TestUtils.assertMatrixEquals;

import org.junit.Test;

public class SwapGateTest {
	@Test
	public void testSwap() {
		assertMatrixEquals(new SwapGate(), new double[][] {
			{1, 0, 0, 0},
			{0, 0, 1, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 1}
		});
	}
}
