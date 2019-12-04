package org.nh.shiro.auth.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.nh.common.web.ResponseResult;
import org.nh.shiro.auth.domian.AuthUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: LoginController.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 14:56
 */
@Controller
@RequestMapping(value = "/login")
@Log4j2
public class LoginController {

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<String> auth(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        Map<String, String> map=new HashMap<>();
        try {
            subject.login(usernamePasswordToken);
            AuthUser user= (AuthUser) subject.getPrincipal();
            session.setAttribute("user", user);
            return new ResponseResult<>("/index");
        } catch (IncorrectCredentialsException e) {
            map.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            map.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            map.put("msg", "该用户不存在");
        } catch (Exception e) {
            //返回登录页面
            return new ResponseResult<>("/login");
        }
        return new ResponseResult<>(map.toString());
    }

    @RequestMapping(value = "/logout")
    public String loginOut(HttpServletRequest request) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        String username = ((AuthUser)subject.getPrincipal()).getUsername();
        if(subject.isAuthenticated()){
            subject.logout();
            log.info("用户:" + username + "已登出.");
        }
        return "login";
    }

}
