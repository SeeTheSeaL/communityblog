package com.communityblog;

import com.communityblog.mapper.AdminMapper;
import com.communityblog.pojo.Admin;
import com.communityblog.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CommunityblogApplicationTests {
    @Autowired
    private AdminMapper adminMapper;
    @Test
    void contextLoads() {
        Admin admin = adminMapper.getUserInfoByCond("admin", "12345");



    }
    @Test
    public void test02(){
        new Thread(()->{
            for(int i =0;i<=1000;i++){
                System.out.println(11);
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("12313");
                }
            }
        },"dddd").start();
        Thread dddd = getThreadByName("dddd");
        dddd.stop();
    }
    public static Thread getThreadByName(String threadName) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals(threadName)) {
                System.out.println(t.getName());
                return t;
            }
        }
        return null;
    }

}
