package com.issac.primary.controller;

import com.issac.primary.dto.CountryDto;
import com.issac.primary.dto.GroupDto;
import com.issac.primary.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-30
 * @desc:
 */
@RestController
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8")
public class SomeController {

    @Value("${company.name}")
    private String companyName;

    @Value("${city.name}")
    private String cityName;

    @Autowired
    private StudentDto studentDto;

    @Autowired
    private CountryDto countryDto;

    @Autowired
    private GroupDto groupDto;

    @GetMapping("/some")
    public String someHandle() {
        return groupDto.toString();
    }
}
