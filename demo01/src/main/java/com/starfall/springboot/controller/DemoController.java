package com.starfall.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot.controller
 * @className DemoController
 * @date 2019/4/13 22:42
 * @description DemoController
 */
@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String demo() {
        return "demo hello";
    }
}
