package com.starfall.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot.controller
 * @className ControllerDemo
 * @date 2019/4/13 13:00
 * @description ControllerDemo
 */
@RestController
public class ControllerDemo {

    @RequestMapping("demo/hello")
    public String hello() {
        return "demo hello";
    }

}
