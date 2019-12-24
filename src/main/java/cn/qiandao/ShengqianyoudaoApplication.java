package cn.qiandao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("cn.qiandao")
@SpringBootApplication
@EnableSwagger2
public class ShengqianyoudaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShengqianyoudaoApplication.class, args);
    }

}
