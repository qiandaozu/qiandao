package cn.qiandao.service.impl;

import cn.qiandao.mapper.SkillcommentMapper;
import cn.qiandao.pojo.Skillcomment;
import cn.qiandao.service.SkillcommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxy
 * @date 2020/1/5 0005 17:09
 **/
@Service
public class SkillcommentServiceImpl implements SkillcommentService {

    @Autowired
    private SkillcommentMapper skillcommentMapper;
    @Override
    public List<Skillcomment> selSkillcomment(String sknumber) {
        Skillcomment skillcomment = new Skillcomment();
        skillcomment.setScSkillnumber(sknumber);
        return skillcommentMapper.select(skillcomment);
    }
}
