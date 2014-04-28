package com.bb.coins.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.bb.coins.Coin;
import com.bb.coins.CoinJar;
import com.bb.coins.exceptions.CoinJarFullException;
import com.bb.utils.measurements.MonetaryAmount;
import com.bb.utils.measurements.Volume;

/**
 * This class represents an abstract coin jar. Concrete implementations can extend this to easily create
 * coin jars of different kinds.  Note this class in Not immutable and not thread safe.  Consumers of this
 * class will need to provide their own thread safety mechanism.
 */
public abstract class AbstractCoinJar implements CoinJar{

	/**
	 * This list can take various kinds of coins although it is not recommended to add different
	 * kinds of coins to this list.
	 */
	protected List<? super Coin> coins;
	
	/**
	 * This is the total volume of the coin jar.
	 */
	protected Volume size;
	
	/**
	 * This is the coin jar volume - total volume of coins added to this coin jar.
	 */
	protected Volume remainingVolume;
	
	/**
	 * This represents monetary value held by this coin jar.
	 */
	protected MonetaryAmount amount;
	
	/**
	 * Creates an abstract Coin jar with the given volume.
	 * @param size {@link Volume} represents the total volume of the jar.
	 */
	public AbstractCoinJar(@NotNull Volume size) {
		this.coins = new ArrayList<>();
		this.size = size;
		this.remainingVolume = size;
		this.amount = getZeroAmount();
	}
	
	/**
	 * Adds a coin to this coin jar.
	 * @param c - The coin to add. 
	 * @throws - a runtime exception in case the coin specs aren't supported by this coin jar.
	 */
	@Override
	public void addCoin(@NotNull Coin c) {
		if( c == null ) 
			throw new IllegalArgumentException("Trying to add a null coin");
				
		Volume volumeDifference =  remainingVolume.subtract(c.getVolume());
		if(volumeDifference.getValue().doubleValue() < 0){
			throw new CoinJarFullException("The coin jar doesn't have enough volume to accept this coin.");
		}
		coins.add(c);
		remainingVolume = remainingVolume.subtract(c.getVolume());
		amount  = amount.add(c.getMonetaryAmount());
	}

	/**
	 * @return  the total {link Volume} of this coin jar.
	 */
	@Override
	public Volume getSize() {
		return size;
	}

	/**
	 * @return the remaining volume capacity of this coin jar.
	 */
	@Override
	@NotNull
	public Volume getRemainingCapacity() {
		return remainingVolume;
	}

	/**
	 * This method empties the jar and resets the state of this coin jar.
	 */
	@Override
	public void emptyJar() {
		coins = new ArrayList<>();
		remainingVolume = size;
		this.amount = getZeroAmount();
	}
	
	/**
	 * Concrete implementations must provide an implementation of this method to return a 
	 * monetary amount representing the zero monetary amount.
	 * @return - zero monetary amount.
	 */
	@NotNull
	protected abstract MonetaryAmount getZeroAmount();

	/**
	 * @return - The monetary amount of this coin jar.
	 */
	@Override
	@NotNull
	public MonetaryAmount getMonetaryAmount() {
		return amount;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof AbstractCoinJar)){
			return false;
		}
		
		AbstractCoinJar other = (AbstractCoinJar) obj;
		return Objects.equals(this.coins, other.coins) && Objects.equals(this.amount, other.amount)
				&& Objects.equals(this.remainingVolume, other.remainingVolume) 
				&& Objects.equals(this.size, other.size);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.coins, this.amount, this.remainingVolume, this.size);
	}

}
