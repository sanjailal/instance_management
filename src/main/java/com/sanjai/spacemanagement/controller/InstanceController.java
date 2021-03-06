package com.sanjai.spacemanagement.controller;

import com.sanjai.spacemanagement.dao.InstanceDetailsRepo;
import com.sanjai.spacemanagement.dao.InstanceRepo;
import com.sanjai.spacemanagement.models.Instance;
import com.sanjai.spacemanagement.models.InstanceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SpringBootApplication(scanBasePackages={"com.sanjai.spacemanagement", "com.sanjai.spacemanagement.dao"})
@Controller
public class InstanceController {
    @Autowired
    InstanceRepo instrepo;

    @Autowired
    InstanceDetailsRepo detailsRepo;

    private int autoinc=0;

    @RequestMapping(value="/get")  // Display all fields in the page
    public ModelAndView getInstance()
    {
        ModelAndView mv= new ModelAndView();
        List<Instance> inst = instrepo.findAll();
        List<InstanceDetails> latUandT = detailsRepo.findByDistinctAscendingInstId();
        mv.addObject("detail",latUandT);
        mv.addObject("data",inst);
        mv.setViewName("home.jsp");
        System.out.println(mv);
        return mv;
    }



    @PostMapping("/post")        // create a new instance
    public String postInstance(Instance instance){
        ModelAndView mv=new ModelAndView();
        instrepo.save(instance);
        mv.setViewName("home.jsp");
        return "/get";
    }

    @GetMapping("/del/{id}")   // delete a particular instance
    public String deleteInstance(@PathVariable int id){
        Instance idToDel =instrepo.getOne(id);
        instrepo.delete(idToDel);
        return "/get";
    }

    @RequestMapping(path = "put/{id}")
    public ModelAndView releaseInstance(@PathVariable("id") String id, ModelMap model) {
        Instance instance = instrepo.findById(Integer.parseInt(id)).orElse(null);
        Boolean state = instance.isState();
        String purpose;
        if (state.equals(true)) {
            instance.setState(false);
            purpose="Out";
        }
        else {
            instance.setState(true);
            purpose = "In";
        }
        instrepo.save(instance);
        autoinc++;
        InstanceDetails inst=new InstanceDetails(autoinc,id,purpose,"Person X");
        detailsRepo.save(inst);
        ModelAndView mv = new ModelAndView("redirect:/get", model);
        return mv;
    }


    @RequestMapping(value="/getdetails")  // Display all instance details in the page
    @ResponseBody
    public List<InstanceDetails> getInstanceDetails()
    {
        return detailsRepo.findAll();
    }

    @RequestMapping(value="/getdetails/{id}")  // Display the particular instance details
    public ModelAndView getInstanceDetails(@PathVariable String id)
    {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("/instanceDetails.jsp");
        List<InstanceDetails> inst = detailsRepo.findAllByInstanceId(id);
        mv.addObject("data",inst);
        System.out.println(mv);
        return mv;
//        Pageable firstPageWithTenProducts= PageRequest.of(0, 10, Sort.by("id").descending());
//        List<InUsage> usages=detailsRepo.findAllByInstanceId(id,firstPageWithTenProducts);
//        return usages;

    }

    @PostMapping("/search/{name}")
    public ModelAndView searchInstance(@PathVariable String name) {
        ModelAndView mv = new ModelAndView();
        System.out.println(name);
        if (name != null) {
            List<Instance> inst = instrepo.search(name);
            System.out.println(inst.size());
            mv.addObject("data", inst);
            mv.setViewName("/home.jsp");
            return mv;
        } else {
            List<Instance> inst = instrepo.findAll();
            System.out.println("HELLO");
            mv.addObject("data", inst);
            mv.setViewName("/home.jsp");
            return mv;
        }
    }
}
