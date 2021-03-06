package com.spring.controller;

import com.spring.entities.Users;
import com.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/")
    public String loadIndex(HttpServletRequest request, ModelMap map) {
        System.out.println("NISULOD XA diri");
        return this.searchUsers(request, map, null, null);
    }

    @RequestMapping(value = "/loadInsert")
    public String loadInsertUser() {
        return "users/insert";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loadUpdate")
    public String loadUpdateUser(HttpServletRequest request, ModelMap map) {
        String strUserId = request.getParameter("userId");

        System.out.print("SULOD SA UPDATE ===  ");
        Users user = usersService.getUserByUserId(strUserId);
        map.addAttribute("user", user);
        return "users/update";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/searchUsers")
    public String searchUsers(HttpServletRequest request, ModelMap map, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        String searchUserId = request.getParameter("userId");
        String searchFirstName = request.getParameter("firstName");
        String searchFamilyName = request.getParameter("familyName");
        String searchEmail = request.getParameter("email");

        Users searchObject = new Users();
        searchObject.setUserid(searchUserId);
        searchObject.setFirstName(searchFirstName);
        searchObject.setFamilyName(searchFamilyName);
        searchObject.setEmail(searchEmail);

        int pageSize = (size != null && size != 0) ? size : 25;
        int firstResultIndex = (page != null && page > 0) ? (page - 1) * pageSize : 0;
        List<Users> userList = usersService.getUsers(searchObject, firstResultIndex, pageSize);
        map.addAttribute("userList", userList);
        return "users/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteUsers")
    public String deleteUsers(HttpServletRequest request, ModelMap map) {
        String[] userIds = request.getParameterValues("userIds");
        List<String> userIdList = Arrays.asList(userIds);
        usersService.deleteUser(userIdList);
        return this.searchUsers(request, map, null, null);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertUser")
    public String insertUsers(HttpServletRequest request, ModelMap map) {
        String searchUserId = request.getParameter("userId");
        String searchFirstName = request.getParameter("firstName");
        String searchFamilyName = request.getParameter("familyName");
        String searchEmail = request.getParameter("email");

        Users insertableUser = new Users();
        insertableUser.setUserid(searchUserId);
        insertableUser.setFirstName(searchFirstName);
        insertableUser.setFamilyName(searchFamilyName);
        insertableUser.setEmail(searchEmail);

        usersService.insertUser(insertableUser);
        return this.searchUsers(request, map, null, null);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/updateUser")
    public String updateUser(HttpServletRequest request, ModelMap map) {
        String searchUserId = request.getParameter("userId");
        String searchFirstName = request.getParameter("firstName");
        String searchFamilyName = request.getParameter("familyName");
        String searchEmail = request.getParameter("email");

        Users updateableUser = new Users();
        updateableUser.setUserid(searchUserId);
        updateableUser.setFirstName(searchFirstName);
        updateableUser.setFamilyName(searchFamilyName);
        updateableUser.setEmail(searchEmail);

        System.out.println("USER ID += " + searchUserId);
        usersService.updateUser(updateableUser);
        return this.searchUsers(request, map, null, null);
    }
}
