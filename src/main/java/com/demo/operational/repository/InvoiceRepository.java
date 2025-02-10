package com.demo.operational.repository;

import com.demo.operational.model.Invoice;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice,Integer> {
    @Query("SELECT COUNT(i) FROM Invoice i WHERE i.deleted = 'Tidak' AND i.dateCreated = :date")
    Long countInvoicesToday(LocalDate date);

    @Query("SELECT COUNT(i) FROM Invoice i WHERE i.deleted = 'Tidak' AND MONTH(i.dateCreated) = :month AND YEAR(i.dateCreated) = :year")
    Long countInvoicesThisMonth(int month, int year);

    @Query("select COALESCE((SUM(mih.kas)+SUM(mih.piutang)),0) as piutang_month " +
                "from Invoice mih " +
                "where mih.deleted ='Tidak' " +
                "and mih.dateCreated = :date")
    Double sumInvoicesToday(LocalDate date);

    @Query("select COALESCE((SUM(mih.kas)+SUM(mih.piutang)),0) as piutang_month " +
                "from Invoice mih " +
                "where mih.deleted ='Tidak' " +
                "and YEAR(mih.dateCreated) = :month " +
                "and MONTH(mih.dateCreated) = :year")
    Double sumInvoicesThisMonth(int month, int year);
}
