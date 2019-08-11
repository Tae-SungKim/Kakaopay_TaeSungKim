package com.kakao.pay.shortening;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kakao.pay.shortening.service.ShortenerManager;

public class ShortenerTest {
	@Autowired
	private ShortenerManager shortenerManager;

	@Test
	public void test() {
		String url = "http://naver.com";
		String shortURL = shortenerManager.originalURL(url);
		assertEquals(url, shortURL, 0);
		//fail("Not yet implemented");
	}

}
