package cn.qiandao.service;

import cn.qiandao.pojo.Userinfo;

import java.util.List;

/**
 * @author fyy
 * @date 2019/12/27 10:46
 **/
public interface UserinfoService {
    List<Userinfo> selectById(Integer uiId);
}
