package com.bb.coins.impl.us;

import com.bb.coins.impl.AbstractCoinJar;
import com.bb.utils.measurements.MonetaryAmount;

public class UsCoinJar extends AbstractCoinJar{

	public UsCoinJar(UsVolume size) {
		super(size);
	}

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
