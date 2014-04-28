package com.bb.utils.measurements;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.validation.constraints.NotNull;

/**
 * An abstract class representing MonetaryAmounts.
 * This class is immutable and therefore is thread safe.
 */
@ThreadSafe
@Immutable
public abstract class MonetaryAmount  {
	
	private BigDecimal number ;
	private MonetaryUnits units;
	/**
	 * Constructor 
	 * @param n - represents the scalar amount representing this monetary amount.
	 * @param units - {@link MonetaryUnits} for this monetary amount.
	 */
	public MonetaryAmount(@NotNull BigDecimal n ,@NotNull MonetaryUnits units){
		this.number = n;
		this.units = units;
	}
	
	@NotNull
	public BigDecimal getValue(){
		return number;
	}
	
	@NotNull
	public MonetaryUnits getUnits(){
		return units;
	}
	
	public abstract MonetaryAmount add(MonetaryAmount other);
	

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MonetaryAmount)){
			return false;
		}
		MonetaryAmount other = (MonetaryAmount)obj;
		return Objects.equals(this.number,other.number) && Objects.equals(this.units, other.units);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.number, this.units);
	}
	
}
