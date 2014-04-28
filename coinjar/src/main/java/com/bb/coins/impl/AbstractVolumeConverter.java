package com.bb.coins.impl;

import com.bb.utils.measurements.Volume;
import com.bb.utils.measurements.VolumeConverter;
import com.bb.utils.measurements.VolumeUnits;

public abstract class AbstractVolumeConverter implements VolumeConverter{

	protected AbstractVolumeConverter(){
		
	}
	
	@Override
	public abstract Volume convert(Volume from, VolumeUnits toUnits) ;

}
