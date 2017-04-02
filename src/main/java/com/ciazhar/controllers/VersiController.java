package com.ciazhar.controllers;

import com.ciazhar.dao.VersiDao;
import com.ciazhar.entity.Versi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @RequestMapping("/versi/{id_versi}")
//    public Page<Versi> daftarVersiByIdAplikasi (@PathVariable("id_aplikasi") String id_aplikasi,
//                                                @SortDefault("tanggalDibuat") Pageable pageable){
//        return versiDao.findByIdAplikasi(id_aplikasi,pageable);
//    }

//    @RequestMapping("/versi/detil/{id_versi}")
//    public Versi detilVersi(@PathVariable ("id_versi") String id_versi){
//        return versiDao.findOne(id_versi);
//    }

}
