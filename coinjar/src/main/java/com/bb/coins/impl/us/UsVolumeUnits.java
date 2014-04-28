package com.bb.coins.impl.us;

import com.bb.coins.impl.AbstractVolumeUnits;

public abstract class UsVolumeUnits extends AbstractVolumeUnits {
	
	static final UsMicroFluidOuncesVolumeUnits MICRO_FLUID_OUNCES = new UsMicroFluidOuncesVolumeUnits();
	static final UsFluidOunceVolumeUnits FLUID_OUNCES = new UsFluidOunceVolumeUnits() ;
	
	public static final String MICRO_FLUID_OUNCES_STR = MICRO_FLUID_OUNCES.asString();
	public static final String FLUID_OUNCES_STR = FLUID_OUNCES.asString();
	
	protected UsVolumeUnits(String units) {
		super(units);
	}
	
	public static UsVolumeUnits makeUsVolumeUnits(String units){
		if(! MICRO_FLUID_OUNCES.asString().equals(units) && ! FLUID_OUNCES.asString().equals(units)){
			throw new IllegalArgumentException("requested units are not supported.");
		}
		
		return FLUID_OUNCES.asString().equals(units) ? FLUID_OUNCES : MICRO_FLUID_OUNCES;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsVolumeUnits)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}


class UsMicroFluidOuncesVolumeUnits extends UsVolumeUnits{
	
	public UsMicroFluidOuncesVolumeUnits() {
		super("us micro fluid ounces");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof UsMicroFluidOuncesVolumeUnits)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}

class UsFluidOunceVolumeUnits extends UsVolumeUnits{
	
	public UsFluidOunceVolumeUnits() {
		super("us fluid ounces");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof UsFluidOunceVolumeUnits)){
			return false;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}


