package cn.qiandao.pojo;

import java.io.Serializable;

/**
 * @author fyy
 * @date 2019/12/27 11:21
 **/
public class User implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
