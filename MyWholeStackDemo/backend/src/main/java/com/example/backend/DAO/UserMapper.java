package com.example.backend.DAO;


import com.example.backend.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
   public User findUser(int id);
}
