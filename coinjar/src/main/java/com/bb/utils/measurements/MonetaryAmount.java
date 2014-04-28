package com.bb.utils.measurements;

import java.math.BigDecimal;


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
	
}
