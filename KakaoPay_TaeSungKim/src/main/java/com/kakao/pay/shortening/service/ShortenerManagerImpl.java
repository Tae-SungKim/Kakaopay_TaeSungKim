package com.kakao.pay.shortening.service;

import org.springframework.stereotype.Component;

import com.kakao.pay.exception.ExceptionURLShortener;
import com.kakao.pay.exception.ExceptionURLShortener.ErrorCode;
import com.kakao.pay.shortening.shortener.BaseURLShortener;
import com.kakao.pay.shortening.shortener.URLRandomShortener;
import com.kakao.pay.shortening.store.ShortenerStoreImpl;

@Component
public class ShortenerManagerImpl implements ShortenerManager{
	protected BaseURLShortener shortener;
	protected ShortenerStoreImpl store;
	protected final String http = "HTTP://";
	protected final String https = "HTTPS://";
	protected String domain;
	
	public ShortenerManagerImpl() {
		shortener = new URLRandomShortener();
		store = new ShortenerStoreImpl();
		domain = "http://localhost:8080";
		shortener.setKeyLength(8);
	}
	@Override
	public String shortenURL(String originURL) throws ExceptionURLShortener {
		StringBuffer key = new StringBuffer();
		key.append(domain).append("/");
		if(validateURL(originURL)) {
			key.append(shortener.generateKey());
			while(store.containsKey(key.toString())) key.append(shortener.generateKey());
			store.add(key.toString(), originURL);
		}
		else {
			throw new ExceptionURLShortener(ErrorCode.U001);
		}
		return key.toString();
	}

	@Override
	public String originalURL(String shortenerUrl) {
		return store.getURL(shortenerUrl);
	}

	@Override
	public boolean validateURL(String url) {
		return url.toUpperCase().startsWith(http) || 
				url.toUpperCase().startsWith(https);
	}

}
