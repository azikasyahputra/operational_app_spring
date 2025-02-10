package com.demo.operational.model;

import com.demo.operational.validation.CreateGroup;
import com.demo.operational.validation.UpdateGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_client")
public class Klien {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int id;

    @Setter
    @Getter
    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class},message = "Nama Klien Required")
    @Column(name = "nama_client",nullable = false)
    private String namaClient;

    @Setter
    @Getter
    @NotBlank(message = "Alamat Klien Required")
    @Column(name = "alamat_client",nullable = false)
    private String alamatClient;

    @Setter
    @Getter
    @NotBlank(message = "Kota Klien Required")
    @Column(name = "kota_client",nullable = false)
    private String kotaClient;

    @Setter
    @Getter
    @NotBlank(message = "Kodepos Klien Required")
    @Column(name = "kodepos_client")
    private Integer kodeposClient;

    @Setter
    @Getter
    @Column(name = "deleted",nullable = false)
    private String deleted="Tidak";
}
