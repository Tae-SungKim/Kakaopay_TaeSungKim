package com.kakao.pay.shortening.service;

public interface ShortenerManager {
	public String shortenURL(String originURL);
	public String originalURL(String shortenURL);
	public boolean validateURL(String url);
}
