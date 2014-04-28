package com.bb.coins.impl.us;

import java.math.BigDecimal;

import com.bb.utils.measurements.Volume;

public class UsVolumes {
	// Choosing to deal with longs so we won't have to deal with rounding and equality problems with floats and doubles.
	public static final UsVolume ONE_CENT_MICRO_FLUID_OUNCES = new UsVolume( new BigDecimal("12200"), UsVolumeUnits.MICRO_FLUID_OUNCES); // 0.0122 fluid ounces
	public static final UsVolume FIVE_CENTS_MICRO_FLUID_OUNCES = new UsVolume(new BigDecimal("24300"), UsVolumeUnits.MICRO_FLUID_OUNCES); //0.0243 fluid ounces
	public static final UsVolume TEN_CENTS_MICRO_FLUID_OUNCES = new UsVolume( new BigDecimal("11500"), UsVolumeUnits.MICRO_FLUID_OUNCES); //0.0115 fluid ounces
	public static final UsVolume TWENTY_FIVE_CENTS_MICRO_FLUID_OUNCES = new UsVolume( new BigDecimal("27000"), UsVolumeUnits.MICRO_FLUID_OUNCES); //0.027 fluid ounces 
	public static final UsVolume HALF_DOLLAR_MICRO_FLUID_OUNCES = new UsVolume(new BigDecimal("54300"), UsVolumeUnits.MICRO_FLUID_OUNCES); //0.0534 fluid ounces.
	
	public static UsVolume makeVolume(BigDecimal vol, String units){
		return new UsVolume(vol, UsVolumeUnits.makeUsVolumeUnits(units));
	}
}

class UsVolume extends Volume{
	static UsVolumeConverter converter = new UsVolumeConverter();
	UsVolume(BigDecimal number, UsVolumeUnits units){
		super(number,units);
	}

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