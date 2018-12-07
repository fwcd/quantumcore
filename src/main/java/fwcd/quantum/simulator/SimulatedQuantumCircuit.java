package fwcd.quantum.simulator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fwcd.quantum.core.QuantumGateOperation;
import fwcd.quantum.core.ClassicalState;
import fwcd.quantum.core.QubitSuperposition;
import fwcd.quantum.gates.QuantumGate;

public class SimulatedQuantumCircuit implements Iterable<QuantumGateOperation> {
	private ClassicalState inputState = ClassicalState.empty();
	private List<QuantumGateOperation> operations = new ArrayList<>();
	
	public void setInputQubit(int index, boolean value) {
		inputState.getBits()[index] = value;
	}
	
	public ClassicalState getInputState() {
		return inputState;
	}
	
	public int qubitCount() {
		return inputState.bitCount();
	}
	
	public void addQubit(boolean initialState) {
		inputState = inputState.withBit(initialState);
	}
	
	public void addGate(QuantumGate gate, int... qubitIndices) {
		operations.add(new QuantumGateOperation(gate, qubitIndices));
	}
	
	public QubitSuperposition compute() {
		QubitSuperposition superpos = new SimulatedSuperposition(inputState);
		
		for (QuantumGateOperation operation : operations) {
			operation.apply(superpos);
		}
		
		return superpos;
	}
	
	public ClassicalState computeResult() {
		return compute().measure();
	}

	@Override
	public Iterator<QuantumGateOperation> iterator() {
		return operations.iterator();
	}
	
	@Override
	public String toString() {
		return operations.toString();
	}
}
