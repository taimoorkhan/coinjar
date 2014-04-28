package com.bb.coins;

import com.bb.coins.exceptions.CoinDenominationNotSupportedException;

public interface AbstractCoinProductsFactory {
	public Coin mintCoin(String amount) throws CoinDenominationNotSupportedException;
	public CoinJar makeCoinJar(String volume, String units);
}
