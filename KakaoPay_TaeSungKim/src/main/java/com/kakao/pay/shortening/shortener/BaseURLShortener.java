package com.kakao.pay.shortening.shortener;

/**
 * BaseURLShortener Class
 * 요구사항 중 애매한 부분이 있어 Shortening을 하는 방법을 두개로 분리하기위한 추상 클래스.
 * 
 * @author tskim
 */
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
