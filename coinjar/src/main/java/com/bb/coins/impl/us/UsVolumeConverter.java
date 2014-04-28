package com.bb.coins.impl.us;

import java.math.BigDecimal;

import com.bb.coins.impl.AbstractVolumeConverter;
import com.bb.utils.measurements.Volume;
import com.bb.utils.measurements.VolumeUnits;

public class UsVolumeConverter extends AbstractVolumeConverter{

	static BigDecimal MICRO_MULTIPLIER = new BigDecimal("1000000");
	@Override
	public Volume convert(Volume from, VolumeUnits toUnits) {
		if(! (from instanceof UsVolume) || (!(toUnits instanceof UsVolumeUnits))){
			throw new IllegalArgumentException("Was expecting us units");
		}
		
		if(from.getUnits().getClass() == toUnits.getClass()){ //units are same no need to convert.
			return from;
		}
		
		if(from.getUnits().getClass() == UsFluidOunceVolumeUnits.class){
			BigDecimal fromValue = from.getValue().multiply(MICRO_MULTIPLIER);
			return new UsVolume(fromValue, UsVolumeUnits.MICRO_FLUID_OUNCES);
		}
		else if(from.getUnits().getClass() == UsMicroFluidOuncesVolumeUnits.class){
			BigDecimal fromValue = from.getValue().divide(MICRO_MULTIPLIER);
			return new UsVolume(fromValue, UsVolumeUnits.FLUID_OUNCES);
		}
		else
		{
			throw new IllegalArgumentException("Trying to convert an unknown us volume.");
		}
	}
	
	
	

}
