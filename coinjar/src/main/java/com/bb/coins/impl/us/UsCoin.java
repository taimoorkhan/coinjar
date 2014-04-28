package com.bb.coins.impl.us;

import com.bb.coins.impl.AbstractCoin;

class UsCoin extends AbstractCoin{
	
	public UsCoin(UsMonetaryAmount m , UsVolume v) {
		super(m, v);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof UsCoin))
		{
			return false;
		}	
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
