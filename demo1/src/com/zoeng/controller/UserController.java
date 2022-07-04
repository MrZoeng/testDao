
package com.zoeng.controller;

import com.zoeng.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Zoeng on 2021/4/7
 */
@Controller
public class UserController {

    //向用户登录页面跳转
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username != null && username.equals("zmc") && password != null && password.equals("123")) {
            //将用户对象添加到Session
            session.setAttribute("USER_SESSION", user);
            //重定向到主页面的跳转方法
            return "redirect:main";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登录!");
        return "login";
    }

    //登录成功，跳转到主页面
    @RequestMapping(value = "/main")
    public String toMain(){
        return "main";
    }

    //退出登录
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        //清除Session
        session.invalidate();
        return "redirect:login";
    }
}
