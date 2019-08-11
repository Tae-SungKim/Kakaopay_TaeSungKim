package com.kakao.pay.shortening.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kakao.pay.exception.URLShortenerException;
import com.kakao.pay.exception.URLShortenerException.ErrorCode;
import com.kakao.pay.shortening.shortener.BaseURLShortener;
import com.kakao.pay.shortening.store.ShortenerStoreImpl;

/**
 * ShortenerManagerImpl Class
 * URLShorening을 하기위한 매니저 클래스
 * URL 검사 및 저장 저장된 원본URL로 변경된 URL찾기 기능
 * 
 * @author tskim
 */
@Component
public class ShortenerManagerImpl implements ShortenerManager{
	
	@Autowired
	private BaseURLShortener shortener;
	
	@Autowired
	private ShortenerStoreImpl store;
	
	@Value("${shortener.url}")
	private String DOMAIN;
	
	private final String http = "HTTP://";
	private final String https = "HTTPS://";

	@Override
	public String shortenURL(String originalURL) throws URLShortenerException {
		if(!validateURL(originalURL)) {
			throw new URLShortenerException(ErrorCode.U001);
		}
		if(store.containsValue(originalURL)) {
			return store.getShortenerURL(originalURL);
		}
		StringBuilder key = new StringBuilder();
		key.append(DOMAIN).append("/");

		key.append(shortener.generateKey());
		while(store.containsKey(key.toString())) key.append(shortener.generateKey());
		store.add(key.toString(), originalURL);
		
		return key.toString();
	}

	@Override
	public String originalURL(String shortUrl) {
		return store.getURL(shortUrl);
	}

	@Override
	public boolean validateURL(String url) {
		return url.toUpperCase().startsWith(http) || 
				url.toUpperCase().startsWith(https);
	}

}
