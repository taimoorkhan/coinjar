package com.bb.coins.impl;

import java.util.Objects;

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
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof AbstractVolumeUnits)){
			return false;
		}
		AbstractVolumeUnits other = (AbstractVolumeUnits)obj;
		
		return Objects.equals(this.units, other.units);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.units);
	}
}
