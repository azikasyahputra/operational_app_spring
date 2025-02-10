package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "master_order_trucking")
public class OrderTrucking {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_trucking")
    private int id;

    @Setter
    @Getter
    @Column(name="no_invoice")
    private String noInvoice;

    @Setter
    @Getter
    @Column(name="id_client")
    private Integer idClient;

    @Setter
    @Getter
    @Column(name="tanggal_order")
    private LocalDate tanggalOrder;

    @Setter
    @Getter
    @Column(name="no_aju",nullable = false)
    private String noAju;

    @Setter
    @Getter
    @Column(name="id_supir")
    private Integer idSupir;

    @Setter
    @Getter
    @Column(name="tujuan",nullable = false)
    private String tujuan;

    @Setter
    @Getter
    @Column(name="container",nullable = false)
    private String container;

    @Setter
    @Getter
    @Column(name="kemasan",nullable = false)
    private String kemasan;

    @Setter
    @Getter
    @Column(name="ongkos",nullable = false)
    private Integer ongkos;

    @Setter
    @Getter
    @Column(name="dp",nullable = false)
    private Integer dp;

    @Setter
    @Getter
    @Column(name="uang_jalan",nullable = false)
    private Integer uangJalan;

    @Setter
    @Getter
    @Column(name="kasbon_uang_jalan",nullable = false)
    private Integer kasbonUangJalan;

    @Setter
    @Getter
    @Column(name="lift_off",nullable = false)
    private Integer liftOff;

    @Setter
    @Getter
    @Column(name="uang_bongkar",nullable = false)
    private Integer uangBongkar;

    @Setter
    @Getter
    @Column(name="lain_lain",nullable = false)
    private Integer lainLain;

    @Setter
    @Getter
    @Column(name="komisi_supir",nullable = false)
    private Integer komisiSupir;

    @Setter
    @Getter
    @Column(name="komisi_kenek",nullable = false)
    private Integer komisiKenek;

    @Setter
    @Getter
    @Column(name="laba",nullable = false)
    private Integer laba;

    @Setter
    @Getter
    @Column(name="flag_bayar",nullable = false)
    private String flagBayar;

    @Setter
    @Getter
    @Column(name="flag_pengeluaran",nullable = false)
    private String flagPengeluaran;

    @Setter
    @Getter
    @Column(name="keterangan_bayar")
    private String keteranganBayar;

    @Setter
    @Getter
    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";
}
