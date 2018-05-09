package com.mkyong.controller;

import com.mkyong.model.Inquiry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/inquiries")
    public  String inquiries(Model model) {
        List<Inquiry> dummyEnquiries = getDummyEnquiries();
        model.addAttribute("inquiries", dummyEnquiries);
        return "inquiries";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/thankyou")
    public String thankyou() {
        return "/thankyou";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


    private List<Inquiry> getDummyEnquiries(){
      List<Inquiry> inquiries = new ArrayList<>();
      for(int i=0;i<20;i++){
          Inquiry inquiry = new Inquiry();
          inquiry.setId((long) i);
          inquiry.setName("Inquiry Name "+i);
          inquiry.setBookerAddress("Booker Address at Street address, House number, District, State, Any landmark "+i);
          inquiry.setPickupLocation("pickup Address at Street address, House number, District, State, Any landmark "+i);
          inquiry.setDropLocation("pickup Address at Street address, House number, District, State, Any landmark "+i);
          inquiry.setMobileNumber("981857460"+i);
          inquiries.add(inquiry);
      }
      return inquiries;
    }

}
