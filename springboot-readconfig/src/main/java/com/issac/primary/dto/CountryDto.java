package com.issac.primary.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-02
 * @desc:
 */
@Component
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8")
@Data
@ConfigurationProperties("country")
public class CountryDto {
    private List<String> cities;
}
