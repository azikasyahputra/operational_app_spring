package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_referensi")
public class Referensi {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_referensi")
    private int idReferensi;

    @Setter
    @Getter
    @Column(name="kode_referensi", nullable = false)
    private String kodeReferensi;

    @Setter
    @Getter
    @Column(name = "keterangan_referensi",nullable = false)
    private String keteranganReferensi;

    @Setter
    @Getter
    @Column(name = "flag_buku_kas",nullable = false)
    private String flagBukuKas;

    @Setter
    @Getter
    @Column(name = "deleted",nullable = false)
    private String deleted="Tidak";
}
