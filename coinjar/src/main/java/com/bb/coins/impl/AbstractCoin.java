package com.bb.coins.impl;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.bb.coins.Coin;
import com.bb.utils.measurements.MonetaryAmount;
import com.bb.utils.measurements.Volume;

/**
 * This is an abstract class representing a Coin.
 */
public abstract class AbstractCoin implements Coin {

	protected MonetaryAmount value;
	protected Volume volume;
	/**
	 * 
	 * @param value - This is the monetary amount of this coin.
	 * @param volume - This is the volume of this coin.
	 */
	public AbstractCoin(@NotNull MonetaryAmount value,@NotNull Volume volume) {
		this.value = value;
		this.volume = volume;
	}
	
	/**
	 * @return returns the volume of this coin.
	 */
	@NotNull
	public Volume getVolume() {
		return volume;
	}

	/**
	 * @return returns the monetary amount of this coin.
	 */
	@NotNull
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
