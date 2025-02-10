package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_pengeluaran_detail")
public class PengeluaranDetail {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pengeluaran_dt")
    private int id;

    @Setter
    @Getter
    @Column(name = "id_pengeluaran_hd")
    private Integer idPengeluaranHd;

    @Setter
    @Getter
    @Column(name = "no_kwitansi")
    private String noKwitansi;

    @Setter
    @Getter
    @Column(name = "id_biaya")
    private Integer idBiaya;

    @Setter
    @Getter
    @Column(name = "biaya")
    private Integer biaya;

    @Setter
    @Getter
    @Column(name = "keterangan")
    private String keterangan;

    @Setter
    @Getter
    @Column(name = "deleted",nullable = false)
    private String deleted="Tidak";

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "id_pengeluaran_hd",referencedColumnName = "id_pengeluaran", nullable = false, insertable = false, updatable = false)
    private Pengeluaran pengeluaran;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "id_biaya",referencedColumnName = "id_biaya", nullable = false, insertable = false, updatable = false)
    private Biaya biayadetail;
}
