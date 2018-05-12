package com.mkyong.controller;

import com.mkyong.dao.InquiryRepository;
import com.mkyong.model.Inquiry;
import com.mkyong.model.PagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class InquiryController {

    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = { 5, 10};

    @Autowired
    private InquiryRepository inquiryRepository;


    @GetMapping("/inquiries")
    public ModelAndView getAllInquiries(@RequestParam("pageSize") Optional<Integer> pageSize,
                                 @RequestParam("page") Optional<Integer> page){

        if(inquiryRepository.count()!=0){
            ;//pass
        }else{
            generateDummyEnquiries();
        }

        ModelAndView modelAndView = new ModelAndView("inquiries");
        //
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        // print repo
        System.out.println("here is client repo " + inquiryRepository.findAll());
        Page<Inquiry> inquiries = inquiryRepository.findAll(new PageRequest(evalPage, evalPageSize));
        System.out.println("client list get total pages" + inquiries.getTotalPages() + "client list get number " + inquiries.getNumber());
        PagerModel pager = new PagerModel(inquiries.getTotalPages(),inquiries.getNumber(),BUTTONS_TO_SHOW);
        // add clientmodel
        modelAndView.addObject("inquiries",inquiries);
        // evaluate page size
        modelAndView.addObject("selectedPageSize", evalPageSize);
        // add page sizes
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        // add pager
        modelAndView.addObject("pager", pager);
        return modelAndView;

    }

    private void generateDummyEnquiries(){
        for(int i=0;i<20;i++){
            Inquiry inquiry = new Inquiry();
            inquiry.setId((long) i);
            inquiry.setName("Inquiry Name "+i);
            inquiry.setBookerAddress("Booker Address at Street address, House number, District, State, Any landmark "+i);
            inquiry.setPickupLocation("pickup Address at Street address, House number, District, State, Any landmark "+i);
            inquiry.setDropLocation("pickup Address at Street address, House number, District, State, Any landmark "+i);
            inquiry.setMobileNumber("981857460"+i);
            inquiry.setMaterialType("material type "+i);
            inquiryRepository.save(inquiry);
        }
    }
}
