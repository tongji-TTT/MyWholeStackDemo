package com.example.backend.Entity;

import lombok.Data;

@Data
public class User {
    private int id;
    public String password;
    public String name;
}
