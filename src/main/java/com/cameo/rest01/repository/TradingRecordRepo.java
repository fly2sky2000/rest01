package com.cameo.rest01.repository;

import com.cameo.rest01.entity.TradingRecord;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "tradingRecord", path = "tradingRecord")
@Api(tags="交易记录服务")
public interface TradingRecordRepo extends JpaRepository<TradingRecord, String>, JpaSpecificationExecutor {
    @RestResource(path = "createdBy", rel = "createdBy")
    List<TradingRecord> findByCreatedBy(@Param("createdBy") String createdBy);

    @RestResource(path = "findAllOrdered")
    @Query("select t from TradingRecord t order by t.bookedDate desc, t.createdTime desc ")
    List<TradingRecord> findAllOrdered();

}
