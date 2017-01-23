package com.spring.dao;

import com.spring.entities.Users;

import java.util.List;

public interface UsersDao {

    List<Users> getAllUsers();

    List<Users> getUsers(Users searchObject, int startPage, int maxResults);

    void insertUser(Users user);

    void updateUser(Users user);

    void deleteUser(List<String> userIds);

    Users getUserByUserId(String strUserId);
}
