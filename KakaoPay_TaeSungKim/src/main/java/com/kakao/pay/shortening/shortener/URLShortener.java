package com.kakao.pay.shortening.shortener;

import org.springframework.stereotype.Component;

@Component
public class URLShortener extends BaseURLShortener{
	private long idx;
	public URLShortener() {
		idx = 0;
	}

	@Override
	public String generateKey() {
		long value = ++idx;
		StringBuilder result = new StringBuilder();
		int iResult[] = new int[32];
		int max_len = Long.toString(value).length();
		int idx = 0;
		for(; value > 0; value = value / key62.length()) {
			int q = (int) value % key62.length();
			iResult[--max_len] = q;
			idx++;
		}
		for(int i = max_len; i < max_len + idx; i++) {
			result.append(key62.charAt(iResult[i]));
		}
		
		return result.toString().replaceAll("^0+", "");
	}
}
