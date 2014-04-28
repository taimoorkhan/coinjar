package com.bb.coins.impl.us;

import java.math.BigDecimal;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

import com.bb.utils.measurements.Volume;

/**
 * Utility class to list some canned U.S. Volumes and a method to make new us volumes.
 * This class is immutable and thread safe.
 */
@Immutable
@ThreadSafe
public class UsVolumes {
	// Choosing to deal with longs so we won't have to deal with rounding and equality problems with floats and doubles.
	public static final UsVolume ONE_CENT_MICRO_FLUID_OUNCES = new UsVolume( new BigDecimal("12200"), UsVolumeUnits.MICRO_FLUID_OUNCES); // 0.0122 fluid ounces
	public static final UsVolume FIVE_CENTS_MICRO_FLUID_OUNCES = new UsVolume(new BigDecimal("24300"), UsVolumeUnits.MICRO_FLUID_OUNCES); //0.0243 fluid ounces
	public static final UsVolume TEN_CENTS_MICRO_FLUID_OUNCES = new UsVolume( new BigDecimal("11500"), UsVolumeUnits.MICRO_FLUID_OUNCES); //0.0115 fluid ounces
	public static final UsVolume TWENTY_FIVE_CENTS_MICRO_FLUID_OUNCES = new UsVolume( new BigDecimal("27000"), UsVolumeUnits.MICRO_FLUID_OUNCES); //0.027 fluid ounces 
	public static final UsVolume HALF_DOLLAR_MICRO_FLUID_OUNCES = new UsVolume(new BigDecimal("54300"), UsVolumeUnits.MICRO_FLUID_OUNCES); //0.0534 fluid ounces.
	
	/**
	 * creates a new us volume for the requested value.
	 * @param vol - positive volume.
	 * @param units - desired units for this us volume.
	 * @return - a us volume of the desired value and units.
	 */
	public static UsVolume makeVolume(BigDecimal vol, String units){
		return new UsVolume(vol, UsVolumeUnits.makeUsVolumeUnits(units));
	}
}

/**
 * A class representing U.S. volumes.
 * This class is thread safe and immutable.
 */
@ThreadSafe
@Immutable
class UsVolume extends Volume{
	static UsVolumeConverter converter = new UsVolumeConverter();
	
	/**
	 * package private UsVolume contructor.
	 * @param number - a positive number representing the u.s. volume.
	 * @param units - the desired units for this volume.
	 */
	UsVolume(@NotNull BigDecimal number,@NotNull UsVolumeUnits units){
		super(number,units);
		if(number.doubleValue() <= 0) throw new IllegalArgumentException("Only positive u.s. volumes are supported at this time");
	}

	/**
	 * This method returns a subtracted volume.
	 * @return the returned volume is a different instance and does not modify the 'this' object.
	 */
	@Override
	public Volume subtract(Volume other) {
		
		if(! (other instanceof UsVolume)) {
			throw new IllegalArgumentException("You can only subtract Us volumes.");
		}
		
		UsVolume otherVolume = (UsVolume)other;
		if(other.getUnits().getClass() != this.getUnits().getClass()) {
			//units are not the same - need to convert the other value to the same units 
			//as this class.
			otherVolume =  (UsVolume)converter.convert(other, getUnits());
		}
		
		BigDecimal difference = this.getValue().subtract(otherVolume.getValue());
		return new UsVolume(difference, (UsVolumeUnits)getUnits());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsVolume)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}