package com.kakao.pay.shortening.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kakao.pay.exception.ExceptionURLShortener;
import com.kakao.pay.exception.ExceptionURLShortener.ErrorCode;
import com.kakao.pay.shortening.shortener.BaseURLShortener;
import com.kakao.pay.shortening.shortener.URLRandomShortener;
import com.kakao.pay.shortening.store.ShortenerStoreImpl;

@Component
public class ShortenerManagerImpl implements ShortenerManager{
	@Resource(name="URLRandomShortener")
	private BaseURLShortener shortener;
	@Autowired
	private ShortenerStoreImpl store;
	
	private final String http = "HTTP://";
	private final String https = "HTTPS://";

	private ShortenerConfig config;
	
	public ShortenerManagerImpl() {
		//shortener = new URLRandomShortener();
		//store = new ShortenerStoreImpl();
		shortener = config.getShortener();
		shortener.setKeyLength(config.getKeyLength());
	}
	

	@Override
	public String shortenURL(String originURL) throws ExceptionURLShortener {
		StringBuffer key = new StringBuffer();
		key.append(config.getDomain()).append("/");
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
