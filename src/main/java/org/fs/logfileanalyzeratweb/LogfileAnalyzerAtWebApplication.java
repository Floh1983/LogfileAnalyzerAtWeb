package org.fs.logfileanalyzeratweb;


import org.fs.logfileanalyzeratweb.Entity.Textsearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;


@SpringBootApplication
@EnableConfigurationProperties
public class LogfileAnalyzerAtWebApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LogfileAnalyzerAtWebApplication.class, args);
//		Textsearch mytext = new Textsearch();
//		mytext.textsearch("C:\\Users\\u1166832\\Documents\\Praktikum\\IHK\\Projekt\\Test.txt",
//				"ante",
//				"C:\\Users\\u1166832\\Documents\\Praktikum\\IHK\\Projekt\\TestAusgabe.txt");
	}
}
