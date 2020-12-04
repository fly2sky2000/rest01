package com.cameo.rest01.repository;

import com.cameo.rest01.entity.TradingRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TradingRecordRepoTest {
    @Autowired
    private TradingRecordRepo dao;

    private TradingRecord entity;

    @Test
    public void testCreate() {
        entity = TradingRecord.builder()
                .coinCode("CNY").quantity(1.0).tradingType("1")
                .money(35000.0).unit("1").bookedDate(new Date()).remark("测试数据")
                .createdBy("felix").updatedBy("felix")
                .build();
        entity = dao.save(entity);
    }

    //@Test
    public void testUpdate() {
        //entity = dao.findById(entity.getId());
        entity = dao.save(entity);
    }
}
