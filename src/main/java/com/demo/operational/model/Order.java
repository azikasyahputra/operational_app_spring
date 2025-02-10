package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "master_order")
public class Order {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;

    @Setter
    @Getter
    @Column(name = "no_order",nullable = false)
    private String noOrder;

    @Setter
    @Getter
    @Column(name = "tanggal_order")
    private LocalDate tanggalOrder;

    @Setter
    @Getter
    @Column(name = "no_aju",nullable = false)
    private String noAju;

    @Setter
    @Getter
    @Column(name = "id_client")
    private Integer idClient;

    @Setter
    @Getter
    @Column(name = "kemasan",nullable = false)
    private String kemasan;

    @Setter
    @Getter
    @Column(name = "no_container",nullable = false)
    private String noContainer;

    @Setter
    @Getter
    @Column(name = "id_jenis_dokumen")
    private Integer idJenisDokumen;

    @Setter
    @Getter
    @Column(name = "name_kapal_pesawat",nullable = false)
    private String namaKapalPesawat;

    @Setter
    @Getter
    @Column(name = "tanggal_kapal_pesawat")
    private LocalDate tanggalKapalPesawat;

    @Setter
    @Getter
    @Column(name = "id_pelayaran")
    private Integer idPelayaran;

    @Setter
    @Getter
    @Column(name = "id_lapangan")
    private Integer idLapangan;

    @Setter
    @Getter
    @Column(name = "id_gudang")
    private Integer idGudang;

    @Setter
    @Getter
    @Column(name = "nama_barang",nullable = false)
    private String namaBarang;

    @Setter
    @Getter
    @Column(name = "nama_bl",nullable = false)
    private String namaBl;

    @Setter
    @Getter
    @Column(name = "nama_pos",nullable = false)
    private String namaPos;

    @Setter
    @Getter
    @Column(name = "id_kosongan")
    private Integer idKosongan;

    @Setter
    @Getter
    @Column(name = "id_status")
    private Integer idStatus;

    @Setter
    @Getter
    @Column(name = "tanggal_status")
    private LocalDate tanggalStatus;

    @Setter
    @Getter
    @Column(name = "negara_asal_tujuan",nullable = false)
    private String negaraAsalTujuan;

    @Setter
    @Getter
    @Column(name="flag_invoice",nullable = false)
    private String flagInvoice;

    @Setter
    @Getter
    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";
}
