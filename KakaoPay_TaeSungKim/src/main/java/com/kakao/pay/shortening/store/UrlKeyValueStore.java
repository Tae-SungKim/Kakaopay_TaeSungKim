package com.kakao.pay.shortening.store;

/**
 * UrlKeyValueStore interface
 * URL 저장하기위한 Store
 * 
 * @author tskim
 */
public interface UrlKeyValueStore {
	public boolean add(String key, String value);
	public boolean removeKey(String key);
	public boolean removeValue(String value);
	public boolean containsKey(String key);
	public boolean containsValue(String value);
	public String getShortenerURL(String originalUrl);
	public String getURL(String shortenerUrl);
}
