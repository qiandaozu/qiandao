package cn.qiandao.controller;

import cn.qiandao.pojo.User;
import cn.qiandao.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImpl lsi;

    //cookie登录
    @CrossOrigin
    @RequestMapping("/cv")
    public User cvLogin(HttpServletRequest request, HttpServletResponse response){
        return lsi.validationCookie(request,response);
    }

    //密码登录
    @CrossOrigin
    @RequestMapping("/ptl/{name}/{pwd}")
    public User paaswordToLogin(@PathVariable("name")String name, @PathVariable("pwd")String pwd,HttpServletResponse response){
        return lsi.ptlLogin(name,pwd,response);
    }

    //验证码登录
    @CrossOrigin
    @RequestMapping("/vcl/{phone}/{vc}")
    public User verificationCodeLogin(@PathVariable("phone") String phone,@PathVariable("vc") String vc){
        User u = new User();
        if(lsi.verifyPhoneNumber(phone)) {
            if(lsi.verificationCode(phone, vc)){
                u = lsi.getUserInfo(phone);
            }
        }
        return u;
    }

    //忘记密码的验证码
    @CrossOrigin
    @RequestMapping("/ftpvc/{phone}/{fvc}")
    public Boolean forgetThePassword(@PathVariable("phone") String sphone,@PathVariable("fvc") String fvc){
        return lsi.verificationCode(sphone,fvc);
    }

    //获取验证码
    @CrossOrigin
    @RequestMapping("/gc/{phone}/{number}")
    public String getCode(@PathVariable("phone") String phone,@PathVariable("number") String number){
        String getcode = lsi.getcode(phone,Integer.valueOf(number));
        return getcode;
    }

    //注册
    @CrossOrigin
    @RequestMapping("/vcr/{phone}/{vc}/{rpwd}")
    public User verificationCodeRegister(@PathVariable("phone") String phone,@PathVariable("vc") String vc,@PathVariable("rpwd") String rpwd){
        Boolean b = lsi.verificationCode(phone, vc);
        if(b == null){
            b = false;
        }
        if(b){
            User u = lsi.saveRegisterUser(phone, rpwd);
            return u;
        }else {
            return null;
        }

    }

    @CrossOrigin
    @RequestMapping("/cp/{phone}/{pwd}")
    public String changePwd(@PathVariable("phone") String phone,@PathVariable("pwd") String pwd){
        return lsi.changePwd(phone,pwd);
    }

}
