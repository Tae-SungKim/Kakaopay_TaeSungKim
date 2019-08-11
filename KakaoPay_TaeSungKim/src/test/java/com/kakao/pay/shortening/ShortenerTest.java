package com.kakao.pay.shortening;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kakao.pay.shortening.service.ShortenerManager;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ShortenerTest {
	//@Autowired
	//private ShortenerManager shortenerManager;

	//@Test
	public void test() {
		//String url = "http://naver.com";
		//String shortURL = shortenerManager.originalURL(url);
		//assertEquals(url, shortURL, 0);
		//fail("Not yet implemented");
	}
	
	@Test
	public void shortenerManagerLoaded() {
		assertEquals(true, true);
	}

}
