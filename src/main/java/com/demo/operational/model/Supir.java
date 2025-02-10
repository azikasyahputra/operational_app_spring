package com.demo.operational.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_supir")
public class Supir {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supir")
    private int id;

    @Setter
    @Getter
    @Column(name="name_supir")
    private String namaSupir;

    @Setter
    @Getter
    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";
}
