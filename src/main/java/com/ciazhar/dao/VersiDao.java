package com.ciazhar.dao;

import com.ciazhar.entity.Versi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ciazhar on 3/30/17.
 */

public interface VersiDao extends PagingAndSortingRepository<Versi,String> {
//    public Page<Versi> findByIdAplikasi(String keyword, Pageable pageable);
}
