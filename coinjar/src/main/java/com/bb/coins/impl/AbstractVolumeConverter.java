package com.bb.coins.impl;

import com.bb.utils.measurements.Volume;
import com.bb.utils.measurements.VolumeConverter;
import com.bb.utils.measurements.VolumeUnits;

public abstract class AbstractVolumeConverter implements VolumeConverter{

	protected AbstractVolumeConverter(){
		
	}
	
	@Override
	public abstract Volume convert(Volume from, VolumeUnits toUnits) ;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof AbstractVolumeConverter)){
			return false;
		}
		return super.equals(obj);
	}

}
