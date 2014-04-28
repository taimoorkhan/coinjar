package com.bb.coins;

import com.bb.utils.measurements.MonetaryAmount;
import com.bb.utils.measurements.Volume;


public interface CoinJar {

	public void addCoin(Coin c); //should throw illegalArgument exception if the coin passed is not of the correct type for this jar.
	public Volume getSize();
	public Volume getRemainingCapacity();
	public void emptyJar();
	public MonetaryAmount getMonetaryAmount();
}
