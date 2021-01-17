package com.mydigipay.paymentService.base.config;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class DozerConfig {

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public DozerBeanMapper dozerBeanMapper() throws IOException {
        DozerBeanMapper mapper = new DozerBeanMapper();
        File mainFolder = resourceLoader.getResource("classpath:dozer-mapping/").getFile();
        mapper.addMapping(resourceLoader.getResource(
                "classpath:dozer-mapping/global-configurations.xml").getInputStream());
        for (File item : mainFolder.listFiles()) {
            if (item.isDirectory()) {
                for (File mapping : item.listFiles()) {
                    if (mapping.isFile() && mapping.getName().endsWith("xml")) {
                        InputStream stream = new FileInputStream(mapping);
                        mapper.addMapping(stream);
                    }
                }
            }
        }
        return mapper;
    }
}
