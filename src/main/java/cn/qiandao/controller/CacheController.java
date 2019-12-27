package cn.qiandao.controller;

import cn.qiandao.pojo.User;
import org.springframework.cache.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fyy
 * @date 2019/12/27 16:30
 **/
@RestController
@CacheConfig(cacheNames={"User"})
public class CacheController {

    // http://localhost:8080/redis/findUserById/1
    // @CacheConfig(cacheNames = {"User"}) + @Cacheable(key = "#id") // User OK
    // @Cacheable(cacheNames = "User") // User Config is OK
    // @Cacheable(cacheNames = "User", key = "#id") // User Config is OK
    // @Cacheable(value = "User", key = "#id") // User Config is OK
    // @Cacheable(cacheNames = "User1",value = "User", key = "#id") // 异常无法重启
    // @Cacheable(cacheNames = "User", value = "User1", key = "#id") // 异常无法重启

    @Cacheable
    @GetMapping("/redis/findUserById/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("杨杨老师" + id + " 查询时间戳 " +
                System.currentTimeMillis());
        System.out.println("数据库查询用户 id = " + id + " ,name = " +
                user.getName());
        return user;
    }

    // http://localhost:8080/redis/updateUserById/1
    @CachePut(cacheNames = "User", key = "#id")
    @GetMapping("/redis/updateUserById/{id}")
    public User updateUserById(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("杨杨老师" + id + " 修改时间戳 " +
                System.currentTimeMillis());
        System.out.println("数据库更新用户 id = " + id + " ,name = " +
                user.getName());
        return user;
    }

    // http://localhost:8080/redis/deleteUserById/1
    //@CacheEvict(value="user",key="#id")
    //@CacheEvict(value="user",allEntries = true) //清除所有缓存
    @CacheEvict(value = "User", allEntries = true, beforeInvocation = true)
    @GetMapping("/redis/deleteUserById/{id}")
    public User deleteUserById(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("杨杨老师" + id + " 删除时间戳 " +
                System.currentTimeMillis());
        System.out.println("数据库删除用户 id = " + id + " ,name = " +
                user.getName());
        return user;
    }

    // http://localhost:8080/redis/updateUserByName/杨杨老师
    @Caching(
            cacheable = {@Cacheable(value = "User1", key = "#name")},
            put = {
                    @CachePut(value = "User2", key = "#result.id"),
                    @CachePut(value = "User3", key = "#result.name")
            }
    )
    @GetMapping("/redis/updateUserByName/{name}")
    public User updateUserByName(@PathVariable("name") String name) {
        User user = new User();
        user.setId(100);
        user.setName("杨杨老师" + 100 + " 更新名称 " + name);
        System.out.println("数据库更新用户 id = " + 100 + " ,name = " +
                user.getName());
        return user;
    }
}
