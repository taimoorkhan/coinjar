package com.bb.coins.impl;

import java.util.Objects;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

import com.bb.utils.measurements.VolumeUnits;

/**
 * Abstract class representing VolumeUnits.  This class is thread safe and immutable.
 */
@ThreadSafe
@Immutable
public class AbstractVolumeUnits  implements VolumeUnits{

	protected String units;
	
	/**
	 * Constructor
	 * @param units - desired volume units.
	 */
	protected AbstractVolumeUnits(String units){
		this.units = units;
	}
	
	/**
	 * @return the string representation of the this volume unit.
	 */
	@Override
	@NotNull
	public String asString() {
		return units;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof AbstractVolumeUnits)){
			return false;
		}
		AbstractVolumeUnits other = (AbstractVolumeUnits)obj;
		
		return Objects.equals(this.units, other.units);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.units);
	}
}
