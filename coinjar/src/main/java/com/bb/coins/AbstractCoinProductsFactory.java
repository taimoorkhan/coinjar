package com.bb.coins;

import javax.validation.constraints.NotNull;

import com.bb.coins.exceptions.CoinDenominationNotSupportedException;

/**
 * This interface represents an AbstractFactory is used to create a family of related products.
 * In this case a concrete example of abstract factory will provide inter-operable coins and jars
 * to hold them.
 */
public interface AbstractCoinProductsFactory {
	/**
	 * This method returns a Coin instance representing the requested denomination.
	 * @param amount - the requested denomination
	 * @return {@link Coin} of the given denomination.
	 * @throws CoinDenominationNotSupportedException
	 */
	@NotNull
	public Coin mintCoin(@NotNull String amount) throws CoinDenominationNotSupportedException;
	
	/**
	 * This method will create a coin jar with the given volume and desired units.
	 * @param volume - the desired volume for the coin jar.
	 * @param units - the desired units for the coin jar.
	 * @return
	 */
	@NotNull
	public CoinJar makeCoinJar(@NotNull String volume,@NotNull String units);
}
