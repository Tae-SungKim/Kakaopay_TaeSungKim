package com.kakao.pay.shortening.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.kakao.pay.shortening.shortener.BaseURLShortener;
import com.kakao.pay.shortening.shortener.URLRandomShortener;
import com.kakao.pay.shortening.shortener.URLShortener;

@Configuration
@PropertySource("classpath:config/config.properties")
public class ShortenerConfig {
	@Value("${config_shortener.url}")
	private String domain;
	@Value("${config_shortener.keyLength}")
	private int keyLength;
	@Value("${config_shortener.shortenerType}")
	private String shortenerType;
	@Autowired
	private URLRandomShortener urlRandomShortener;
	@Autowired
	private URLShortener urlShortener;
	
	
	public String getDomain() {
		return domain;
	}
	public int getKeyLength() {
		return keyLength;
	}

	@Bean
	public BaseURLShortener getShortener() {
		if(shortenerType.equals("Shortener")) {
			return urlShortener;
		}
		return urlRandomShortener;
	}
}
