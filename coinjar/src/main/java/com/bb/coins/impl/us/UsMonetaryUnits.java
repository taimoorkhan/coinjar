package com.bb.coins.impl.us;

import com.bb.utils.measurements.MonetaryUnits;

public abstract class UsMonetaryUnits implements MonetaryUnits{

	static final UsMonetaryUnits US_CENTS = new UsCentsMonetaryUnits();
	
}

class UsCentsMonetaryUnits extends UsMonetaryUnits{
	
	@Override
	public String asString() {
		return "us cents";
	}
}
