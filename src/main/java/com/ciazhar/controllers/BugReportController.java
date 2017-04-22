package com.ciazhar.controllers;

import com.ciazhar.dao.BugDao;
import com.ciazhar.entity.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by ciazhar on 4/20/17.
 */

@Controller
public class BugReportController {
    @Autowired private BugDao dao;

    @RequestMapping("/bug")
    public ModelAndView generateAllBugReport(ModelAndView m,
                                             @RequestParam(value = "format", required = false) String format){
        Iterable<Bug> data = dao.findAll();
        m.addObject("dataSource", data);
        m.addObject("tanggalUpdate", new Date());
        m.addObject("format", "pdf");

        if(format != null && !format.isEmpty()){
            m.addObject("format", format);
        }

        m.setViewName("report_bug");
        return m;
    }
}
