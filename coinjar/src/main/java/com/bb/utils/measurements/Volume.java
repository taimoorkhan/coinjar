package com.bb.utils.measurements;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

/**
 * Volume represents an entity which has a scalar number and volume units {@link VolumeUnits}.
 * This class is immutable and is therefore thread  safe.
 */
@Immutable
@ThreadSafe
public abstract class Volume {
	
	private BigDecimal number;
	private VolumeUnits units;
	
	/**
	 * @param number - this is the scalar value of the volume
	 * @param units - these are the volume units (for e.g. US fluid ounces.
	 */
	public Volume( @NotNull BigDecimal number, @NotNull VolumeUnits units){
		this.number = number;
		this.units = units;
	}
	
	@NotNull
	public BigDecimal getValue(){
		return number;
	}
	
	@NotNull
	public VolumeUnits getUnits(){
		return units;
	}
	
	@NotNull
	public abstract Volume subtract(@NotNull Volume other);
	
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
