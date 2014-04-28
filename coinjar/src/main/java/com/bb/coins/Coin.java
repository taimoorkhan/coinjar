package com.bb.coins;

import javax.validation.constraints.NotNull;

import com.bb.utils.measurements.MonetaryAmount;
import com.bb.utils.measurements.Volume;
/**
 * Represents the Coin data type.  Each coin has a monetary amount as well as volume. 
 */
public interface Coin{ 
	
	/**
	 * @return {@link Volume} of this coin.
	 */
	@NotNull
	public Volume getVolume();
	
	/**
	 * 
	 * @return {@link MonetaryAmount} of this coin.
	 */
	@NotNull
	public MonetaryAmount getMonetaryAmount();
}
