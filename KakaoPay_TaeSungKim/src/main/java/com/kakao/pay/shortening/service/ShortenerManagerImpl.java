package com.kakao.pay.shortening.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kakao.pay.exception.ExceptionURLShortener;
import com.kakao.pay.exception.ExceptionURLShortener.ErrorCode;
import com.kakao.pay.shortening.shortener.BaseURLShortener;
import com.kakao.pay.shortening.store.ShortenerStoreImpl;

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
	public String shortenURL(String originURL) throws ExceptionURLShortener {
		if(!validateURL(originURL)) {
			throw new ExceptionURLShortener(ErrorCode.U001);
		}
		
		StringBuilder key = new StringBuilder();
		key.append(DOMAIN).append("/");

		key.append(shortener.generateKey());
		while(store.containsKey(key.toString())) key.append(shortener.generateKey());
		store.add(key.toString(), originURL);
		
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
