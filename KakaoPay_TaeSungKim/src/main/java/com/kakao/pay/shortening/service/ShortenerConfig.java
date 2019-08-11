package com.kakao.pay.shortening.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kakao.pay.shortening.shortener.BaseURLShortener;
import com.kakao.pay.shortening.shortener.RandomURLShortener;
import com.kakao.pay.shortening.shortener.URLShortener;

@Configuration
public class ShortenerConfig {
	@Value("${shortener.url}")
	private String domain;
	
	@Value("${shortener.keyLength}")
	private int keyLength;
	
	@Value("${shortener.shortenerType}")
	private String shortenerType;

	@Bean
	public BaseURLShortener getShortener() {
		if(shortenerType.equals("Shortener")) {
			return new URLShortener(keyLength);
		}
		return new RandomURLShortener(keyLength);
	}
}
