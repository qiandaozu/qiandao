package cn.qiandao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("cn.qiandao")
@ComponentScan({"cn.qiandao.controller","cn.qiandao.mapper","cn.qiandao.service","cn.qiandao.util"})
public class ShengqianyoudaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShengqianyoudaoApplication.class, args);
    }

}
