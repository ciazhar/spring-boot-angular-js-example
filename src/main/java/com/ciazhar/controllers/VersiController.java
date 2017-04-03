package com.ciazhar.controllers;

import com.ciazhar.dao.AplikasiDao;
import com.ciazhar.dao.VersiDao;
import com.ciazhar.entity.Aplikasi;
import com.ciazhar.entity.Versi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by ciazhar on 4/1/17.
 */

@RestController
@RequestMapping("api")
public class VersiController {

    @Autowired
    private VersiDao versiDao;

    @RequestMapping("/versi")
    public Page<Versi> daftarVersi (@SortDefault("tanggalDibuat") Pageable pageable){
        return versiDao.findAll(pageable);
    }

    @RequestMapping("/versi/aplikasi/{id_aplikasi}")
    public Page<Versi> daftarVersiByIdAplikasi (@PathVariable("id_aplikasi") String id_aplikasi, Pageable pageable){
        return versiDao.findByAplikasiId(id_aplikasi, pageable);
    }

    @RequestMapping(value = "/versi/", method = RequestMethod.GET)
    public Versi detilVersi(@RequestParam("id") String id){
        return versiDao.findOne(id);
    }

    @RequestMapping(value = "/versi", method = RequestMethod.POST)
    public void simpanVersi(@RequestBody @Valid Versi versi){
        versiDao.save(versi);
    }



}
