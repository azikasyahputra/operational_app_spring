package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_jenis_dokumen")
public class JenisDokumen {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jenis_dokumen")
    private int id;

    @Setter
    @Getter
    @Column(name="nama_dokumen",nullable = false)
    private String namaDokumen;

    @Setter
    @Getter
    @Column(name="alias",nullable = false)
    private String alias;

    @Setter
    @Getter
    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";
}
