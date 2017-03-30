package com.ciazhar.dao;

import com.ciazhar.entity.Bug;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ciazhar on 3/30/17.
 */

public interface BugDao extends PagingAndSortingRepository<Bug,String >{

}
