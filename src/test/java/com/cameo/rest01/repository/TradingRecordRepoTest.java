package com.cameo.rest01.repository;

import com.cameo.rest01.entity.TradingRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TradingRecordRepoTest {
    @Autowired
    private TradingRecordRepo dao;

    private TradingRecord entity;

    @Test
    public void testCreate() {
        entity = (TradingRecord) new TradingRecord()
                .setCoinCode(TradingRecord.CoinCode.BTC).setQuantity(1.0)
                .setTradingType(TradingRecord.TradingType.BUY)
                .setPriceType(TradingRecord.PriceType.UNIT)
                .setMoney(35000.0).setUnit(TradingRecord.UnitType.CNY)
                .setBookedDate(new Date()).setRemark("测试数据")
                .setCreatedBy("felix").setUpdatedBy("felix");
        entity = dao.save(entity);
    }

    //@Test
    public void testUpdate() {
        //entity = dao.findById(entity.getId());
        entity = dao.save(entity);
    }
}
