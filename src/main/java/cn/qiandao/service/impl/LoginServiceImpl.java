package cn.qiandao.service.impl;

import cn.qiandao.mapper.LoginMapper;
import cn.qiandao.pojo.User;
import cn.qiandao.service.LoginService;
import cn.qiandao.util.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper lm;
    @Autowired
    private code code;
    @Autowired
    private DateTime date;
    @Autowired
    private CreatUserName creatUserName;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private CookieUtils cookieUtils;
    @Autowired
    private EncryptionToDecrypt etd;

    @Override
    public String getPasswordByUsername(String name) {
        return lm.getPasswordByUsername(name);
    }

    //发送短信
    public String getcode(String sphone, int tcNumber) {
        String templateNumber = "";
        switch (tcNumber) {
            case 1:
                templateNumber = "SMS_181202286";
                break;
            case 2:
                templateNumber = "SMS_181202289";
                break;
            case 3:
                templateNumber = "SMS_181490498";
                break;
        }
        if (stringRedisTemplate.opsForValue().get(sphone) == null) {
            stringRedisTemplate.opsForValue().set(sphone, code.getLoginCode(), 300, TimeUnit.SECONDS);
        }

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FfrbTPfkkAtQNQWwzov", "h9rW4TuYGKbkjKlNaTt7z5MWOKYehF");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", sphone);
        request.putQueryParameter("SignName", "生钱有道");
        request.putQueryParameter("TemplateCode", templateNumber);
        request.putQueryParameter("TemplateParam", stringRedisTemplate.opsForValue().get(sphone));

        try {
            CommonResponse response = client.getCommonResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "验证码发送成功";
    }

    //比对验证码
    @Override
    public Boolean verificationCode(String phone, String vc) {
        String s = stringRedisTemplate.opsForValue().get(phone);
        if (s != null) {
            if (vc.equals(s.substring(9, 13))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    //用户注册成功进行信息存储
    @Override
    public User saveRegisterUser(String phone, String pwd) {
        if (lm.getPhone(phone) == null) {
            User u = new User();
            u.setNumber(code.getNewEquipmentNo("yh", getcount().substring(3)));
            u.setUsername(creatUserName.getNewUserName());
            u.setPwd(new Md5Hash(pwd, phone, 3).toString());
            u.setImg("1");
            u.setBgimg("1");
            u.setPhone(phone);
            u.setGrade(1);
            u.setState(1);
            u.setInvitationcode(code.getInvitationCode());
            u.setSignature("这个人太懒了，什么也没有写。。。");
            u.setRegistrationdate(date.getDate());
            BigDecimal bigDecimal = new BigDecimal(0);
            u.setCashbalance(bigDecimal);
            u.setVcbalance(bigDecimal);
            u.setExp(0);
            int count = lm.saveRegisterUser(u);
            //未更改
            int count2 = lm.saveUserRole(u.getNumber());
            if (count > 0 & count2 > 0) {
                return u;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    //比对手机号码是否已经注册
    public Boolean verifyPhoneNumber(String phone) {
        if (lm.getPhone(phone) == null) {
            return false;
        } else {
            return true;
        }
    }

    //获取用户信息
    public User getUserInfo(String phone) {
        User u = lm.getUserInfo(phone);
        u.setRole(lm.getrole(u.getNumber()));
        u.setPermissions(lm.getpermissions(u.getRole()));
        return u;
    }

    @Override
    public String getcount() {
        return lm.getNumber();
    }

    public User ptlLogin(String name, String pwd, HttpServletResponse response) {
        User u = null;
        if (name != null & pwd != null){
            String upwd = getPasswordByUsername(name);
            String s = new Md5Hash(pwd, name, 3).toString();
            System.out.println(upwd);
            System.out.println(s);
            if (upwd != null & upwd.equals(s)){
                u = getUserInfo(name);
                cookieUtils.writeCookie(response,"sqyd", etd.AESEncode("123", name));
            }
        }
        return u;
    }

    //尝试cookie登录
    public User validationCookie(HttpServletRequest request, HttpServletResponse response) {
        String cookiephone = cookieUtils.getCookie(request, "sqyd");
        String phone = etd.AESDncode("123", cookiephone);
        if (lm.getPhone(phone) != null) {
            return lm.getUserInfo(phone);
        } else {
            return null;
        }
    }

    public String changePwd(String phone,String pwd){
        pwd = new Md5Hash(pwd,phone,3).toString();
        int count = lm.changPwd(phone, pwd);
        if (count > 0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
}
