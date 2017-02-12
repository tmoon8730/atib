package com.atib;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atib.twitter.AtibTwitter;

@SpringBootApplication
public class AtibDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtibDataApplication.class, args);
		AtibTwitter atibTwitter = new AtibTwitter();
		// Use try-with-resource statement to write output to a temp file for parsing
		try( PrintWriter out = new PrintWriter("/tmp/atib-data-output.txt") ){
			out.println(atibTwitter.searchUser("realdonaldtrump"));
		} catch (FileNotFoundException e) {e.printStackTrace();}
	}
}
