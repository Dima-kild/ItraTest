package com.example.ItraTest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
