package cn.qiandao.mapper;

import cn.qiandao.pojo.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author fyy
 * @date 2019/12/25 15:57
 **/
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    User findById(String id);

    User save(User user);

    List<User> findAll();
}
