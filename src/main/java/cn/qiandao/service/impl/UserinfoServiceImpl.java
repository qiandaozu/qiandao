package cn.qiandao.service.impl;

import cn.qiandao.mapper.UserinfoMapper;
import cn.qiandao.pojo.Userinfo;
import cn.qiandao.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fyy
 * @date 2019/12/27 10:48
 **/
@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public List<Userinfo> selectById(Integer uiId) {
        return userinfoMapper.selectByUiId(uiId);
    }
}
