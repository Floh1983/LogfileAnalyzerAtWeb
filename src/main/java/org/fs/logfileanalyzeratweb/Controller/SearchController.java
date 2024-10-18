package org.fs.logfileanalyzeratweb.Controller;

import lombok.Data;
import org.fs.logfileanalyzeratweb.Entity.*;
import org.fs.logfileanalyzeratweb.service.StorageService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

@Data
@Controller
public class SearchController {


    private final StorageService storageService;
    private final DateSearch dateSearch;
    private final DocIDSearch docIDSearch;
    private final IPSearch iPSearch;
    private final SapDocIDSearch sapDocIDSearch;
    private final Textsearch textsearch;
    private final TimeSearch timeSearch;

    @Autowired
    public SearchController(StorageService storageService, Textsearch textsearch) {

        this.storageService = storageService;
        this.textsearch = textsearch;
    }

    @GetMapping("/startpage")
    public ModelAndView showStartpage(){
        ModelAndView mav = new ModelAndView("startpage");
        return mav;
    }

    @GetMapping("/inputFileSelection")
    public ModelAndView inputFileSelection(){
        ModelAndView mav = new ModelAndView("inputFileSelection");
        return mav;
    }

    @PostMapping("/inputFile")
    public String inputFile(@RequestParam @NotNull MultipartFile inputFile ) throws IOException {
        File newfile = storageService.createFile("inputFile.txt");
        //write to file: pfad und dateinamen übergeben
        OutputStream os = new FileOutputStream(newfile);
        os.write(inputFile.getBytes());
        return "redirect:/searchOption";
    }

    @GetMapping("/searchOption")
    public ModelAndView searchOption(Model model) {
        ModelAndView mav = new ModelAndView("searchOption");
        return mav;
    }

    @GetMapping("/textSearch")
    public ModelAndView textSearch(String searchValue) throws IOException {
        ModelAndView mav = new ModelAndView("textSearch");
        return mav;
    }

     @PostMapping("/textSearcher")
        public String textSearcher(@RequestParam @NotNull String searchValue) throws IOException {
        //Trimmen des Übergabewertes
         if (searchValue.startsWith("searchValue=")) {
             searchValue = searchValue.substring("searchValue=".length());
         }
         //Pfad festlegen
        String directoryPath = "C:/Users/u1166832/IdeaProjects/LogfileAnalyzerAtWeb/file";
        //Suchwert zu Datei schreiben
         File newSearchValue = new File(directoryPath, "searchValue.txt");
         OutputStream os = new FileOutputStream(newSearchValue);
         os.write(searchValue.getBytes());
         // Ergebnisdatei definieren
         File resultFile = new File(directoryPath, "result.txt");
         // Datei vom Pfad laden
         File inputFile = new File(directoryPath);
         FileInputStream input = new FileInputStream(inputFile);
         // Aufruf der textsearch Methode
         Textsearch.textsearch(inputFile, searchValue, resultFile);
         return "redirect:/file/{resultFilename}";
     }

    @GetMapping("/dateSearch")
    public ModelAndView dateSearch(){
        ModelAndView mav = new ModelAndView("dateSearch");
        return mav;
    }

    @GetMapping("/docIDSearch")
    public ModelAndView docIDSearch(){
        ModelAndView mav = new ModelAndView("docIDSearch");
        return mav;
    }

    @GetMapping("/iPSearch")
    public ModelAndView iPSearch(){
        ModelAndView mav = new ModelAndView("iPSearch");
        return mav;
    }

    @GetMapping("/sapDocIDSearch")
    public ModelAndView sapDocIDSearch(){
        ModelAndView mav = new ModelAndView("sapDocIDSearch");
        return mav;
    }

    @GetMapping("/timeSearch")
    public ModelAndView timeSearch(){
        ModelAndView mav = new ModelAndView("timeSearch");
        return mav;
    }

    @GetMapping("/file/{resultFilename}")
    public Resource getDownloadFile(@PathVariable String resultFilename) {
        return storageService.loadAsResource(resultFilename);
    }

    @GetMapping("/downloadSearch")
    public ModelAndView downloadSearch(){
        ModelAndView mav = new ModelAndView("downloadSearch");
        return mav;
    }
}


