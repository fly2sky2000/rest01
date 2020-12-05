package com.cameo.rest01.bca.util;

import com.cameo.rest01.entity.TradingRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

/**
 * 解决ID不能暴露的问题
 */
@Component
public class RestConfiguration implements RepositoryRestConfigurer {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer()
    {
        return RepositoryRestConfigurer.withConfig(config -> {
            config.exposeIdsFor(TradingRecord.class);
            //config.getCorsRegistry()
        });
    }
//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.exposeIdsFor(TradingRecord.class);
//        //config.exposeIdsFor(Library.class);
//    }
}