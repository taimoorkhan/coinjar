package com.bb.coins.impl.us;

import java.math.BigDecimal;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

import com.bb.coins.impl.AbstractVolumeConverter;
import com.bb.utils.measurements.Volume;
import com.bb.utils.measurements.VolumeUnits;

/**
 * Class for converting between different us volumes.
 * Currently only two volumes are supported : FLuid ounces and Micro Fluid ounces.
 * This class is immutable and thread safe.
 */
@ThreadSafe
@Immutable
public class UsVolumeConverter extends AbstractVolumeConverter{

	/**
	 * Singleton multiplication factor representing a mega/micro value.
	 */
	static BigDecimal MICRO_MULTIPLIER = new BigDecimal("1000000");
	
	/**
	 * This method converts a us volume to the requested units.  The returned volume is 
	 * another immutable us volume.
	 */
	@Override
	@NotNull
	public Volume convert(@NotNull Volume from, @NotNull VolumeUnits toUnits) {
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
	
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof UsVolumeConverter)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
