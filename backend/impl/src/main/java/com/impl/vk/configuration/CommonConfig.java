package com.impl.vk.configuration;

import com.impl.vk.utils.RandomGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(value = "com")
public class CommonConfig {

    @Bean
    public RandomGenerator getRandomGenerator() {
        return new RandomGenerator();
    }

}
