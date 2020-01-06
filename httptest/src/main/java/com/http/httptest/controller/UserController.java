package com.http.httptest.controller;

import com.http.httptest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ：clt
 * @Date ：Created in 10:19 2019/9/29
 */

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    @ResponseBody
    public Map<String,String> test(HttpServletRequest request, @RequestParam(defaultValue = "123") String username){
        System.out.println(username);
        Map<String,String> map = new HashMap<>(16);
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        System.out.println(ip);


        map.put("测试","100" );
        return map;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> login(@RequestParam String user, @RequestParam String pass,HttpServletRequest request ){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        System.out.println(ip);
        System.out.println(request.getRequestURL());

        Map<String,String> map = new HashMap<>(16);
        if (userMapper.login(user,pass) != null){
            map.put("message", "登录成功");
            map.put("code", "200");
        } else {
            map.put("message", "密码错误");
            map.put("code", "500");
        }
        return map;
    }
}
