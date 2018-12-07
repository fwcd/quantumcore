package fwcd.quantum.gates.binary;

import static fwcd.quantum.test.TestUtils.assertMatrixEquals;

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
