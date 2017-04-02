package com.ciazhar.dao;

import com.ciazhar.entity.Versi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ciazhar on 3/30/17.
 */

public interface VersiDao extends PagingAndSortingRepository<Versi,String> {

//    @Query(value = "select v from versi v where aplikasi.id_aplikasi = ?1 ORDER BY keyword")
//    public Page<Versi> findByAplikasiContaing(String keyword, Pageable pageable);
}
