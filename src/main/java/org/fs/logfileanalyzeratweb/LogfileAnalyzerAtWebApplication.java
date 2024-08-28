package org.fs.logfileanalyzeratweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LogfileAnalyzerAtWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogfileAnalyzerAtWebApplication.class, args);
		System.out.println("hemlo");
		Textsearch mytext = new Textsearch();
		mytext.textsearch();
	}
}
