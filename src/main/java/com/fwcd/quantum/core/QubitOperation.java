package com.fwcd.quantum.core;

/**
 * Represents an operation on a {@link QubitSuperpos}.
 */
@FunctionalInterface
public interface QubitOperation {
	QubitSuperpos apply(QubitSuperpos superpos);
}
