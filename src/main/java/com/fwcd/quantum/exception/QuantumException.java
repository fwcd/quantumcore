package com.fwcd.quantum.exception;

/**
 * Common superclass for all quantum computing-
 * related exception.
 */
public class QuantumException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public QuantumException() {}
	
	public QuantumException(String msg) { super(msg); }
	
	public QuantumException(Throwable cause) { super(cause); }
	
	public QuantumException(String msg, Throwable cause) { super(msg, cause); }
}
