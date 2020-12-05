package com.cameo.rest01.bca.util;

import com.cameo.rest01.entity.TradingRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * 解决ID不能暴露的问题
 */
@Component
public class RestConfiguration implements RepositoryRestConfigurer {
    /**
     * 注册暴露ID的实体
     * @return
     */
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer()
    {
        return RepositoryRestConfigurer.withConfig(config -> {
            config.exposeIdsFor(TradingRecord.class);
        });
    }

    /**
     * 增加CORS跨域支持
     * @param config
     * @param cors
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        cors.addMapping("/**");
    }
    //    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.exposeIdsFor(TradingRecord.class);
//        //config.exposeIdsFor(Library.class);
//    }
}