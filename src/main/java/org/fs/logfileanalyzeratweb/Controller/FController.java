package org.fs.logfileanalyzeratweb.Controller;

import org.fs.logfileanalyzeratweb.Entity.Textsearch;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class FController {
    @GetMapping("/startpage")
    public ModelAndView showStartpage(){
        ModelAndView mav = new ModelAndView("startpage");
        return mav;
    }

//    @GetMapping("/showText")
//    public ModelAndView showText(){
//        ModelAndView mav = new ModelAndView("text");
//        Textsearch mytext = new Textsearch();
//        mav.addObject("textsearch", mytext);
//        return mav;
//    }

    @PostMapping("/search")
    public void searchFile(@RequestParam("filePath") String inputFile,
                             @RequestParam("searchText") String searchText,
                             @RequestParam("output.txt") String outputFile
                             ) {


//        Textsearch textsearch = new Textsearch(inputFile, searchText, outputFile);
//        return;
    }


//    @GetMapping("/addCustomerForm")
//    public ModelAndView addCustomerForm(){
//        ModelAndView mav = new ModelAndView("add-customer-form");
//        Customer newCustomer = new Customer();
//        mav.addObject("customer", newCustomer);
//        return mav;
//    }
//
//    @GetMapping("/saveCustomer")
//    public String saveCustomer(@ModelAttribute Customer customer){
//        cRepo.save(customer);
//        return "redirect:/showCustomers";
//    }
//
//    @GetMapping("/showUpdateForm")
//    public ModelAndView showUpdateForm(@RequestParam Long customerId){
//        ModelAndView mav = new ModelAndView("add-customer-form");
//        Customer customer = cRepo.findById(customerId).get();
//        mav.addObject("customer", customer);
//        return mav;
//    }
//
//    @GetMapping("/deleteCustomer")
//    public String deleteCustomer(@RequestParam Long customerId){
//        cRepo.deleteById(customerId);
//        return "redirect:/showCustomer";
//    }
}










