package cn.qiandao.controller;

import cn.qiandao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis 测试类
 * @author fyy
 * @date 2019/12/27 11:20
 **/
@RestController
public class testRedisController {
    //key-value 字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //key-value 都是对象
    @Autowired
    RedisTemplate redisTemplate;

    //http://localhost:8080/redis/user

    @GetMapping("/redis/user")
    public User user(){
        User user = new User();
        user.setId(1);
        user.setName("杨杨");
        redisTemplate.opsForValue().set("2",user);
        System.out.println("查询数据库");
        //注意强制类型转换
        return (User) redisTemplate.opsForValue().get("2");
    }

    /*@GetMapping("/redis/user")
    public String user(){
        User user = new User();
        user.setId(1);
        user.setName("杨杨");
        stringRedisTemplate.opsForValue().set("1","杨杨");
        //System.out.println("查询数据库");
        return stringRedisTemplate.opsForValue().get("1");
    }*/

    //String 类型
    @GetMapping(value = "/redis")
    public String redis(){
        String key = "redis-string-key";
        String value = String.valueOf(System.currentTimeMillis() + 1);
        stringRedisTemplate.opsForValue().set(key,value);
        return stringRedisTemplate.opsForValue().get(key);
    }

    //http://localhost:8080/redisList
    @GetMapping("/redisList")
    // 数组或者链表 redis 将只有2个元素
    public String redisList(){
        String key = "redis-list-key";
        String value = String.valueOf(System.currentTimeMillis() + 1);
        stringRedisTemplate.opsForList().leftPush(key,value);
        stringRedisTemplate.opsForList().leftPush(key,value);
        stringRedisTemplate.opsForList().leftPush(key,value);
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    //http://localhost:8080/redisSet
    @GetMapping("/redisSet")
    // HashSet   元素不能重复
    public String redisSet(){
        String key = "redis-set-key";
        String value = String.valueOf(System.currentTimeMillis() + 1);
        stringRedisTemplate.opsForSet().add(key,value);
        stringRedisTemplate.opsForSet().add(key,value + "-1");
        stringRedisTemplate.opsForSet().add(key,value + "-2");
        return stringRedisTemplate.opsForSet().pop(key);
    }

    //http://localhost:8080/redisHash
    @GetMapping("/redisHash")
    public String redisHash(){
        String key = "redis-hash-key";
        String hashKey = String.valueOf(System.currentTimeMillis());
        String value = String.valueOf(System.currentTimeMillis() + 1);
        stringRedisTemplate.opsForHash().put(key,hashKey,value);
//        stringRedisTemplate.opsForHash().put(key,hashKey + "-1",value + "-1");
//        stringRedisTemplate.opsForHash().put(key,hashKey + "-2",value + "-2");
        return String.valueOf(stringRedisTemplate.opsForHash().get(key,hashKey));
    }

    //http://localhost:8080/redisZSet
    @GetMapping("/redisZSet")
    public String redisZSet(){
        String key = "redis-zset-key";
        String hashkey = String.valueOf(System.currentTimeMillis());
        stringRedisTemplate.opsForZSet().add(key,hashkey,System.currentTimeMillis());
        return String.valueOf(stringRedisTemplate.opsForZSet().zCard(key));
    }
}
