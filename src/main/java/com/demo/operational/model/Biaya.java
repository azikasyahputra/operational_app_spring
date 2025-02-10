package com.demo.operational.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_biaya")
public class Biaya {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_biaya")
    private int id;

    @Setter
    @Getter
//    @NotBlank(message = "Nama biaya is required")
    @Column(name = "nama_biaya",nullable = false)
    private String namaBiaya;

    @Setter
    @Getter
//    @NotBlank(message = "Kategori biaya is required")
    @Column(name= "kategori_biaya",nullable = false)
    private String kategoriBiaya;

    @Setter
    @Getter
    @Column(name = "deleted",nullable = false)
    private String deleted="Tidak";
}
