package cn.qiandao.service.impl;

import cn.qiandao.mapper.UserMapper;
import cn.qiandao.pojo.User;
import cn.qiandao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fyy
 * @date 2019/12/25 16:03
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User save(User user) {
        return userMapper.save(user);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    public void delete(User user) {
        userMapper.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
