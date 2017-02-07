package com.atib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atib.twitter.AtibTwitter;

@SpringBootApplication
public class AtibDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtibDataApplication.class, args);
		AtibTwitter atibTwitter = new AtibTwitter();
		System.out.println(atibTwitter.searchTweets("Donald Trump"));
	}
}
