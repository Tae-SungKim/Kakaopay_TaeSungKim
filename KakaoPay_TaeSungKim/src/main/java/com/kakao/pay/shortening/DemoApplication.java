package com.kakao.pay.shortening;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kakao.pay.exception.ExceptionURLShortener;
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
		store.add("1111", "http://www.naver.com");
		store.add("2222", "https://github.com");
	}

}
