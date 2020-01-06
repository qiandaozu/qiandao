package cn.qiandao.service.impl;

import cn.qiandao.mapper.VirtualMapper;
import cn.qiandao.pojo.Virtualcurrencyrecords;
import cn.qiandao.service.VirtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxy
 * @date 2020/1/4 0004 18:46
 **/
@Service
public class VirtualServiceImpl implements VirtualService {

    @Autowired
    private VirtualMapper virtualMapper;

    @Override
    public List<Virtualcurrencyrecords> getListVirtual(String vuid) {
        Virtualcurrencyrecords vcc = new Virtualcurrencyrecords();
        vcc.setVcrUserserialnumber(vuid);
        return virtualMapper.select(vcc);
    }

    @Override
    public int addVirtualcords(Virtualcurrencyrecords v) {
        return virtualMapper.insert(v);
    }

    @Override
    public int delVirtualcords(String vid) {
        Virtualcurrencyrecords vcc = new Virtualcurrencyrecords();
        vcc.setVcrNumber(vid);
        return virtualMapper.delete(vcc);
    }

    @Override
    public int updateVirtualcords(Virtualcurrencyrecords v) {
        return virtualMapper.updateByPrimaryKeySelective(v);
    }
}
