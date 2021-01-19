package com.communityblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lee
 * @date 2021/1/19 - 9:53 下午
 */

@Controller
@RequestMapping("/index")
public class AdminIndexController {
    @GetMapping("/member-list")
    public String toMemberList(Model model){

        return "member-list";
    }

    @GetMapping("/member-list1")
    public String toMemberList1(Model model){

        return "member-list1";
    }

    @GetMapping("/admin-list")
    public String toAdminList(Model model){

        return "admin-list";
    }
    @GetMapping("/admin-rule")
    public String toAdminRule(Model model){

        return "admin-rule";
    }
    @GetMapping("/order-list")
    public String toOrderList(Model model){

        return "order-list";
    }
}

