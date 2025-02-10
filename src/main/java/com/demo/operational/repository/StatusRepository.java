package com.demo.operational.repository;

import com.demo.operational.model.Status;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends BaseRepository<Status,Integer> {
    //
}
