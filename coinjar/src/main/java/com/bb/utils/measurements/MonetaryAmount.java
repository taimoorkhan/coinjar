package com.bb.utils.measurements;

import java.math.BigDecimal;
import java.util.Objects;


public abstract class MonetaryAmount  {
	
	private BigDecimal number ;
	private MonetaryUnits units;
	
	public MonetaryAmount(BigDecimal n , MonetaryUnits units){
		this.number = n;
		this.units = units;
	}
	
	public BigDecimal getValue(){
		return number;
	}
	
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
