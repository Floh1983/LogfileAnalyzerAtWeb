package org.fs.logfileanalyzeratweb.Entity;

//import org.fs.logfileanalyzeratweb.Controller.FController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Component
@Data
public class Textsearch {

//    public void textsearch(String inputFile, @NotNull String searchText, String outputFile) throws IOException {
//        //Suchtext zu Kleinschreibung
//        String lowerCase = searchText.toLowerCase();
//        //Suche durch Regex einschränken
//        if (!lowerCase.matches("[0-9a-z-]*")) {
//            throw new IllegalArgumentException("Suchtext enthält ungültige Zeichen.");
//        }
//        Pattern pattern = Pattern.compile(Pattern.quote(lowerCase));
//        //Lesen der .txt
//        List<String> matchingLines = Files.lines(Paths.get(inputFile))
//                //Filtern
//                .filter(line -> pattern.matcher(line.toLowerCase()).find())
//                //Bauen der Liste
//                .collect(Collectors.toList());
//        //Ausgeben der Liste als .txt
//        Files.write(Paths.get(outputFile), matchingLines);
//    }

    public void textsearch(MultipartFile inputFile, @NotNull String searchValue, File resultFilename) throws IOException {
        //Suchtext zu Kleinschreibung
        String lowerCase = searchValue.toLowerCase();
        //Suche durch Regex einschränken
        if (!lowerCase.matches("[0-9a-z-]{1,70}")) {
            throw new IllegalArgumentException("Suchtext enthält ungültige Zeichen.");
        }
        Pattern pattern = Pattern.compile(Pattern.quote(lowerCase));
        //Lesen der .txt

        String content = new String(inputFile.getBytes(), StandardCharsets.UTF_8);

        List<String> matchingLines = Arrays.stream(content.split("\n"))
                //Filtern
                .filter(line -> pattern.matcher(line.toLowerCase()).find())
                //Bauen der Liste
                .collect(Collectors.toList());
        //Ausgeben der Liste als .txt
        Files.write(Path.of(resultFilename.toURI()), matchingLines);
    }
}



