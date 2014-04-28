package com.bb.coins.impl.us;

import java.math.BigDecimal;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

import com.bb.utils.measurements.MonetaryAmount;

/**
 * Represents a utility class listing the supported us monetary amounts.
 */
public class UsMonetaryAmounts {
	public static final UsMonetaryAmount ZERO = new UsMonetaryAmount(new BigDecimal("0"));
	public static final UsMonetaryAmount ONE = new UsMonetaryAmount(new BigDecimal("1"));
	public static final UsMonetaryAmount FIVE = new UsMonetaryAmount(new BigDecimal("5"));
	public static final UsMonetaryAmount TEN = new UsMonetaryAmount(new BigDecimal("10"));
	public static final UsMonetaryAmount TWENTY_FIVE = new UsMonetaryAmount(new BigDecimal("25"));
	public static final UsMonetaryAmount HALF_DOLLAR = new UsMonetaryAmount(new BigDecimal("50"));
	
}

/**
 * Base class for US monteary amounts.
 *
 */
@Immutable
@ThreadSafe
class UsMonetaryAmount extends MonetaryAmount{
	
	/**
	 * Constructor for UsMonetaryAmount.
	 * @param number - the scalar value of the monetary amount.  Sicne all monetary amoutns
	 * are only in us cents, therefore we don't need to specifically pass in the monetary units.
	 * This class is immutable and thread safe.
	 */
	public UsMonetaryAmount(@NotNull BigDecimal number ){
		super(number , UsMonetaryUnits.US_CENTS);
		if(number.doubleValue() < 0 ) throw new IllegalArgumentException("Negative monetary amount is not supported in this version.");
	}

	/**
	 * @return a new MonetaryAmount object representing the current amount + new amount.
	 */
	@Override
	@NotNull
	public MonetaryAmount add(@NotNull MonetaryAmount other) {
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
