package com.demo.operational.repository;

import com.demo.operational.model.Pilihan;
import org.springframework.stereotype.Repository;

@Repository
public interface PilihanRepository extends BaseRepository<Pilihan,Integer> {
    //custom query
}
