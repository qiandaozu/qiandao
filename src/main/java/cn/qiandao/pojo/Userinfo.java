package cn.qiandao.pojo;

import java.io.Serializable;
import java.util.Date;

public class Userinfo implements Serializable {
    /**
    * id
    */
    private Integer uiId;

    /**
    * 用户编号
    */
    private String uiNumber;

    /**
    * 用户权限（填写序号）
    */
    private Integer uiJurisdiction;

    /**
    * 用户昵称
    */
    private String uiName;

    /**
    * 用户密码
    */
    private String uiPwd;

    /**
    * 用户头像
    */
    private String uiImg;

    /**
    * 用户背景图
    */
    private String uiBgimg;

    /**
    * 用户手机号
    */
    private String uiPhone;

    /**
    * 用户等级（填写序号）
    */
    private Integer uiGrade;

    /**
    * 用户在线状态（填写序号）
    */
    private Integer uiState;

    /**
    * 用户邀请码
    */
    private String uiCode;

    /**
    * 个性签名
    */
    private String uiSignature;

    /**
    * 注册时间
    */
    private Date uiRegistrationdate;

    /**
    * 用户现金余额
    */
    private Long uiCashbalance;

    /**
    * 用户金币余额
    */
    private Long uiVirtualcurrencybalance;

    private static final long serialVersionUID = 1L;

    public Integer getUiId() {
        return uiId;
    }

    public void setUiId(Integer uiId) {
        this.uiId = uiId;
    }

    public String getUiNumber() {
        return uiNumber;
    }

    public void setUiNumber(String uiNumber) {
        this.uiNumber = uiNumber;
    }

    public Integer getUiJurisdiction() {
        return uiJurisdiction;
    }

    public void setUiJurisdiction(Integer uiJurisdiction) {
        this.uiJurisdiction = uiJurisdiction;
    }

    public String getUiName() {
        return uiName;
    }

    public void setUiName(String uiName) {
        this.uiName = uiName;
    }

    public String getUiPwd() {
        return uiPwd;
    }

    public void setUiPwd(String uiPwd) {
        this.uiPwd = uiPwd;
    }

    public String getUiImg() {
        return uiImg;
    }

    public void setUiImg(String uiImg) {
        this.uiImg = uiImg;
    }

    public String getUiBgimg() {
        return uiBgimg;
    }

    public void setUiBgimg(String uiBgimg) {
        this.uiBgimg = uiBgimg;
    }

    public String getUiPhone() {
        return uiPhone;
    }

    public void setUiPhone(String uiPhone) {
        this.uiPhone = uiPhone;
    }

    public Integer getUiGrade() {
        return uiGrade;
    }

    public void setUiGrade(Integer uiGrade) {
        this.uiGrade = uiGrade;
    }

    public Integer getUiState() {
        return uiState;
    }

    public void setUiState(Integer uiState) {
        this.uiState = uiState;
    }

    public String getUiCode() {
        return uiCode;
    }

    public void setUiCode(String uiCode) {
        this.uiCode = uiCode;
    }

    public String getUiSignature() {
        return uiSignature;
    }

    public void setUiSignature(String uiSignature) {
        this.uiSignature = uiSignature;
    }

    public Date getUiRegistrationdate() {
        return uiRegistrationdate;
    }

    public void setUiRegistrationdate(Date uiRegistrationdate) {
        this.uiRegistrationdate = uiRegistrationdate;
    }

    public Long getUiCashbalance() {
        return uiCashbalance;
    }

    public void setUiCashbalance(Long uiCashbalance) {
        this.uiCashbalance = uiCashbalance;
    }

    public Long getUiVirtualcurrencybalance() {
        return uiVirtualcurrencybalance;
    }

    public void setUiVirtualcurrencybalance(Long uiVirtualcurrencybalance) {
        this.uiVirtualcurrencybalance = uiVirtualcurrencybalance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uiId=").append(uiId);
        sb.append(", uiNumber=").append(uiNumber);
        sb.append(", uiJurisdiction=").append(uiJurisdiction);
        sb.append(", uiName=").append(uiName);
        sb.append(", uiPwd=").append(uiPwd);
        sb.append(", uiImg=").append(uiImg);
        sb.append(", uiBgimg=").append(uiBgimg);
        sb.append(", uiPhone=").append(uiPhone);
        sb.append(", uiGrade=").append(uiGrade);
        sb.append(", uiState=").append(uiState);
        sb.append(", uiCode=").append(uiCode);
        sb.append(", uiSignature=").append(uiSignature);
        sb.append(", uiRegistrationdate=").append(uiRegistrationdate);
        sb.append(", uiCashbalance=").append(uiCashbalance);
        sb.append(", uiVirtualcurrencybalance=").append(uiVirtualcurrencybalance);
        sb.append("]");
        return sb.toString();
    }
}