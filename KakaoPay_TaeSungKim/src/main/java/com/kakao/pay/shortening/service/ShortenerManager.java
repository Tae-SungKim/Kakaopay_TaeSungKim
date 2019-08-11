package com.kakao.pay.shortening.service;

import com.kakao.pay.exception.URLShortenerException;

/**
 * ShortenerManager interface
 * 
 * @author tskim
 */
public interface ShortenerManager {
	public String shortenURL(String originURL) throws URLShortenerException;
	public String originalURL(String shortenURL);
	public boolean validateURL(String url);
}
