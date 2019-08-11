package com.kakao.pay.shortening.shortener;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("URLRandomShortener")
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
