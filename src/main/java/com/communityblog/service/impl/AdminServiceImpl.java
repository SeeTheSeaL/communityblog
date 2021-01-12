package com.communityblog.service.impl;

import com.communityblog.mapper.AdminMapper;
import com.communityblog.pojo.Admin;
import com.communityblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author lee
 * @date 2021/1/12 - 9:17 下午
 */
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin Login(String adminName,String password) {
        return adminMapper.getUserInfoByCond(adminName,password);
    }
}
