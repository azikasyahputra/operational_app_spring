package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "master_buku_kas")
public class BukuKas {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_kas")
    private int id;

    @Setter
    @Getter
    @Column(name = "no_transaksi",nullable = false)
    private String noTransaksi;

    @Setter
    @Getter
    @Column(name = "tanggal_transaksi")
    private LocalDate tanggalTransaksi;

    @Setter
    @Getter
    @Column(name = "total_kredit")
    private Integer totalKredit;

    @Setter
    @Getter
    @Column(name = "total_debit")
    private Integer totalDebit;

    @Setter
    @Getter
    @Column(name = "deleted",nullable = false)
    private String deleted="Tidak";

    @Setter
    @Getter
    @OneToMany(mappedBy = "bukuKas", cascade = CascadeType.ALL)
    private List<BukuKasDetail> bukuKasDetails;
}
