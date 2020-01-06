package cn.qiandao.service;

import cn.qiandao.pojo.Cashrecords;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author lxy
 * @date 2020/1/4 0004 17:19
 **/
public interface CashrecordsService {
    List<Cashrecords> getCashreByCuId(String cuid);
    int addCashrecords(Cashrecords cashrecords);
    int delCashrecords(String vid);
    int updateCashrecords(Cashrecords cashrecords);
}
