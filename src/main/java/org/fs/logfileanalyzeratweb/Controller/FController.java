package org.fs.logfileanalyzeratweb.Controller;

import org.fs.logfileanalyzeratweb.Entity.Textsearch;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FController {

//    @Autowired
//    private mytext fRepo;

    @GetMapping("/showText")
    public ModelAndView showTextsearch(){
        ModelAndView mav = new ModelAndView("text");
        Textsearch mytext = new Textsearch();
        mav.addObject("textsearch", mytext);
        return mav;
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










