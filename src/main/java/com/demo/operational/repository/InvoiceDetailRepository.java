package com.demo.operational.repository;

import com.demo.operational.model.InvoiceDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository extends BaseRepository<InvoiceDetail,Integer> {
    //
}