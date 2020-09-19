package com.baizhi.dao;

import com.baizhi.DTO.UserDTO;

import java.util.List;

public interface UserDao {
    public Integer getCountByDate(Integer day);
    public List<UserDTO> queryUserByProvince();
}
