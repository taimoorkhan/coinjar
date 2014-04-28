package com.bb.coins.impl;

import java.util.ArrayList;
import java.util.List;

import com.bb.coins.Coin;
import com.bb.coins.CoinJar;
import com.bb.coins.exceptions.CoinJarFullException;
import com.bb.utils.measurements.MonetaryAmount;
import com.bb.utils.measurements.Volume;

public abstract class AbstractCoinJar implements CoinJar{

	protected List<Coin> coins;
	protected Volume size;
	protected Volume remainingVolume;
	protected MonetaryAmount amount;
	
	
	public AbstractCoinJar(Volume size) {
		this.coins = new ArrayList<>();
		this.size = size;
		this.remainingVolume = size;
		this.amount = getZeroAmount();
	}
	@Override
	public void addCoin(Coin c) {
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

	@Override
	public Volume getSize() {
		return size;
	}

	@Override
	public Volume getRemainingCapacity() {
		return remainingVolume;
	}

	@Override
	public void emptyJar() {
		coins = new ArrayList<>();
		remainingVolume = size;
		this.amount = getZeroAmount();
		
	}
	
	protected abstract MonetaryAmount getZeroAmount();

	@Override
	public MonetaryAmount getMonetaryAmount() {
		return amount;
	}

}
