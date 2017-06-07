package com.ciazhar.controllers;

import com.ciazhar.dao.BugDao;
import com.ciazhar.entity.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ciazhar on 4/6/17.
 */

@Controller
@RequestMapping("/api")
public class BugController {

    @Autowired
    private BugDao dao;

    @RequestMapping(value = "/bug", method = RequestMethod.GET)
    @ResponseBody
    public Page<Bug> daftarBug(Pageable page){
        return dao.findAll(page);
    }

    @RequestMapping(value="/bug/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void hapusBug(@PathVariable("id") String id){
        dao.delete(id);
    }

    @RequestMapping(value="/bug", method = RequestMethod.POST)
    public void insertBugBaru(@RequestBody @Valid Bug b){
        dao.save(b);
    }

    @RequestMapping(value="/bug/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Bug findBug(@PathVariable("id")String id){
        return dao.findOne(id);
    }

    @RequestMapping(value="/bug/versi/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Bug> findBugByVersiId(@PathVariable("id")String id, Pageable pageable){
        return dao.findByVersiId(id,pageable);
    }

    @RequestMapping(value="/bug/aplikasi/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Bug> findBugByAplikasiId(@PathVariable("id")String id,Pageable pageable){
        return dao.findByAplikasiId(id, pageable);
    }
}
