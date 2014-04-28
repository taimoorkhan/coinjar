package com.bb.utils.measurements;

import javax.validation.constraints.NotNull;


/**
 * This is the volume converter type.
 *
 */
public interface VolumeConverter {

	/**
	 * This method creates a new volume instance which is an equivalent conversion of a given volume
	 * (from) to the desired units (toUnits).  
	 * @param from - src volume from which to perform conversion.
	 * @param toUnits - the desired units of the converted value.
	 * @return a new Volume instance
	 * 
	 * @throws - Can throw runtime exceptions if unsupported volume units are given.
	 */
	@NotNull
	public Volume convert(@NotNull Volume from, @NotNull VolumeUnits toUnits);
}
