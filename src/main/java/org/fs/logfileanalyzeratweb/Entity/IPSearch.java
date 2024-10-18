package org.fs.logfileanalyzeratweb.Entity;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IPSearch {

    public static void iPSearch(File inputFile, @NotNull String searchValue, File resultFile) throws IOException {
        //Suchwert zu Kleinschreibung
        String lowerCase = searchValue.toLowerCase();
        //Suche durch Regex einschränken
        if (!lowerCase.matches("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")) {
            throw new IllegalArgumentException("Suchtext enthält ungültige Zeichen.");
        }
        //Suchtext zu Kleinschreibung
        Pattern pattern = Pattern.compile(Pattern.quote(lowerCase));

        //Lesen der .txt
        String content = new String(Files.readAllBytes(inputFile.toPath()), StandardCharsets.UTF_8);

        //Splitten der Inhalte der .txt bei jedem Zeilenumbruch
        List<String> matchingLines = Arrays.stream(content.split("\n"))
                //Filtern
                .filter(line -> pattern.matcher(line.toLowerCase()).find())
                //Bauen der Liste
                .collect(Collectors.toList());
        //Ausgeben der Liste als .txt
        Files.write(Path.of(resultFile.toURI()), matchingLines);
    }
}
