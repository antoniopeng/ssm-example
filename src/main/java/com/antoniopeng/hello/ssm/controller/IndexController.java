package com.antoniopeng.hello.ssm.controller;

import com.antoniopeng.hello.ssm.common.Constants;
import com.antoniopeng.hello.ssm.entity.User;
import com.antoniopeng.hello.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginDo(Model model,
                          HttpServletRequest httpServletRequest,
                          @RequestParam(required = true) String username,
                          @RequestParam(required = true) String password) {

        User user = userService.login(username, password);
        if (user == null) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("message", "登录失败");
            return login();
        } else {
            httpServletRequest.getSession().setAttribute(Constants.SESSION_USER, user);
            return "redirect:/index";
        }
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }
}
