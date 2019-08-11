package com.kakao.pay.shortening.shortener;

import java.util.concurrent.atomic.AtomicLong;

import com.kakao.pay.exception.URLShortenerException;


/**
 * 순차적 URL Shortener Class
 * URL Shortening시 1부터 자동증가(제한된 길이만큼)
 * 
 * @author tskim
 */
public class URLShortener extends BaseURLShortener{
	private AtomicLong idx;
	
	public URLShortener(int keyLength) {
		super(keyLength);
		idx = new AtomicLong(0);
	}

	@Override
	public String generateKey() {
		long value = idx.incrementAndGet();
		StringBuilder key = new StringBuilder();
		int iResult[] = new int[32];
		int max_len = Long.toString(value).length();
		int idx = 0;
		int length = getKey62().length();
		for(; value > 0; value = value / length) {
			int q = (int) value % length;
			iResult[--max_len] = q;
			idx++;
		}
		if(max_len + idx > getKeyLength()) {
			throw new URLShortenerException(URLShortenerException.ErrorCode.U002);
		}
		for(int i = max_len; i < max_len + idx; i++) {
			key.append(getKey62().charAt(iResult[i]));
		}
		
		return key.toString().replaceAll("^0+", "");
	}
}
