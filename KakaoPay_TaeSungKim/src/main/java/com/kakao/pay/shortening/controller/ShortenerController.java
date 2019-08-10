package com.kakao.pay.shortening.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kakao.pay.shortening.service.ShortenerManager;
@Controller
public class ShortenerController {
	@Autowired
	private ShortenerManager shortenerManager;

	@GetMapping("/index")
	public ModelAndView index() {	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("result_url", "");
		
		return mv;
	}

	@GetMapping("/{urlKey}")
	public String redirectToOriginalUrl(@PathVariable String urlKey) {
		String originalUrl = shortenerManager.originalURL(urlKey);
		return "redirect:" + originalUrl;
	}
	
	@PostMapping("/convert")
	public ModelAndView receiveUrl(@RequestParam String urlvalue) {
		
		String resultURL = shortenerManager.shortenURL(urlvalue);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("result_url", "http://localhost:8080/" + resultURL);
		return mv;
	}
}
