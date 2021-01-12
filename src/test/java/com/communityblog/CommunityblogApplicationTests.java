package com.communityblog;

import com.communityblog.mapper.AdminMapper;
import com.communityblog.pojo.Admin;
import com.communityblog.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityblogApplicationTests {
    @Autowired
    private AdminMapper adminMapper;
    @Test
    void contextLoads() {
        Admin admin = adminMapper.getUserInfoByCond("admin", "12345");
        System.out.println(admin.getAdminName());
        System.out.println(admin.getId());
        System.out.println(admin.getPassword());
        System.out.println("2131");
    }

}
