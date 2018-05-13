package com.transport.controller;

import com.transport.model.Inquiry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    @GetMapping("/")
    public ModelAndView home1() {
        ModelAndView model = new ModelAndView();
        model.addObject("inquiry", new Inquiry());
        model.setViewName("home");
        return model;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        model.addObject("inquiry", new Inquiry());
        model.setViewName("home");
        return model;
    }



    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView model = new ModelAndView();
        model.setViewName("about");
        return model;
    }

    @GetMapping("/thankyou")
    public ModelAndView thankyou() {
        ModelAndView model = new ModelAndView();
        model.setViewName("thankyou");
        return model;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}
