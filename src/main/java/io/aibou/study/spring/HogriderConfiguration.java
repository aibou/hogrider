package io.aibou.study.spring;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @SpringBootApplication は @Configuration, @EnableAutoConfiguration, @ComponentScan を内包したもの
 */
@RequiredArgsConstructor
@MapperScan(basePackages = {"io.aibou.study.spring.mapper"})
@SpringBootApplication
public class HogriderConfiguration {

}
