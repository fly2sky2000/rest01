package com.cameo.rest01.repository;

import com.cameo.rest01.entity.TradingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "trading-record", path = "trading-record")
public interface TradingRecordDao extends JpaRepository<TradingRecord, String>, JpaSpecificationExecutor {
    List<TradingRecord> findByCoinCode(@Param("coinCode") String coinCode);
}
