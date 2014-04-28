package com.bb.coins.exceptions;

@SuppressWarnings("serial")
public class CoinDenominationNotSupportedException extends RuntimeException{

	public CoinDenominationNotSupportedException(String msg) {
		super(msg);
	}
}
