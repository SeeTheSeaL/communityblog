package com.communityblog.mapper;

import com.communityblog.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    /**
     * 根据用户名和密码获取用户信息
     * @param adminName
     * @param password
     * @return
     */
    Admin getUserInfoByCond(@Param("adminName") String adminName, @Param("password") String password);
}
