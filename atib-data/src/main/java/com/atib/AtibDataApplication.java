package com.atib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atib.twitter.GetTimeline;

@SpringBootApplication
public class AtibDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtibDataApplication.class, args);
		GetTimeline gt = new GetTimeline();
	}
}
