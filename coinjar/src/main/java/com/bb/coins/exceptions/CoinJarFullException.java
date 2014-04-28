package com.bb.coins.exceptions;

@SuppressWarnings("serial")
public class CoinJarFullException extends IllegalStateException {
	
	public CoinJarFullException(String msg) {
		super(msg);
	}
}
