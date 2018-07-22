package com.fwcd.quantum.gates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fwcd.fructose.math.Complex;
import com.fwcd.fructose.math.ExtMath;
import com.fwcd.fructose.math.Vector;

/**
 * <p>Contains the mappings in a "truth table" form.
 * The outer list contains the "rows" of the mapped results.
 * Example of a 2-qubit identity gate:</p>
 * 
 * <pre>
 * |00> to [|0>, |0>],
 * |01> to [|0>, |1>],
 * |10> to [|1>, |0>],
 * |11> to [|1>, |1>]
 * </pre>
 * 
 * <p>Kets can be conveniently created using Ket.ONE or Ket.ZERO.
 * The main difference between this approach and a matrix-based approach
 * is that this function yields the results of each mapping in
 * factorized form (they can then be combined as needed using the Kronecker product).</p>
 */
public class StateMappingTable {
	private final List<List<Vector<Complex>>> table;
	
	private StateMappingTable() {
		table = new ArrayList<>();
	}
	
	public static class Builder {
		private final StateMappingTable instance;
		
		public Builder() { instance = new StateMappingTable(); }
		
		@SafeVarargs
		public final Builder mapTo(Vector<Complex>... factors) {
			instance.table.add(Arrays.asList(factors));
			return this;
		}
		
		public StateMappingTable build() { return instance; }
	}
	
	public List<Vector<Complex>> mappedFactorsOf(int binaryState) {
		return new ArrayList<>(table.get(binaryState));
	}
	
	public int qubitCount() { return ExtMath.log2Floor(table.size()); } 
}
