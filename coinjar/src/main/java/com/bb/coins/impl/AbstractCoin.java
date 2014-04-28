package com.bb.coins.impl;

import java.util.Objects;

import com.bb.coins.Coin;
import com.bb.utils.measurements.MonetaryAmount;
import com.bb.utils.measurements.Volume;

public abstract class AbstractCoin implements Coin {

	protected MonetaryAmount value;
	protected Volume volume;
	
	public AbstractCoin(MonetaryAmount value, Volume volume) {
		this.value = value;
		this.volume = volume;
	}
	
	public Volume getVolume() {
		return volume;
	}

	public MonetaryAmount getMonetaryAmount() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value, volume);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof AbstractCoin ))
		{
			return false;
		}
		AbstractCoin c = (AbstractCoin)obj;
		return Objects.equals(this.value , c.value) && Objects.equals(this.volume, c.volume);
	}
}
