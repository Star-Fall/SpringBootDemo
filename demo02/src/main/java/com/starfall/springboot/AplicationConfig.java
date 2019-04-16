package com.starfall.springboot;

import com.starfall.springboot.bean.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot
 * @className AplicationConfig
 * @date 2019/4/15 22:54
 * @description AplicationConfig
 */
@Configuration
public class AplicationConfig {

    @Bean
    public Department department() {
        return new Department();
    }
}
