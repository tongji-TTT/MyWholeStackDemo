package com.example.backend.Service.Impl;

import com.example.backend.DAO.UserMapper;
import com.example.backend.Entity.User;
import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser()
    {
        return userMapper.findUser(1951725);
    }
}
