package cn.qiandao.service;

import cn.qiandao.pojo.Virtualcurrencyrecords;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author lxy
 * @date 2020/1/4 0004 18:46
 **/
public interface VirtualService {
    List<Virtualcurrencyrecords> getListVirtual(String vuid);
    int addVirtualcords(Virtualcurrencyrecords v);
    int delVirtualcords(String vid);
    int updateVirtualcords(Virtualcurrencyrecords v);
}
