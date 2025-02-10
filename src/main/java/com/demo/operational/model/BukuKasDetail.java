package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "master_buku_kas_detail")
public class BukuKasDetail {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_kas_dt")
    private int id;

    @Getter
    @Setter
    @Column(name= "id_kas_hd")
    private Integer idKasHd;

    @Getter
    @Setter
    @Column(name = "id_referensi")
    private Integer idReferensi;

    @Getter
    @Setter
    @Column(name = "keterangan")
    private String keterangan;

    @Getter
    @Setter
    @Column(name = "biaya_debit")
    private Integer biayaDebit;

    @Getter
    @Setter
    @Column(name = "biaya_kredit")
    private Integer biayaKredit;

    @Getter
    @Setter
    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Setter
    @Getter
    @Column(name = "deleted", nullable = false)
    private String deleted="Tidak";

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_kas_hd",referencedColumnName = "id_kas", nullable = false, insertable = false, updatable = false)
    private BukuKas bukuKas;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "id_referensi",referencedColumnName = "id_referensi", nullable = false, insertable = false, updatable = false)
    private Referensi referensi;
}