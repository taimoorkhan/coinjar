package com.bb.coins;

import javax.validation.constraints.NotNull;

import com.bb.utils.measurements.MonetaryAmount;
import com.bb.utils.measurements.Volume;

/**
 * This is the coin jar abstraction.  One can add coins to a coin jar, ask for its volume {@link Volume},
 * check its remaining volume, get the monetary amount {@link MonetaryAmount} and empty the jar. 
 */
public interface CoinJar {

	/**
	 * Use this method to add a coin to this coin jar.
	 * @param c - the {@link Coin} to add
	 * @throws - this method can throw a runtime exception if there is a mismatch between the coin type
	 * and the coin jar.
	 */
	public void addCoin(@NotNull Coin c); 
	
	/**
	 * @return {@link Volume} of this coin jar.
	 */
	@NotNull
	public Volume getSize();
	
	/**
	 * @return {@link Volume} of the remaining capacity of this coin jar.
	 */
	@NotNull
	public Volume getRemainingCapacity();
	
	/**
	 * This method empties the coin jar.  The remaining amount is reset and the monetary amount is set to 0.
	 */
	public void emptyJar();
	
	/**
	 * This method returns the total monetary amount of the coins added to this coin jar.
	 * @return {@link MonetaryAmount} object representing the monetary amount of this coin jar.
	 */
	public MonetaryAmount getMonetaryAmount();
}
