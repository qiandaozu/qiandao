package cn.qiandao.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class test {
    @ApiOperation(value = "testdomo")
    @ApiImplicitParam(name = "userid", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{userid}", method = RequestMethod.POST)
    public int test(@PathVariable(value = "userid")Integer userid){
        System.out.println(userid);
        return 1;
    }
}
