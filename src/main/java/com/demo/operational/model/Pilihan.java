package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "master_pilihan")
public class Pilihan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pilihan")
    private int id;

    @Column(name="id_pelayaran")
    private Integer idPelayaran;

    @Column(name="id_gudang")
    private Integer idGudang;

    @Column(name="id_kosongan")
    private Integer idKosongan;

    @Column(name="id_biaya")
    private Integer idBiaya;

    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";
}
