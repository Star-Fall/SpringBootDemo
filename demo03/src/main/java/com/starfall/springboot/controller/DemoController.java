package com.starfall.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot.controller
 * @className DemoController
 * @date 2019/4/23 22:44
 * @description DemoController
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/map")
    public Map getMap() {
        Map map = new HashMap();
        map.put("name", "name");
        return map;
    }
}