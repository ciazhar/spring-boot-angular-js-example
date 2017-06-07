package com.ciazhar.dao;

import com.ciazhar.entity.Bug;
import com.ciazhar.entity.Versi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ciazhar on 3/30/17.
 */

public interface BugDao extends PagingAndSortingRepository<Bug,String >{
    @Query(value = "select b from Bug b where b.versi.aplikasi.id = ?1 ORDER BY id_aplikasi")
    public Page<Bug> findByAplikasiId(String id_aplikasi, Pageable pageable);

    @Query(value = "select b from Bug b where b.versi.id = ?1 ORDER BY id_versi")
    public Page<Bug> findByVersiId(String id_versi, Pageable pageable);
}
