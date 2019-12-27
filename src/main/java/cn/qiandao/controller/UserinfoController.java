package cn.qiandao.controller;

import cn.qiandao.pojo.Userinfo;
import cn.qiandao.service.UserinfoService;
import cn.qiandao.service.impl.UserinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fyy
 * @date 2019/12/27 10:49
 **/
@RestController
public class UserinfoController {

    @Autowired
    private UserinfoServiceImpl userinfoService;

    @RequestMapping("/getuser")
    public List<Userinfo> selectById(Integer uiId){
        return userinfoService.selectById(uiId);
    }
}
