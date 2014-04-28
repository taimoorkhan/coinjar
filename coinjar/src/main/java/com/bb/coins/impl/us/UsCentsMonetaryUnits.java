package com.bb.coins.impl.us;

import com.bb.utils.measurements.MonetaryUnits;

public class UsCentsMonetaryUnits implements MonetaryUnits{

	static final UsCentsMonetaryUnits US_CENTS = new UsCentsMonetaryUnits();

	@Override
	public String asString() {
		return "us cents";
	}
}
