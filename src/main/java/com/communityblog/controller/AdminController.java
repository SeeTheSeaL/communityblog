package com.communityblog.controller;

import com.alibaba.druid.util.StringUtils;
import com.communityblog.constant.LogActions;
import com.communityblog.pojo.Admin;
import com.communityblog.service.AdminService;
import com.communityblog.utils.APIResponse;
import com.communityblog.utils.IPKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController{
    @Autowired
    AdminService adminService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public APIResponse login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                             @RequestParam(name = "adminName")String adminName,
                             @RequestParam(name = "password") String password, Model model){
        Admin login = adminService.Login(adminName, password);
        System.out.println(adminName);
        String ip= IPKit.getIpAddrByRequest(request); // 获取ip并过滤登录时缓存的bug
        System.out.println(ip);
        InetAddress addr = null;
        Map<String,Admin> map = new HashMap();
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Integer error_count = cache.hget("login_error_count",ip);//登陆错误计数
        Admin userInfo = adminService.Login(adminName, password);
        try {
            request.getSession().setAttribute(login.getAdminName(), userInfo);

        } catch (Exception e) {
            error_count = null == error_count ? 1 : error_count + 1;
            if (error_count > 3) {
                return APIResponse.fail("您输入密码已经错误超过3次，请10分钟后尝试");
            }
            cache.hset("login_error_count", ip,error_count, 10 * 60); // 加入ip的过滤
            String msg = "登录失败";
            return APIResponse.fail(msg);
        }
        map.put("admin",userInfo);
        model.addAttribute("admin","admin");
        session.setAttribute("admin",map);
        APIResponse.success(map);
        return APIResponse.success();
    }
}
