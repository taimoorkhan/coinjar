package com.bb.coins;

import com.bb.utils.measurements.MonetaryAmount;
import com.bb.utils.measurements.Volume;

public interface Coin{ 
	
	public Volume getVolume();
	public MonetaryAmount getMonetaryAmount();
}
