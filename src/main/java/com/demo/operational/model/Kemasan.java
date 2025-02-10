package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_kemasan")
public class Kemasan {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_kemasan")
    private int id;

    @Setter
    @Getter
    @Column(name="nama_kemasan",nullable = false)
    private String namaKemasan;

    @Setter
    @Getter
    @Column(name="deleted")
    private String deleted="Tidak";
}
