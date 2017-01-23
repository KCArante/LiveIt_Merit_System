package com.spring.service;

import com.spring.entities.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    List<Users> getUsers(Users searchObject, int startPage, int maxResults);

    void insertUser(Users user);

    void updateUser(Users user);

    void deleteUser(List<String> userIds);

    Users getUserByUserId(String strUserId);
}
