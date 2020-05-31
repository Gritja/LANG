package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
//Controller
@RestController
public class LangController {
	@Autowired
	private MessageSource messageSource;
	
//translation
	@GetMapping(path = "/translate")
	public String translateString(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@RequestParam(value = "word") String word) {
		//word.replaceAll("\\s+", "");
		return messageSource.getMessage(word.replaceAll("\\s+", "") + ".message", null, locale);

	}
	@GetMapping(path = "/add")
	public void addString(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@RequestParam(value = "word") String word) throws Exception {
		if(locale == null) {locale = new Locale("en");}
		LangAdd.addWord(word + "\n", locale);	
	}
}
