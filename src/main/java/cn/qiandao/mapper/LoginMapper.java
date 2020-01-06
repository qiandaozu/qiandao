package cn.qiandao.mapper;

import cn.qiandao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface LoginMapper {
    String getPasswordByUsername(@Param("name")String name);
    String getPhone(@Param("phone")String phone);
    int saveRegisterUser(@Param("user")User user);
    int saveRegisterUserbasic(@Param("user")User user);
    User getUserInfo(@Param("getPhone")String getPhone);
    String getNumber();
    int saveUserRole(@Param("userNumber")String userNumber);
    String getrole(@Param("number")String number);
    ArrayList<String> getpermissions(@Param("role")String role);
    int changPwd(@Param("phone")String phone,@Param("pwd")String pwd);
}
