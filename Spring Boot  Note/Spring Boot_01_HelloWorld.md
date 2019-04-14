[TOC]

# 一、环境准备

+ **jdk：**java version "1.8.0_201"
+ **Maven：**Maven 3.3+
+ **IDE：**IntelliJ IDEA 2018
+ **Spring Boot：**2.1.4.RELEASE

# 二、IDEA创建Maven工程

直接创建Maven工程，详情参考：[IntelliJ IDEA（7）——Maven创建简单项目](<https://blog.csdn.net/shaohe18362202126/article/details/88770295>)

![1555209053984](images\1555209053984.png)



# 三、依赖导入&主程序编写

## 3.1、继承Spring Boot 父项目

在项目的pom.xml中继承Spring Boot 的

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.4.RELEASE</version>
</parent>
```

## 3.2、声明starter依赖

可以声明一个或多个Starter，这里先声明一个starter-web。

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 3.3、Spring Boot Maven打包插件

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

## 3.4、主程序编写

包：com.starfall.springboot，应用主类`Application.java`置于root package下

```java
package com.starfall.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot
 * @className Application
 * @date 2019/4/13 22:41
 * @description Application
 * 注解@SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## 3.5、Controller编写

包：com.starfall.springboot.controller

```java
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
```

# 四、运行测试

## 4.1、运行

![1555210916059](images\1555210916059.png)

直接run Application 主程序

![1555210991338](images\1555210991338.png)

直接访问<http://localhost:8080/>是404的

![1555211047661](images\1555211047661.png)

访问Controller的路径：

![1555211084371](images\1555211084371.png)

## 4.2、测试

```java
package com.starfall.springboot.test;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot.test
 * @className ControllerTest
 * @date 2019/4/14 15:26
 * @description todo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class ControllerTest {

    @Autowired
    private WebApplicationContext context;
    protected MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testMockMvc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/demo").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("demo hello")))
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void testDemo() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/demo")).andReturn().getResponse();
        System.out.println("status:" + response.getStatus());
        System.out.println("result:" + response.getContentAsString());
    }
}
```

# 五、Spring Initializer快速创建Spring Boot项目

## 5.1、使用Spring Initializer

![1555219675927](images\1555219675927.png)

![1555219717403](images\1555219717403.png)

![1555220715647](images\1555220715647.png)

## 5.2、项目架构

![1555223195170](images\1555223195170.png)

**resources文件夹中目录结构**

- static：保存所有的静态资源； js css  images；
- templates：保存所有的模板页面；（Spring Boot默认jar包使用嵌入式的Tomcat，默认不支持JSP页面）；可以使用模板引擎（freemarker、thymeleaf）；
- application.properties：Spring Boot应用的配置文件；可以修改一些默认设置；

