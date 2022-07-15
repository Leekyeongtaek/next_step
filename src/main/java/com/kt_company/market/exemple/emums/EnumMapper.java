package com.kt_company.market.exemple.emums;

import java.util.LinkedHashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumMapper {

    @Bean
    public EnumMapperFactory createEnumMapperFactory() {
        EnumMapperFactory enumMapperFactory = new EnumMapperFactory(new LinkedHashMap<>());
        enumMapperFactory.put("Status", Status2.class);
        return enumMapperFactory;
    }

}
