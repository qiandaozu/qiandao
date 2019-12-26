package cn.qiandao.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author fyy
 * @date 2019/12/25 15:29
 **/
@Entity
@Table(name = "userinfo")
@Data
public class User{
    @Column(name = "userid")
    private Integer userid;

    @Column(name = "username")
    private String username;

    @Column(name = "userpwd")
    private String userpwd;

    @Column(name = "useraddress")
    private Integer useraddress;
}
