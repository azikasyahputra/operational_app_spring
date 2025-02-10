package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "master_invoice_header")
public class Invoice {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice")
    private int id;

    @Setter
    @Getter
    @Column(name = "no_invoice",nullable = false)
    private String noInvoice;

    @Setter
    @Getter
    @Column(name = "tanggal_invoice")
    private LocalDate tanggalInvoice;

    @Setter
    @Getter
    @Column(name = "id_order")
    private Integer idOrder;

    @Setter
    @Getter
    @Column(name = "id_client")
    private Integer idClient;

    @Setter
    @Getter
    @Column(name = "id_pendapatan")
    private Integer idPendapatan;

    @Setter
    @Getter
    @Column(name = "pendapatan")
    private Integer pendapatan;

    @Setter
    @Getter
    @Column(name = "id_piutang")
    private Integer idPiutang;

    @Setter
    @Getter
    @Column(name = "piutang")
    private Integer piutang;

    @Setter
    @Getter
    @Column(name = "id_kas")
    private Integer idKas;

    @Setter
    @Getter
    @Column(name = "kas")
    private Integer kas;

    @Setter
    @Getter
    @Column(name = "kode_jenis_invoice")
    private String kodeJenisInvoice;

    @Setter
    @Getter
    @Column(name = "no_bl",nullable = false)
    private String noBl;

    @Setter
    @Getter
    @Column(name = "nama_kapal_pesawat",nullable = false)
    private String namaKapalPesawat;

    @Setter
    @Getter
    @Column(name = "negara_asal_tujuan",nullable = false)
    private String negaraAsalTujuan;

    @Setter
    @Getter
    @Column(name = "nama_pelayaran",nullable = false)
    private String namaPelayaran;

    @Setter
    @Getter
    @Column(name = "tanggal_berangkat")
    private LocalDate tanggalBerangkat;

    @Setter
    @Getter
    @Column(name = "nama_kemasan",nullable = false)
    private String namaKemasan;

    @Setter
    @Getter
    @Column(name = "nama_barang",nullable = false)
    private String namaBarang;

    @Setter
    @Getter
    @Column(name = "jumlah_biaya")
    private Integer jumlahBiaya;

    @Setter
    @Getter
    @Column(name = "keterangan_jumlah_Biaya")
    private String keteranganJumlahBiaya;

    @Setter
    @Getter
    @Column(name = "biaya_terbilang")
    private String biayaTerbilang;

    @Setter
    @Getter
    @Column(name = "flag_pengeluaran",nullable = false)
    private String flagPengeluaran;

    @Setter
    @Getter
    @Column(name = "flag_bayar",nullable = false)
    private String flagBayar;

    @Setter
    @Getter
    @Column(name = "deleted",nullable = false)
    private String deleted="Tidak";

    @Setter
    @Getter
    @Column(name = "date_created",nullable = false)
    private LocalDate dateCreated;

    @Setter
    @Getter
    @Column(name = "date_updated",nullable = false)
    private LocalDate dateUpdated;
}
