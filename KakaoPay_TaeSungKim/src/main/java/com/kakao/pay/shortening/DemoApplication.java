package com.kakao.pay.shortening;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kakao.pay.exception.URLShortenerException;
import com.kakao.pay.shortening.service.ShortenerManagerImpl;
import com.kakao.pay.shortening.store.ShortenerStoreImpl;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private ShortenerStoreImpl store;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		store.add("http://localhost:8080/1", "https://www.kakaopay.com");
		store.add("http://localhost:8080/2", "http://daum.net");
		store.add("http://localhost:8080/3", "http://naver.com");
	}

}
