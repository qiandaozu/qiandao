package cn.qiandao.mapper;

import cn.qiandao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    String getPasswordByUsername(@Param("name")String name);
    String getPhone(@Param("phone")String phone);
    int saveRegisterUser(@Param("user")User user);
    int saveRegisterUserbasic(@Param("user")User user);
    User getUserInfo(@Param("getPhone")String getPhone);
}
