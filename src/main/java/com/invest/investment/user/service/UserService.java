package com.invest.investment.user.service;

import com.invest.investment.exception.PermintaanTidakDikabulkanException;
import com.invest.investment.exception.TidakKetemuException;
import com.invest.investment.user.entity.UserEntity;
import com.invest.investment.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    //cari semua user
    public List<UserEntity> cariSemuaUser() {return userRepository.findAll();}

    //cari lalui id
    public UserEntity cariDariIdUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new TidakKetemuException("Pengguna dengan id"+id+"tidak ada"));
    }

    //nambah pengguna
    public UserEntity tambahUser(UserEntity userEntity){
        //pake Valid manual

        if (!StringUtils.hasText(userEntity.getNamaLengkap())){
            throw new PermintaanTidakDikabulkanException("Nama Lengkap Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getUserName())){
            throw new PermintaanTidakDikabulkanException("Username Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getNoHp())){
            throw new PermintaanTidakDikabulkanException("No Hp Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getEmail())){
            throw new PermintaanTidakDikabulkanException("Email Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getPassword())){
            throw new PermintaanTidakDikabulkanException("Password Harus Diisi");
        }

        return userRepository.save(userEntity);

    }

    public UserEntity updateUser(UserEntity userEntity, Long userId){

        UserEntity user = userRepository.findById(userId).get();

        if (userEntity.getId() == null){
            throw new PermintaanTidakDikabulkanException("Maaf Id yang ingin anda Edit memiliki Angel Card")
        }
        if (!StringUtils.hasText(userEntity.getNamaLengkap())){
            throw new PermintaanTidakDikabulkanException("Nama Lengkap Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getUserName())){
            throw new PermintaanTidakDikabulkanException("Username Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getNoHp())){
            throw new PermintaanTidakDikabulkanException("No Hp Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getEmail())){
            throw new PermintaanTidakDikabulkanException("Email Harus Diisi");
        }
        if (!StringUtils.hasText(userEntity.getPassword())){
            throw new PermintaanTidakDikabulkanException("Password Harus Diisi");
        }

        UserEntity user = userRepository.findById(userId).get();

    }

    //Hapus pengguna
    public void hapusPakeId(Long id){userRepository.deleteById(id);}



}
