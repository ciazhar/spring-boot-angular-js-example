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

@RestController
@RequestMapping("/api")
public class AplikasiController {

    @Autowired
    private AplikasiDao dao;


    @RequestMapping(value = "/aplikasi", method = RequestMethod.GET)
    @ResponseBody
    public Page<Aplikasi> daftarAplikasi(Pageable page){
        return dao.findAll(page);
    }

    @RequestMapping(value="/aplikasi/{id_aplikasi}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void hapusAplikasi(@PathVariable("id_aplikasi") String id_aplikasi){
        dao.delete(id_aplikasi);
    }

    @RequestMapping(value="/aplikasi", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertAplikasiBaru(@RequestBody @Valid Aplikasi m){
        dao.save(m);
    }

}
