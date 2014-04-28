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
	
	@NotNull
	public CoinJar makeCoinJar(@NotNull String volume,@NotNull String units);
}
