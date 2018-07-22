package com.fwcd.quantum.test;

import com.fwcd.fructose.operations.ToleranceEquatable;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public final class TestUtils {
	private TestUtils() {}
	
	public static <V extends ToleranceEquatable<V>> Matcher<V> approxEquals(V expected, double tolerance) {
		return new BaseMatcher<V>() {
			@Override
			@SuppressWarnings("unchecked")
			public boolean matches(Object item) {
				return ((V) item).equals(expected, tolerance);
			}
			
			@Override
			public void describeTo(Description description) {
				description
						.appendValue(expected.getClass())
						.appendText(" should equal ")
						.appendValue(expected);
			}
		};
	}
}
