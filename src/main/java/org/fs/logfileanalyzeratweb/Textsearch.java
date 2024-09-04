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
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class Textsearch {

    public void textsearch(String inputFile, @NotNull String searchText, String outputFile) throws IOException {
        //Suchtext zu Kleinschreibung
        String lowerCase = searchText.toLowerCase();
        //Suche durch Regex einschränken
        Pattern pattern = Pattern.compile("[0-9A-Za-z-]*");
        //Lesen der .txt
        List<String> matchingLines = Files.lines(Paths.get(inputFile))
                //Filtern
                .filter(line -> pattern.matcher(line.toLowerCase()).find())
                //Bauen der Liste
                .collect(Collectors.toList());
        //Ausgeben der Liste als .txt
        Files.write(Paths.get(outputFile), matchingLines);
    }
}

