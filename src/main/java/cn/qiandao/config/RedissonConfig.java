package cn.qiandao.config;/**
 * Created by Administrator on 2019/7/2.
 */

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * redisson通用化配置
 * @Author: fyy
 * @Date: 2019/12/25 18:26
 **/
@Configuration
public class RedissonConfig {

    @Autowired
    private Environment env;

    @Bean
    public RedissonClient redissonClient(){
        Config config=new Config();
        config.useSingleServer()
                .setAddress("redis://" + env.getProperty("spring.redis.host" + ":" + env.getProperty("spring.redis.port")))
                .setPassword(env.getProperty("spring.redis.password"));
        RedissonClient client=Redisson.create(config);
        return client;
    }


}