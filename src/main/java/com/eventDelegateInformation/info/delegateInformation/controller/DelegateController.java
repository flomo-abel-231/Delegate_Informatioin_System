package com.eventDelegateInformation.info.delegateInformation.controller;

import com.eventDelegateInformation.info.delegateInformation.entity.Delegate;
import com.eventDelegateInformation.info.delegateInformation.repository.DelegateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class DelegateController {

    @Autowired
    private DelegateRepository delegateRepo;

    // Handler method for viewing delegates list
    @GetMapping({"/showDelegate","/" ,"/list"})
    public ModelAndView showDelegates() {
        ModelAndView mav = new ModelAndView("delegates_list");
        List<Delegate> list = delegateRepo.findAll();
        mav.addObject("delegates", list);
        return mav;

    }
    // Handler method for creating new event delegates
    @GetMapping({"/addDelegateForm"})
    public ModelAndView addDelegateForm() {
        ModelAndView mav = new ModelAndView("add-delegate");
        Delegate newDelegate = new Delegate();
        mav.addObject("delegate", newDelegate);
        return mav;


    }

    // Handler method to save new delegate to our event list
    @PostMapping({"/saveDelegate"})
    public String saveDelegate(@ModelAttribute Delegate delegate){
        delegateRepo.save(delegate);
        return "redirect:/list";
    }

    //Handler method to perform update of the delegate list
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long delegateId) {
        ModelAndView mav = new ModelAndView("add-delegate");
        Delegate delegate = delegateRepo.findById(delegateId).get();
        mav.addObject("delegate",delegate);
        return mav;

    }
    //Handler method to delete delegates info from the database(list)
    @GetMapping("/deleteDelegate")
    public String deleteDelegate(@RequestParam Long delegateId){
        delegateRepo.deleteById(delegateId);
        return "redirect:/list";
    }



}
