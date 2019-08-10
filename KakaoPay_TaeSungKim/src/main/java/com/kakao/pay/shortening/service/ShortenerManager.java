package com.kakao.pay.shortening.service;

import com.kakao.pay.exception.ExceptionURLShortener;

public interface ShortenerManager {
	public String shortenURL(String originURL) throws ExceptionURLShortener;
	public String originalURL(String shortenURL);
	public boolean validateURL(String url);
}
