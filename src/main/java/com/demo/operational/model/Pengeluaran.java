package com.demo.operational.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_pengeluaran_header")
public class Pengeluaran {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pengeluaran")
    private int id;

    @Setter
    @Getter
    @Column(name = "id_invoice")
    private Integer idInvoice;

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
    @Column(name = "jumlah_biaya")
    private Integer jumlahBiaya;

    @Setter
    @Getter
    @Column(name = "keterangan_jumlah_biaya")
    private String keteranganJumlahBiaya;

    @Setter
    @Getter
    @Column(name = "biaya_terbilang",nullable = false)
    private String biayaTerbilang;

    @Setter
    @Getter
    @Column(name = "deleted",nullable = false)
    private String deleted="Tidak";

    @Setter
    @Getter
    @OneToMany(mappedBy = "pengeluaran", cascade = CascadeType.ALL)
    private List<PengeluaranDetail> pengeluaranDetails;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "id_invoice",referencedColumnName = "id_invoice", nullable = false, insertable = false, updatable = false)
    private Invoice invoice;
}
