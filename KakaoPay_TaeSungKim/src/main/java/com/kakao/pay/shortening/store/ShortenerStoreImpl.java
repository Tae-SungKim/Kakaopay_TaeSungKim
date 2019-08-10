package com.kakao.pay.shortening.store;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.kakao.pay.shortening.shortener.BaseURLShortener;

@Component
public class ShortenerStoreImpl implements UrlKeyValueStore{
	protected Map<String, String> keyMap;
	protected Map<String, String> valueMap;
	
	public ShortenerStoreImpl() {
		keyMap = new ConcurrentHashMap<>();
		valueMap = new ConcurrentHashMap<>();
	}

	@Override
	public boolean add(String key, String value) {
		boolean result = false;
		if(!valueMap.containsKey(value)) 
		{
			keyMap.put(key, value);
			valueMap.put(value, key);
			result = true;
		}
		return result;
	}
	@Override
	public boolean removeKey(String key) {
		boolean result = false;
		if(containsKey(key)) {
			String value = keyMap.get(key);
			valueMap.remove(value);
			keyMap.remove(key);
			result = true;
		}
		// TODO Auto-generated method stub
		return result;
	}
	@Override
	public boolean removeValue(String value) {
		boolean result = false;
		if(containsValue(value)) {
			String key = valueMap.get(value);
			keyMap.remove(key);
			valueMap.remove(value);
			result = true;
		}
		// TODO Auto-generated method stub
		return result;
	}
	@Override
	public boolean containsKey(String key) {
		return keyMap.containsKey(key);
	}
	@Override
	public boolean containsValue(String value) {
		return valueMap.containsKey(value);
	}

	@Override
	public String getShortenerURL(String originalUrl) {
		if(containsValue(originalUrl)) return valueMap.get(originalUrl);
		return "";
	}

	@Override
	public String getURL(String shortenerUrl) {
		if(containsKey(shortenerUrl)) return keyMap.get(shortenerUrl);
		return "";
	}
}
