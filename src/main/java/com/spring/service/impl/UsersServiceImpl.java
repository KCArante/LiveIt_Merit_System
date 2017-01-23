package com.spring.service.impl;

import com.spring.dao.UsersDao;
import com.spring.entities.Users;
import com.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public List<Users> getUsers(Users searchObject, int startPage, int maxResults) {
        return usersDao.getUsers(searchObject, startPage, maxResults);
    }

    @Override
    public void insertUser(Users user) {
        usersDao.insertUser(user);

    }

    @Override
    public void updateUser(Users user) {
        usersDao.updateUser(user);
    }

    @Override
    public void deleteUser(List<String> userIds) {
        usersDao.deleteUser(userIds);
    }

    @Override
    public Users getUserByUserId(String strUserId) {
        return usersDao.getUserByUserId(strUserId);
    }

}
