package cn.qiandao.service.impl;

import cn.qiandao.mapper.CashrecordsMapper;
import cn.qiandao.pojo.Cashrecords;
import cn.qiandao.service.CashrecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxy
 * @date 2020/1/4 0004 17:20
 **/
@Service
public class CashrecordsServiceImpl implements CashrecordsService {
    @Autowired
    private CashrecordsMapper cashrecordsMapper;
    @Override
    public List<Cashrecords> getCashreByCuId(String cuid) {
        Cashrecords cashrecords = new Cashrecords();
        cashrecords.setCrGatheringusernumber(cuid);
        return cashrecordsMapper.select(cashrecords);
    }

    @Override
    public int addCashrecords(Cashrecords cashrecords) {
        return cashrecordsMapper.insert(cashrecords);
    }

    @Override
    public int delCashrecords(String vid) {
        Cashrecords cashrecords = new Cashrecords();
        cashrecords.setCrNumber(vid);
        return cashrecordsMapper.delete(cashrecords);
    }

    @Override
    public int updateCashrecords(Cashrecords cashrecords) {
        return cashrecordsMapper.updateByPrimaryKeySelective(cashrecords);
    }
}
