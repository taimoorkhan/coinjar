package com.bb.utils.measurements;

import java.math.BigDecimal;


public abstract class Volume {
	
	private BigDecimal number;
	private VolumeUnits units;
	
	public Volume( BigDecimal number, VolumeUnits units){
		this.number = number;
		this.units = units;
	}
	
	public BigDecimal getValue(){
		return number;
	}
	
	public VolumeUnits getUnits(){
		return units;
	}
	
	public abstract Volume subtract(Volume other);
}
