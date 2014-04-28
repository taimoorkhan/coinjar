package com.bb.utils.measurements;

import java.math.BigDecimal;
import java.util.Objects;


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
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Volume)){
			return false;
		}
		Volume other = (Volume) obj;
		return Objects.equals(this.number, other.number) && Objects.equals(this.units, other.units);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.number, this.units);
	}
}
