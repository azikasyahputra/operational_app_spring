package com.demo.operational.repository;

import com.demo.operational.model.Increment;
import org.springframework.stereotype.Repository;

@Repository
public interface IncrementRepository extends BaseRepository<Increment,Integer> {
    //custom query
}
