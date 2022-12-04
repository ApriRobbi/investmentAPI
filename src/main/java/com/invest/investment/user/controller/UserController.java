package com.invest.investment.user.controller;

import com.invest.investment.user.entity.UserEntity;
import com.invest.investment.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController { //semuanya merupakan method

    @Autowired
    private UserService userService;

    //cari semua pengguna
    @GetMapping("/user")
    public List<UserEntity> cariSemuaUser(){return userService.cariSemuaUser();}

    //cari by Id
    @GetMapping("/user/{id}")
    public UserEntity cariDariId(@PathVariable("id")Long id{
        return userService.cariDariIdUser(id);
    }

    //tambah user
    @PostMapping("/user")
    public UserEntity tambahUser(@RequestBody UserEntity userEntity){
        return userService.tambahUser(userEntity);
    }

    //edit user
    @PutMapping("/user/{id}")
    public UserEntity editUser(@PathVariable("id")Long userId,
                               @RequestBody UserEntity userEntity){
        return userService.updateUser(userEntity, userId);
    }

    //hapus user
    @DeleteMapping("/produk/{id}")
    public void hapusDariId(@PathVariable("id")Long userId,){
        userService.hapusPakeId(userId);
    }



}
