package com.godwei.ssmframe.controller;

import com.godwei.ssmframe.model.User;
import com.godwei.ssmframe.service.UserService;
import com.godwei.ssmframe.util.ActionReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ActionReturnUtil login(@RequestParam(value = "userName") final String userName, @RequestParam(value = "passWord") final String passWord){
        return userService.login(userName,passWord);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ActionReturnUtil showUser()throws Exception{
        return userService.getAll();
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public ActionReturnUtil deleteUser(@RequestParam(value = "userName") final String userName) throws Exception{
        return userService.deleteUser(userName);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public ActionReturnUtil updateUser(User user) throws Exception{
        return userService.updateUser(user);
    }

    @RequestMapping(value="/addUser",method = RequestMethod.PUT)
    public ActionReturnUtil addUser(User user)throws Exception{
        return userService.addUser(user);
    }

}
