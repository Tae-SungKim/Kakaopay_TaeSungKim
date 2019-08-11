package com.kakao.pay.shortening.shortener;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * RandomURLShortener Class
 * URL Shortening시 keyLength만큼 랜덤으로 추출
 * 
 * @author tskim
 */
public class RandomURLShortener extends BaseURLShortener{
	private Random myRand;
	
	public RandomURLShortener(int keyLength) {
		super(keyLength);
		myRand = new Random();
	}
	
	@Override
	public String generateKey() {
		StringBuffer key = new StringBuffer();

		for (int i = 0; i <= getKeyLength(); i++) {
			key.append(getKey62().charAt(myRand.nextInt(62)));
		}
		return key.toString();
	}

}
