package com.bb.coins.impl.us;

import java.math.BigDecimal;

import com.bb.utils.measurements.MonetaryAmount;

public class UsMonetaryAmounts {
	public static final UsMonetaryAmount ZERO = new UsMonetaryAmount(new BigDecimal("0"));
	public static final UsMonetaryAmount ONE = new UsMonetaryAmount(new BigDecimal("1"));
	public static final UsMonetaryAmount FIVE = new UsMonetaryAmount(new BigDecimal("5"));
	public static final UsMonetaryAmount TEN = new UsMonetaryAmount(new BigDecimal("10"));
	public static final UsMonetaryAmount TWENTY_FIVE = new UsMonetaryAmount(new BigDecimal("25"));
	public static final UsMonetaryAmount HALF_DOLLAR = new UsMonetaryAmount(new BigDecimal("50"));
	
}

class UsMonetaryAmount extends MonetaryAmount{
	
	public UsMonetaryAmount(BigDecimal number ){
		super(number , UsMonetaryUnits.US_CENTS);
	}

	@Override
	public MonetaryAmount add(MonetaryAmount other) {
		if(! (other instanceof UsMonetaryAmount)){
			throw new IllegalArgumentException("Can only add monetary amounts of the same type");
		}
		
		if(other instanceof UsMonetaryAmount){
			return new UsMonetaryAmount(this.getValue().add(other.getValue()));
		}
		
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsMonetaryAmount)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
