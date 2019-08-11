package com.kakao.pay.shortening.shortener;

public abstract class BaseURLShortener {
	private final String key62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private int keyLength;

	public BaseURLShortener(int keyLength) {
		this.keyLength = keyLength;
	}
	
	public int getKeyLength() {
		return this.keyLength;
	}
	
	public String getKey62() {
		return this.key62;
	}
	
	public abstract String generateKey();
}
