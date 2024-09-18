package org.fs.logfileanalyzeratweb.Controller;

//@Controller

//public class FController {
//    @GetMapping("/startpage")
//    public ModelAndView showStartpage(){
//        ModelAndView mav = new ModelAndView("startpage");
//        return mav;
//    }
//
//    @GetMapping("/inputFileSelection")
//    public ModelAndView inputFileSelection(){
//        ModelAndView mav = new ModelAndView("inputFileSelection");
//        return mav;
//    }
//
//    @PostMapping("/submitInputPath")
//    public String submitInputPath(){
//        return "redirect:/outputFolderSelection";
//    }
//
//    @GetMapping("/outputFolderSelection")
//    public ModelAndView outputFileSelection(){
//        ModelAndView mav = new ModelAndView("outputFolderSelection");
//        return mav;
//    }
//
//    @PostMapping("/submitOutputPath")
//    public String submitOutputPath(){
//        return "redirect:/searchOption";
//    }
//
//    @GetMapping("/searchOption")
//    public ModelAndView showText(){
//        ModelAndView mav = new ModelAndView("searchOption");
//        Textsearch mytext = new Textsearch();
//        mav.addObject("textsearch", mytext);
//        return mav;
//    }

//   @GetMapping("/textSearch")
//   public ModelAndView textSearch(){
//       ModelAndView mav = new ModelAndView("textSearch");
//       return mav;
//   }
//
//
//    @PostMapping("/textSearch")
//    public String performSearch(Model model) throws IOException {
//        // Werte von den verschiedenen Klassen abrufen
//        InputFileProvider inputFileProvider = new InputFileProvider("inputFile");
//        SearchTextProvider searchTextProvider = new SearchTextProvider("dummy");
//        OutputFolderProvider outputFolderProvider = new OutputFolderProvider("output.txt");
//
//        // Textsearch aufrufen
//        Textsearch textsearch = new Textsearch();
//        textsearch.textsearch(inputFileProvider.getInputFile(), searchTextProvider.getSearchText(), outputFolderProvider.outputFolder());
//        return "Status";
//    }



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
//}










