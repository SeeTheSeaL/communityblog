package com.communityblog.service;

import com.communityblog.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author lee
 * @date 2021/1/12 - 9:16 下午
 */
public interface AdminService {
     Admin Login(String adminName,String password);
}
