package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_invoice_detail")
public class InvoiceDetail {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_invoice_dt")
    private int id;

    @Setter
    @Getter
    @Column(name="id_invoice_hd")
    private Integer idInvoiceHd;

    @Setter
    @Getter
    @Column(name="no_kwitansi")
    private String noKwitansi;

    @Setter
    @Getter
    @Column(name="id_biaya")
    private Integer idBiaya;

    @Setter
    @Getter
    @Column(name="biaya")
    private Integer biaya;

    @Setter
    @Getter
    @Column(name="keterangan")
    private String keterangan;

    @Setter
    @Getter
    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";
}
