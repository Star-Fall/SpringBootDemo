package com.starfall.springboot.controller;

import com.starfall.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot.controller
 * @className DemoController
 * @date 2019/4/14 21:40
 * @description DemoController
 */
@RestController
public class DemoController {

    @RequestMapping("/get/user")
    public Map<String,Object> getUser() {
        User user = new User();
        Map<String,Object> map=new HashMap<>(1);
        map.put("user",user);
        return map;
    }

    @Autowired
    private  User useYaml;

    @RequestMapping("/get/user/yaml")
    public Map<String,Object> getUserYaml() {
        Map<String,Object> map=new HashMap<>(1);
        map.put("user",useYaml);
        return map;
    }
}

