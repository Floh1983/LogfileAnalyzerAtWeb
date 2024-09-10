package org.fs.logfileanalyzeratweb.Entity;

import org.fs.logfileanalyzeratweb.Controller.FController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Component

@AllArgsConstructor
@Getter
@Setter
public class Textsearch {

    public void textsearch(String inputFile, @NotNull String searchText, String outputFile) throws IOException {
        //Suchtext zu Kleinschreibung
        String lowerCase = searchText.toLowerCase();
        //Suche durch Regex einschränken
        if (!lowerCase.matches("[0-9a-z-]*")) {
            throw new IllegalArgumentException("Suchtext enthält ungültige Zeichen.");
        }
        Pattern pattern = Pattern.compile(Pattern.quote(lowerCase));
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



