package fwcd.quantum.gates.ternary;

import static fwcd.quantum.test.TestUtils.assertMatrixEquals;

import org.junit.Test;

public class ToffoliGateTest {
	@Test
	public void testToffoli() {
		assertMatrixEquals(new ToffoliGate(), new double[][] {
			{1, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 1, 0}
		});
	}
}
