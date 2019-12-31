package cn.qiandao.service;

import cn.qiandao.pojo.User;

public interface LoginService {
    String getPasswordByUsername(String name);
    String getcode(String phone,int tcNumber);
    Boolean verificationCode(String sphone,String vc);
    User saveRegisterUser(String sphone, String pwd);
    Boolean verifyPhoneNumber(String sphone);
    User getUserInfo(String phone);
}
