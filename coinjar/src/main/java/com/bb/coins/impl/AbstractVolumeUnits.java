package com.bb.coins.impl;

import com.bb.utils.measurements.VolumeUnits;

public class AbstractVolumeUnits  implements VolumeUnits{

	protected String units;
	protected AbstractVolumeUnits(String units){
		this.units = units;
	}
	
	@Override
	public String asString() {
		return units;
	}

}
