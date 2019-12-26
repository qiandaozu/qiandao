package cn.qiandao.service;


import cn.qiandao.pojo.User;

import java.util.List;

public interface UserService {
    public User save(User user);
    public User findById(String id);
    public void delete(User user);
    public List<User> findAll();
}
