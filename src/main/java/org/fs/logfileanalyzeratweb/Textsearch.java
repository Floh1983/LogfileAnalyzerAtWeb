package org.fs.logfileanalyzeratweb;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Textsearch {

    public void textsearch() throws IOException {

        Path path = Paths.get("C:\\Users\\u1166832\\Documents\\Praktikum\\IHK\\Projekt\\Test.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        System.out.println(line);
    }
}

