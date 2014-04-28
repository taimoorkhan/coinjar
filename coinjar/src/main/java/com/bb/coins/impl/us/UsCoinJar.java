package com.bb.coins.impl.us;

import javax.validation.constraints.NotNull;

import com.bb.coins.impl.AbstractCoinJar;
import com.bb.utils.measurements.MonetaryAmount;

/**
 * Concrete class for creating coin jars for holding us coins.  This class is not thread safe as it 
 * inherits from the {@link AbstractCoinJar} which is not thread safe.
 */
public class UsCoinJar extends AbstractCoinJar{

	/**
	 * Constructor
	 * @param size - the desired type safe volume for this coin jar.
	 */
	public UsCoinJar(@NotNull UsVolume size) {
		super(size);
	}

	/**
	 * @return the zero monetary us amount.
	 */
	@Override
	protected MonetaryAmount getZeroAmount() {
		return UsMonetaryAmounts.ZERO;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsCoinJar)){
			return false;
		}
		return super.equals(obj);
	}

}
