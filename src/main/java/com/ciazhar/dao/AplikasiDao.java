package com.ciazhar.dao;

import com.ciazhar.entity.Aplikasi;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ciazhar on 3/30/17.
 */

public interface AplikasiDao extends PagingAndSortingRepository<Aplikasi,String > {
}
