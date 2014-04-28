package com.bb.coins.impl.us;

import com.bb.utils.measurements.MonetaryUnits;

public abstract class UsMonetaryUnits implements MonetaryUnits{

	static final UsMonetaryUnits US_CENTS = new UsCentsMonetaryUnits();
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsMonetaryUnits)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}

class UsCentsMonetaryUnits extends UsMonetaryUnits{
	
	@Override
	public String asString() {
		return "us cents";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsCentsMonetaryUnits)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
