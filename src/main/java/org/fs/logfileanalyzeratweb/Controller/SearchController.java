package org.fs.logfileanalyzeratweb.Controller;

import org.fs.logfileanalyzeratweb.Entity.SearchModel;
import org.fs.logfileanalyzeratweb.Entity.Textsearch;
import org.fs.logfileanalyzeratweb.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller("/search")
public class SearchController {

    private final Textsearch textsearch;
    private final StorageService storageService;

    @Autowired
    public SearchController(Textsearch textsearch, StorageService storageService) {
        this.textsearch = textsearch;
        this.storageService = storageService;
    }

    @PostMapping()
    public ModelAndView getDownloadFileView(@RequestBody SearchModel searchModel) throws IOException {
        ModelAndView search = new ModelAndView("downloadSearch");
        String resultFilename = "result-"+searchModel.getFile().getOriginalFilename();
        search.addObject("filename", resultFilename);

        File file = storageService.createFile(resultFilename);


        textsearch.textsearch(searchModel.getFile(), searchModel.getSearch(), file);
        return search;
    }

    @GetMapping("/file/{filename}")
    public Resource getDownloadFile(@PathVariable String filename) {
        return storageService.loadAsResource(filename);
    }



}
