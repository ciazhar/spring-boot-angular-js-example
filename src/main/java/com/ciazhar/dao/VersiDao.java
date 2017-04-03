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

    @Query(value = "select v from Versi v where v.aplikasi.id = ?1 ORDER BY id_aplikasi")
    public Page<Versi> findByAplikasiId(String id_aplikasi, Pageable pageable);
}
