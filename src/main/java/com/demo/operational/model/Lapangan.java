package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_lapangan")
public class Lapangan {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lapangan")
    private int id;

    @Setter
    @Getter
    @Column(name="nama_lapangan",nullable = false)
    private String namaLapangan;

    @Setter
    @Getter
    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";
}
