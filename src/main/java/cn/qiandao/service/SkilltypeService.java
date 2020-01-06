package cn.qiandao.service;

import cn.qiandao.pojo.Skilltype;

import java.util.List;

public interface SkilltypeService {
    Skilltype selByStNumber(String stNumber);
    List<Skilltype> getByFamilyAll(String siFamilyId);
    //List<Skilltype> getBySonAll(String siFamilyId);
}
