package com.ciazhar.controllers;

import com.ciazhar.dao.AplikasiDao;
import com.ciazhar.entity.Aplikasi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ciazhar on 3/30/17.
 */

@Controller
public class AplikasiController {

    @Autowired
    AplikasiDao dao;

    @RequestMapping(value = "/aplikasi", method = RequestMethod.GET)
    public Page<Aplikasi> daftarMateri(Pageable page){
        return dao.findAll(page);
    }

    @RequestMapping(value="/aplikasi/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void hapusMateri(@PathVariable("id") String id){
        dao.delete(id);
    }

    @RequestMapping(value="/aplikasi", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertMateriBaru(@RequestBody @Valid Aplikasi m){
        dao.save(m);
    }

}
