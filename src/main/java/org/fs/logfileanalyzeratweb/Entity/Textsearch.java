package org.fs.logfileanalyzeratweb.Entity;


import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Component
@Data
public class Textsearch {

    public static void textsearch(File inputFile, @NotNull String searchValue, File resultFile) throws IOException {
        //Suchtext zu Kleinschreibung
        String lowerCase = searchValue.toLowerCase();
        //Suche durch Regex einschränken
        if (!lowerCase.matches("[0-9a-z-]{1,70}")) {
            throw new IllegalArgumentException("Suchtext enthält ungültige Zeichen.");
        }
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



