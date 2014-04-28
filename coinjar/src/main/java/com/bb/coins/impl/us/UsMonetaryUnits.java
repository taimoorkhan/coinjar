package com.bb.coins.impl.us;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

import com.bb.utils.measurements.MonetaryUnits;

/**
 * This is the abstract base class for all U.S. monetary units.
 * This class is Thead safe and immutable.
 */
@Immutable
@ThreadSafe
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

/**
 * This class represents the U.S. cents monetary units.
 * This class is immutable and thread safe.
 */
@Immutable
@ThreadSafe
class UsCentsMonetaryUnits extends UsMonetaryUnits{
	
	@Override
	@NotNull
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
