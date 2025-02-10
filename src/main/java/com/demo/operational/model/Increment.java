package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "master_increment")
public class Increment {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nama_modul")
    private String namaModul;

    @Column(name = "hitung")
    private Integer hitung;

    @Column(name = "tahun",nullable = false)
    private String tahun;

    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";
}
