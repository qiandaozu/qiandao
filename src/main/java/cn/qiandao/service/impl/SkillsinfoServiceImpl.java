package cn.qiandao.service.impl;

import cn.qiandao.mapper.SkillRelationMapper;
import cn.qiandao.mapper.SkillsinfoMapper;
import cn.qiandao.pojo.Skillsinfo;
import cn.qiandao.pojo.Skilltype;
import cn.qiandao.pojo.Skilluserrelationship;
import cn.qiandao.service.SkillsinfoService;
import cn.qiandao.service.SkilltypeService;
import cn.qiandao.service.UserService;
import net.sf.saxon.om.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxy
 * @date 2020/1/3 0003 23:09
 **/
@Service
public class SkillsinfoServiceImpl implements SkillsinfoService {
    @Autowired
    private SkillsinfoMapper skillsinfoMapper;
    @Autowired
    private SkilltypeService skilltypeService;
    @Autowired
    private SkillRelationMapper skillRelationMapper;
    @Autowired
    private UserService userService;
    @Override
    public Skillsinfo selectBySiSerialnumber(String siSerialnumber){
        Skillsinfo skillsinfo = new Skillsinfo();
        skillsinfo.setSiSerialnumber(siSerialnumber);
        skillsinfo = skillsinfoMapper.selectOne(skillsinfo);
        skillsinfo.setSiType(getSiiType(skillsinfo.getSiType()));
        String[] imgList = skillsinfo.getSiImg().split(",");
        skillsinfo.setSiImgages(imgList);
        skillsinfo.setSiImg(imgList[0]);
        return skillsinfo;
    }

    @Override
    public List<Skillsinfo> selectAll() {
        List<Skillsinfo> skillsinfos = skillsinfoMapper.selectAll();
        for (Skillsinfo si : skillsinfos) {
            Skilluserrelationship user = getUser(si.getSiSerialnumber());
            si.setU(userService.findById(user.getSurUsernumber()));
        }
        return skillsinfos;
    }

    @Override
    public String getSiiType(String skillId){
        Skilltype skilltype1 = skilltypeService.selByStNumber(skillId);
        Skilltype skilltype2 = skilltypeService.selByStNumber(skilltype1.getStFamilynumber());
        String type = skilltype2.getStContent() + "-" + skilltype1.getStContent();
        return type;
    }

    @Override
    public int addSkills(Skillsinfo skillsinfo) {
        return skillsinfoMapper.insert(skillsinfo);
    }

    @Override
    public Skilluserrelationship getUser(String skillId) {
        Skilluserrelationship sur = new Skilluserrelationship();
        sur.setSurSkillnumber(skillId);
        return skillRelationMapper.selectOne(sur);
    }

}
