package cn.qiandao.utils;

import cn.qiandao.Enum.StatusCode;
import lombok.Data;

/**
 * 这个类定义了返回的json格式，即json含有哪些字段
 *
 * @author lxy
 * @date 2020/1/5 0005 15:32
 **/
@Data
public class JsonResult {
    private Integer code;
    private String message;
    private Object data;

    public JsonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(StatusCode statusCode){
        this.code=statusCode.getCode();
        this.message=statusCode.getMessage();
    }
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
