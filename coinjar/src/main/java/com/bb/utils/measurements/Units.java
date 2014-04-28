package com.bb.utils.measurements;

import javax.validation.constraints.NotNull;

/**
 * Base type to represent any unit which can be represented as a String.
 */
public interface Units {
	@NotNull
	String asString();
}
