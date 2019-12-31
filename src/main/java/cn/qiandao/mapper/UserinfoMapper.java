package cn.qiandao.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import cn.qiandao.pojo.Userinfo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserinfoMapper {
    List<Userinfo> selectByUiId(@Param("uiId")Integer uiId);


}