package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;

@Controller
@RequestMapping("/api")
public class HomeController {
 @Autowired
private CustomerService customerService;
 @GetMapping("/showMyLoginPage")
 public String showMyLoginPage(){
     return "fancy-login";
 }
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }
    @GetMapping("/systems")
    public String showSystems(){
     return "systems";
    }
    @GetMapping("access-denied")
    public String showAccessDenied(){
     return "access-denied";
    }
//@RequestMapping(value = "/list",method = RequestMethod.GET )
  @GetMapping(value = "/list")
    public String listCustomer(Model model){
List<Customer>theCustomers= customerService.getCustomers();
    model.addAttribute("customers",theCustomers);
    return "list-customer";
}
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
customerService.saveCustomer(theCustomer);
      return "redirect:/api/list";
    }
@GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel){
     Customer theCustomer=customerService.getCustomer(theId);
     theModel.addAttribute("customer",theCustomer);
      return "customer-form";
}
    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {
         customerService.deleteCustomer(theId);
        return "redirect:/api/list";
    }
  }
