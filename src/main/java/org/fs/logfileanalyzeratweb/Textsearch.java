package org.fs.logfileanalyzeratweb;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Textsearch {

//    public void textsearch() throws IOException {
//        //Übergabe des Dateipfades
//        Path path = Paths.get("C:\\Users\\u1166832\\Documents\\Praktikum\\IHK\\Projekt\\Test.txt");
//        //Auslesen Der Textdatei
//        String line;
//        try (BufferedReader reader = Files.newBufferedReader(path)) {
//            line = reader.readLine();
//        }
//        //Ausgabe der ersten Zeile
//        System.out.println(line);
//    }

    public void textsearch(String inputFile, @NotNull String searchText, String outputFile) throws IOException {
        //Suchtext zu Kleinschreibung
        String lowerCase = searchText.toLowerCase();
        //Lesen der .txt
        List<String> matchingLines = Files.lines(Paths.get(inputFile))
                //Filtern
                .filter(line -> line.toLowerCase().contains(lowerCase))
                //Bauen der Liste
                .collect(Collectors.toList());
        //Ausgeben der Liste als .txt
        Files.write(Paths.get(outputFile), matchingLines);
    }
}

