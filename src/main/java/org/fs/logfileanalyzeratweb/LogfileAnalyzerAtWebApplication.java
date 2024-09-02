package org.fs.logfileanalyzeratweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;


@SpringBootApplication
public class LogfileAnalyzerAtWebApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LogfileAnalyzerAtWebApplication.class, args);
		Textsearch mytext = new Textsearch();
		mytext.textsearch("C:\\Users\\u1166832\\Documents\\Praktikum\\IHK\\Projekt\\Test.txt",
				"ante",
				"C:\\Users\\u1166832\\Documents\\Praktikum\\IHK\\Projekt\\TestAusgabe.txt");
	}
}
