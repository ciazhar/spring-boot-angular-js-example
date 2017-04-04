package com.ciazhar.controllers;

import com.ciazhar.dao.AplikasiDao;
import com.ciazhar.entity.Aplikasi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_STAFF')")
    @RequestMapping(value = "/aplikasi", method = RequestMethod.GET)
    @ResponseBody
    public Page<Aplikasi> daftarAplikasi(Pageable page){
        return dao.findAll(page);
    }

    @PreAuthorize("hasAuthority('EDIT')")
    @RequestMapping(value="/aplikasi/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void hapusAplikasi(@PathVariable("id") String id){
        dao.delete(id);
    }

    @PreAuthorize("hasAuthority('EDIT')")
    @RequestMapping(value="/aplikasi", method = RequestMethod.POST)
    public void insertAplikasiBaru(@RequestBody @Valid Aplikasi m){
        dao.save(m);
    }

    @PreAuthorize("hasAuthority('EDIT')")
    @RequestMapping(value="/aplikasi/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Aplikasi findAplikasi(@PathVariable("id")String id){
        return dao.findOne(id);
    }
}
