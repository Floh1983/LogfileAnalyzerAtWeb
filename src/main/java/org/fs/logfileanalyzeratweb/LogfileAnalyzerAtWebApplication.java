package org.fs.logfileanalyzeratweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class LogfileAnalyzerAtWebApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LogfileAnalyzerAtWebApplication.class, args);
		Textsearch mytext = new Textsearch();
		mytext.textsearch();
	}
}
