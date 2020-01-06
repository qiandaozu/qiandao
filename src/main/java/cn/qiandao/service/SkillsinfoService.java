package cn.qiandao.service;

import cn.qiandao.pojo.Skillsinfo;
import cn.qiandao.pojo.Skilluserrelationship;

import java.util.List;

public interface SkillsinfoService {
    Skillsinfo selectBySiSerialnumber(String siSerialnumber);
    List<Skillsinfo> selectAll();
    String getSiiType(String skillId);
    int addSkills(Skillsinfo skillsinfo);
    Skilluserrelationship getUser(String skillId);
}
