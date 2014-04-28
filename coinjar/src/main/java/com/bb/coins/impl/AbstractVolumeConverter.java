package com.bb.coins.impl;

import javax.validation.constraints.NotNull;

import com.bb.utils.measurements.Volume;
import com.bb.utils.measurements.VolumeConverter;
import com.bb.utils.measurements.VolumeUnits;

/**
 * A base class for converting volumes.
 */
public abstract class AbstractVolumeConverter implements VolumeConverter{

	protected AbstractVolumeConverter(){
		
	}
	
	/**
	 * Converts the 'from' volume to a volume with 'toUnits'.
	 * @return - the converted volume in the units of the toUnits;
	 */
	@Override
	public abstract Volume convert(@NotNull Volume from, @NotNull VolumeUnits toUnits) ;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof AbstractVolumeConverter)){
			return false;
		}
		return super.equals(obj);
	}

}
