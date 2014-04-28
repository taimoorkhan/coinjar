package com.bb.coins.impl.us;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

import com.bb.coins.impl.AbstractCoin;

/**
 * Concrete {@link Coin} implementation representing U.S. coins.  The monetary units for all us coins
 * are in us cents.  This class is immutable and therefore is thread-safe.
 */
@Immutable
@ThreadSafe
class UsCoin extends AbstractCoin{
	
	/**
	 * Constructor for creating us coins.  
	 * @param m - is the type safe us monetary amount.
	 * @param v - is the typesafe us volume.
	 */
	public UsCoin(@NotNull UsMonetaryAmount m ,@NotNull UsVolume v) {
		super(m, v);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof UsCoin))
		{
			return false;
		}	
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
