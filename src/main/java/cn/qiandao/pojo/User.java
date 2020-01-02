package cn.qiandao.pojo;

import cn.qiandao.util.code;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author fyy
 * @date 2019/12/25 15:29
 **/
@Entity
@Table(name = "userinfo")
@Data
public class User{

    //用户编号
    @Column(name = "ui_number")
    private String number;

    //角色权限，数据库为int
    @Column(name = "ui_jurisdiction")
    private Integer jurisdiction;

    //用户名
    @Column(name = "ui_name")
    private String username;

    //密码
    @Column(name = "ui_pwd")
    private String pwd;

    //头像图片
    @Column(name = "ui_img")
    private String img;

    //背景图片
    @Column(name = "ui_bgimg")
    private String bgimg;

    //手机号码
    @Column(name = "ui_phone")
    private String phone;

    //等级，数据库为int
    @Column(name = "ui_grade")
    private Integer grade;

    //在线状态，数据库为int
    @Column(name = "ui_state")
    private Integer state;

    //邀请码
    @Column(name = "ui_code")
    private String invitationcode;

    //个性签名
    @Column(name = "ui_signature")
    private String signature;

    //注册时间，数据库为date
    @Column(name = "ui_registrationdate")
    private Date registrationdate;

    //现金余额，数据库为decimal
    @Column(name = "ui_cashbalance")
    private BigDecimal cashbalance;

    //虚拟币余额，数据库为decimal
    @Column(name = "ui_virtualcurrencybalance")
    private BigDecimal vcbalance;

    //经验值
    @Column(name = "")
    private int exp;

    //名字
    @Column(name = "ubi_name")
    private String name;

    //姓氏
    @Column(name = "ubi_familyname")
    private String familyname;

    //语言，数据库为int
    @Column(name = "ubi_language")
    private Integer language;

    //性别，数据库为int
    @Column(name = "ubi_gender")
    private Integer gender;

    //出生日期，数据库为date
    @Column(name = "ubi_birth")
    private Date birth;

    //地区，数据库为int，连表
    @Column(name = "ubi_area")
    private Integer area;

    //证件类型，数据库为int
    @Column(name = "ubi_documenttype")
    private Integer documenttype;

    //证件号码，数据库为bigint
    @Column(name = "ubi_documentnumber")
    private Long documentnumber;

    //学历，数据库为int
    @Column(name = "ubi_educationbackground")
    private Integer educationbackground;

    //教育经历
    @Column(name = "ubi_educationexperience")
    private String educationexperience;

    //行业，数据库为int，连表
    @Column(name = "ubi_industry")
    private Integer industry;

    //从业经历
    @Column(name = "ubi_workingexperience")
    private String workingexperience;

    //收入范围，数据库为int
    @Column(name = "ubi_incomerange")
    private Integer incomerange;

    //电子邮件
    @Column(name = "ubi_email")
    private String email;

    //微信
    @Column(name = "ubi_wechat")
    private String wechat;
}
