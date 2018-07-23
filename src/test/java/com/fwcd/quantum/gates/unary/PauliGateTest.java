package com.fwcd.quantum.gates.unary;

import static com.fwcd.quantum.test.TestUtils.assertMatrixEquals;

import org.junit.Test;

public class PauliGateTest {
	@Test
	public void testX() {
		assertMatrixEquals(new PauliXGate(), new double[][][] {
			{{0, 0}, {1, 0}},
			{{1, 0}, {0, 0}}
		});
	}
	
	@Test
	public void testY() {
		assertMatrixEquals(new PauliYGate(), new double[][][] {
			{{0, 0}, {0, -1}},
			{{0, 1}, {0, 0}}
		});
	}
	
	@Test
	public void testZ() {
		assertMatrixEquals(new PauliZGate(), new double[][][] {
			{{1, 0}, {0, 0}},
			{{0, 0}, {-1, 0}}
		});
	}
}
