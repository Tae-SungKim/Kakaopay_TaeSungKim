package com.kakao.pay.shortening.shortener;

import org.springframework.stereotype.Component;

@Component
public abstract class BaseURLShortener {
	protected final String key62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	protected int keyLength;

	public BaseURLShortener() {
	}

	public void setKeyLength(int keyLength) {
		this.keyLength = keyLength;
	}

	
	public abstract String generateKey();
}
