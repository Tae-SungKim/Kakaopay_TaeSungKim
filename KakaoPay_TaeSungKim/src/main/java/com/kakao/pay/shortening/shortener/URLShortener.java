package com.kakao.pay.shortening.shortener;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public class URLShortener extends BaseURLShortener{
	private long idx;
	
	public URLShortener(int keyLength) {
		super(keyLength);
		idx = 0;
	}

	@Override
	public String generateKey() {
		long value = ++idx;
		StringBuilder result = new StringBuilder();
		int iResult[] = new int[32];
		int max_len = Long.toString(value).length();
		int idx = 0;
		int length = Integer.valueOf(getKeyLength()).toString().length();
		for(; value > 0; value = value / length) {
			int q = (int) value % length;
			iResult[--max_len] = q;
			idx++;
		}
		for(int i = max_len; i < max_len + idx; i++) {
			result.append(getKey62().charAt(iResult[i]));
		}
		
		return result.toString().replaceAll("^0+", "");
	}
}
