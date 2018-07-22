package com.fwcd.quantum.core;

import com.fwcd.quantum.gates.QuantumGate;

public class QuantumGateOperation implements QuantumOperation {
	private final QuantumGate gate;
	private final int[] qubitIndices;
	
	public QuantumGateOperation(QuantumGate gate, int... qubitIndices) {
		this.gate = gate;
		this.qubitIndices = qubitIndices;
	}
	
	public QuantumGate getGate() {
		return gate;
	}
	
	@Override
	public void apply(QubitSuperposition superpos) {
		superpos.apply(gate, qubitIndices);
	}
	
	@Override
	public String toString() {
		return gate.getClass().getSimpleName();
	}
}
