package cn.qiandao.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @author fyy
 * @date 2019/12/25 15:53
 **/
@MappedSuperclass
public class BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;

    @Column(name= "create_date") //创建时间
    Date createDate = new Date();

    @Column(name= "update_date")//修改时间
    Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
