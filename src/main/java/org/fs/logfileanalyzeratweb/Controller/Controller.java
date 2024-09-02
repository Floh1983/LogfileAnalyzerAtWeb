package org.fs.logfileanalyzeratweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private CustomerRepository cRepo;

    @GetMapping("/showCustomers")
    public ModelAndView showCustomers(){
        ModelAndView mav = new ModelAndView("list-customer");
        List<Customer> list = cRepo.findAll();
        mav.addObject("customer", list);
        return mav;
    }

    @GetMapping("/addCustomerForm")
    public ModelAndView addCustomerForm(){
        ModelAndView mav = new ModelAndView("add-customer-form");
        Customer newCustomer = new Customer();
        mav.addObject("customer", newCustomer);
        return mav;
    }

    @GetMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer){
        cRepo.save(customer);
        return "redirect:/showCustomers";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long customerId){
        ModelAndView mav = new ModelAndView("add-customer-form");
        Customer customer = cRepo.findById(customerId).get();
        mav.addObject("customer", customer);
        return mav;
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam Long customerId){
        cRepo.deleteById(customerId);
        return "redirect:/showCustomer";
    }
}










