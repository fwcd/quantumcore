package com.fwcd.quantum.core;

/**
 * Represents an operation on a {@link QubitSuperposition}.
 */
@FunctionalInterface
public interface QuantumOperation {
	void apply(QubitSuperposition superpos);
}
