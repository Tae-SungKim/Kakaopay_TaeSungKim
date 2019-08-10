package com.kakao.pay.shortening;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kakao.pay.exception.ExceptionURLShortener;
import com.kakao.pay.shortening.service.ShortenerManagerImpl;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws ExceptionURLShortener {
		SpringApplication.run(DemoApplication.class, args);
		ShortenerManagerImpl m = new ShortenerManagerImpl();
		
		List<String> shortURL = new ArrayList<String>();
		
		String temp = m.shortenURL("http://naver.com");
		shortURL.add(temp);
		temp = m.shortenURL("http://google.com");
		shortURL.add(temp);
		temp = m.shortenURL("http://daum.com");
		shortURL.add(temp);
		temp = m.shortenURL("http://kakao.com");
		shortURL.add(temp);
		for(String str : shortURL) {
			StringBuffer b = new StringBuffer();
			b.append("ShortURL : ");
			b.append(str);
			b.append(" OriginalURL : ");
			b.append(m.originalURL(str));
			System.out.println(b.toString());
		}
	}

}
