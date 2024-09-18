package org.fs.logfileanalyzeratweb.Controller;

import org.fs.logfileanalyzeratweb.Entity.SearchModel;
import org.fs.logfileanalyzeratweb.Entity.Textsearch;
import org.fs.logfileanalyzeratweb.service.StorageService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@Controller("/search")
public class SearchController {


    private final Textsearch textsearch;
    private final StorageService storageService;


    @Autowired
    public SearchController(Textsearch textsearch, StorageService storageService) {
        this.textsearch = textsearch;
        this.storageService = storageService;
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


//    @PostMapping("/inputFile")
//    public String search(@RequestBody @NotNull SearchModel searchModel ) throws IOException {
//        //Auswählen der Datei
//        String resultFilename = "result-"+searchModel.getFile().getOriginalFilename();
//        //Speichern der Datei
//        File file = storageService.createFile(resultFilename);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        searchModel.setResultFilename(resultFilename);
//  //      return "redirect:/searchOption";
//      return search(searchModel);
//    }

    @PostMapping("/inputFile")
    public String search(@RequestBody @NotNull MultipartFile file ) throws IOException {

        File newfile = storageService.createFile(file.getOriginalFilename());
        SearchModel searchModel=new SearchModel();
        searchModel.setFile(file);
        return "redirect:/searchOption";
    }

//    @PostMapping("/inputFile")
//    public String inputFile(@RequestParam("file") MultipartFile file) {
//        // Handle the file upload
//        return "redirect:/searchOption";
//    }

    @GetMapping("/searchOption")
    public ModelAndView showText(){
        ModelAndView mav = new ModelAndView("searchOption");
        Textsearch mytext = new Textsearch();
        mav.addObject("textsearch", mytext);
        return mav;
    }

    @GetMapping("/textSearch")
    public ModelAndView textSearch(){
       ModelAndView mav = new ModelAndView("textSearch");
       return mav;
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


//    @PostMapping("/search")
//    public String performSearch(@RequestBody SearchModel searchModel) throws IOException {
//
//
// Textsearch aufrufen
//        textsearch.textsearch(searchModel.getFile(), "ante", storageService.load(searchModel.getResultFilename()).toFile());
//        search.addObject("filename", searchModel.getResultFilename());
//        return "redirect://file/{resultFilename}";
//    }

    @PostMapping("/search")
    public String performSearch(){
        return "redirect:/downloadSearch";
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
