package com.invest.investment.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nama_lengkap", nullable = false)
    private String namaLengkap;

    @Column(name = "no_hp_string", nullable = false)
    private String noHp;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}
