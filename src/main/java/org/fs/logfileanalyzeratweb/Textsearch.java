package org.fs.logfileanalyzeratweb;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Textsearch {
    public String textsearch() throws IOException {
        System.out.println("innerhalb");
        Path path = Paths.get("C:\\Users\\u1166832\\Documents\\Praktikum\\IHK\\Projekt");

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        System.out.println(line);
        System.out.println("innerhalb");
        return line;
    }



//        private String textsearch(InputStream inputStream) throws IOException {
//            Path path = Paths.get("C:\\Users\\u1166832\\Documents\\Praktikum\\IHK\\Projekt");
//            StringBuilder resultStringBuilder = new StringBuilder();
//            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
//                String line;
//                while ((line = br.readLine()) != null) {
//                    resultStringBuilder.append(line).append("\n");
//                }
//            }
//            System.out.println("in textsearch");
//            return resultStringBuilder.toString();
//        }
    }

