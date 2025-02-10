package com.demo.operational.model;

import com.demo.operational.validation.CreateGroup;
import com.demo.operational.validation.UpdateGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "master_user")
public class User {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class},message = "Username is required")
    @Pattern(regexp = "^[^\\s]+$", message = "Username cannot contain spaces")
    @Column(name="username",nullable = false)
    private String username;

    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class},message = "Nama is required")
    @Column(name="nama",nullable = false)
    private String nama;

    @Size(groups = CreateGroup.class, min = 6, message = "Password must be at least 6 characters long")
    @NotNull(groups = CreateGroup.class)
    @Column(name="password")
    private String password;

    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class},message = "Email is required")
    @Email(groups = {CreateGroup.class, UpdateGroup.class},message = "Email must be valid")
    @Column(name="email",nullable = false)
    private String email;

    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class},message = "Role is required")
    @Column(name="role",nullable = false)
    private String role;

    @Column(name="deleted",nullable = false)
    private String deleted="Tidak";

    @Transient
    @NotBlank(groups = CreateGroup.class,message = "Confirm Password is required")
    private String confirmPassword;
}
