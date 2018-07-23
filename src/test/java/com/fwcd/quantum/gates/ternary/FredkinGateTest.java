package com.fwcd.quantum.gates.ternary;

import static com.fwcd.quantum.test.TestUtils.assertMatrixEquals;

import org.junit.Test;

public class FredkinGateTest {
	@Test
	public void testFredkin() {
		assertMatrixEquals(new FredkinGate(), new double[][] {
			{1, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1}
		});
	}
}
