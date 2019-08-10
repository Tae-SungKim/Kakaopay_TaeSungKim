package com.kakao.pay.shortening.shortener;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class URLRandomShortener extends BaseURLShortener{
	private Random myRand;
	public URLRandomShortener() {
		myRand = new Random();
	}
	
	@Override
	public String generateKey() {
		StringBuffer key = new StringBuffer();

		for (int i = 0; i <= keyLength; i++) {
			key.append(key62.charAt(myRand.nextInt(62)));
		}
		return key.toString();
	}

}
