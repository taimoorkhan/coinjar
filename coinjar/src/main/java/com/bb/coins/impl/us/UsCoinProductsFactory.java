package com.bb.coins.impl.us;

import java.math.BigDecimal;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

import com.bb.coins.AbstractCoinProductsFactory;
import com.bb.coins.Coin;
import com.bb.coins.CoinJar;
import com.bb.coins.exceptions.CoinDenominationNotSupportedException;

/**
 * This is the concrete implementation of the abstract factory of coin products.
 * This class is immutable and thread safe.
 */
@ThreadSafe
@Immutable
public class UsCoinProductsFactory implements AbstractCoinProductsFactory{

	private static final String ONE_CENT_STR = "1";
	private static final String FIVE_CENTS_STR = "5";
	private static final String TEN_CENTS_STR = "10";
	private static final String TWENTY_FIVE_CENT_STR = "25";
	private static final String HALF_DOLLAR_STR = "50";
	
	
	private static final UsCoin ONE_CENT = new UsCoin( UsMonetaryAmounts.ONE, UsVolumes.ONE_CENT_MICRO_FLUID_OUNCES );
	private static final UsCoin FIVE_CENTS = new UsCoin(UsMonetaryAmounts.FIVE , UsVolumes.FIVE_CENTS_MICRO_FLUID_OUNCES);
	private static final UsCoin TEN_CENTS = new UsCoin(UsMonetaryAmounts.TEN, UsVolumes.TEN_CENTS_MICRO_FLUID_OUNCES);
	private static final UsCoin TWENTY_FIVE_CENTS = new UsCoin(UsMonetaryAmounts.TWENTY_FIVE, UsVolumes.TWENTY_FIVE_CENTS_MICRO_FLUID_OUNCES);
	private static final UsCoin HALF_DOLLAR = new UsCoin(UsMonetaryAmounts.HALF_DOLLAR, UsVolumes.TWENTY_FIVE_CENTS_MICRO_FLUID_OUNCES);
	
	/**
	 * @return - a coin of the requested denomination.  Since {@link Coin} are supposed to be immutable
	 * we can use a flyweight objects.
	 */
	@NotNull
	public Coin mintCoin(@NotNull String denomination)  {
		if(denomination == null){
			throw new IllegalArgumentException("Can not pass null denomination");
		}
		switch(denomination){
		case ONE_CENT_STR:
			return ONE_CENT;
		case FIVE_CENTS_STR:
			return FIVE_CENTS;
		case TEN_CENTS_STR:
			return TEN_CENTS;
		case TWENTY_FIVE_CENT_STR:
			return TWENTY_FIVE_CENTS;
		case HALF_DOLLAR_STR:
			return HALF_DOLLAR;
		default:
			throw new CoinDenominationNotSupportedException("Invalid us monetary denomination requested.");
		}
	}

	/**
	 * @return - returns a coin jar of the requested volume with requested volume units.
	 */
	@Override
	@NotNull
	public CoinJar makeCoinJar(@NotNull String v,@NotNull String units) {
		
		BigDecimal scalarValue = new BigDecimal(v);
		if(scalarValue.doubleValue() <= 0){
			throw new IllegalArgumentException("Volume amount can not be negative or zero");
		}
		
		UsCoinJar jar = new UsCoinJar(UsVolumes.makeVolume(scalarValue, units));
		return jar;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsCoinProductsFactory)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}


