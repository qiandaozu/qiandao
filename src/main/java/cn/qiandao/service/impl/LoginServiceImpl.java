package cn.qiandao.service.impl;

import cn.qiandao.mapper.LoginMapper;
import cn.qiandao.pojo.User;
import cn.qiandao.service.LoginService;
import cn.qiandao.util.CreatUserName;
import cn.qiandao.util.DateTime;
import cn.qiandao.util.IdWorker;
import cn.qiandao.util.code;
import net.sf.saxon.functions.Substring;
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
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String getPasswordByUsername(String name) {
        return lm.getPasswordByUsername(name);
    }

    //发送短信
    public String getcode(String sphone,int tcNumber) {
        String templateNumber = "";
        switch (tcNumber){
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
        if (stringRedisTemplate.opsForValue().get(sphone) == null){
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
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "验证码发送成功";
    }

    //比对验证码
    @Override
    public Boolean verificationCode(String phone,String vc){
        String s = stringRedisTemplate.opsForValue().get(phone);
        if (s != null) {
            if (vc.equals(s.substring(9, 13))){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }

    //用户注册成功进行信息存储
    @Override
    public User saveRegisterUser(String phone,String pwd){
        if(lm.getPhone(phone) == null){
            User u = new User();
            u.setNumber(code.getNewEquipmentNo("yh",""));
            u.setJurisdiction(1);
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
            if (count > 0){
                return u;
            }else {
                return null;
            }
        }else{
            return null;
        }
    }


    //比对手机号码是否已经注册
    public Boolean verifyPhoneNumber(String phone){
        if(lm.getPhone(phone) == null){
            return false;
        }else {
            return true;
        }
    }

    public User getUserInfo(String phone){
        User u = lm.getUserInfo(phone);
        return u;
    }

    @Override
    public int getcount() {
        //return lm.getcount();
        return 1;
    }
}
