package com.cameo.rest01.repository;

import com.cameo.rest01.entity.TradingRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TradingRecordDaoTest {
    @Autowired
    private TradingRecordDao dao;

    private TradingRecord entity;
    @Test
    public void testCreate() {
        entity = new TradingRecord(null, "BTC", 1.0, "1", 35000.0, "CNY", "2", new Date(), "", 1, "Felix", null, "felix", null);
        entity = dao.save(entity);
    }

    //@Test
    public void testUpdate() {
        //entity = dao.findById(entity.getId());
        entity = dao.save(entity);
    }
}
