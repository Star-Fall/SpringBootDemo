> 配置文件

[TOC]

# 一、Spring Boot 配置文件

+ application.properties
+ application.yml

# 二、YAML

> ***YMAL* (*YAML Ain't Markup Language)*** YMAL 不是一种标记语言。它强调以数据为中心，以缩进的结构进行呈现，适合在脚本语言、序列化和配置文件中使用。

## 2.1、YAML基本语法

### 2.1.1、基本准则

+ 1、大小写敏感 

+ 2、使用缩进表示层级关系 

+ 3、禁止使用tab缩进，只能使用空格键 

+ 4、缩进长度没有限制，一般每个缩进级别由两个空格组成，只要元素对齐就表示这些元素属于一个层级。 

### 2.1.2、基本语法 
+ `key:（空格）value` 表示一对键值对（空格必须有）；
+ 以**空格**的缩进来控制层级关系；只要是左对齐的一列数据，都是同一个层级的。
+ 字符串默认不用加上单引号或者双引号。
+ `#`表示注释 

## 2.2、YAML基本使用

### 2.2.1、标量（基本数据类型）

字符串、布尔值、整数、浮点数、Null、 时间、日期

#### 字符串

~~~yaml
#字符串：字符串默认不用加上单引号或者双引号
str: 这是一行字符串
~~~

~~~yaml
#双引号不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思
##输出；zhangsan 换行 lisi
name: "zhangsan \n lisi"
~~~

```yaml
#单引号；会转义特殊字符，特殊字符最终只是一个普通的字符串数据
#输出；zhangsan \n  lisi
name: 'zhangsan \n lisi'
```

#### 布尔值

~~~yaml
bool: false
~~~

#### NULL

~~~yaml
#NULL的时候，不写key即可
~~~

### 2.2.2、键值表（对象/Map）

~~~yaml
user: 
  userId: 12
  userName: zhangsan
~~~

~~~yaml
#行内写法：
user: {userId: 12,userName: zhangsan}
~~~
相当JSON:
~~~json
{
    "user": {
        "userId": 12,
        "userName": "zhangsan"
    }
}
~~~

### 2.2.3、序列（数组和列表）

用`-`值表示数组中的一个元素，

```yaml
#使用一个短横杠加一个空格
list: 
  - item1
  - itme2
```

~~~yaml
#行内写法
list: [item1,itme2]
~~~

### 2.2.4、复合结构

#### map嵌套map

~~~yaml
websites: 
  YAML: yaml.org 
  Ruby: ruby-lang.org 
  Python: python.org 
  Perl: use.perl.org
~~~

~~~json
{
    websites: {
        YAML: 'yaml.org',
        Ruby: 'ruby-lang.org',
        Python: 'python.org',
        Perl: 'use.perl.org'
    }
}
~~~

#### map嵌套list

~~~yaml
languages: 
  - Ruby
  - Perl
  - Python 
  - c
~~~

~~~json
{
    languages: [
        'Ruby',
        'Perl',
        'Python',
        'c'
    ]
}
~~~

#### list嵌套map

~~~yaml
list_map: 
-
  id: 1
  name: huang
-
  id: 2
  name: liao
~~~

~~~json
{
    list_map: [
        {
            id: 1,
            name: 'huang'
        },
        {
            id: 2,
            name: 'liao'
        }
    ]
}
~~~

#### list嵌套list

~~~yaml
list_list: 
- 
  - Ruby
  - Perl
  - Python 
- 
  - c
  - c++
  - java
~~~

~~~json
{
    list_list: [
        [
            'Ruby',
            'Perl',
            'Python'
        ],
        [
            'c',
            'c++',
            'java'
        ]
    ]
}
~~~

> 参考：
>
> + <https://blog.csdn.net/vincent_hbl/article/details/75411243>
> + <https://blog.csdn.net/f8152/article/details/79994545>
> + <https://blog.csdn.net/liukuan73/article/details/78031693>
> + <https://www.cnblogs.com/moonandstar08/p/6435640.html>

# 三、配置文件值注入Bean

## 3.1、使用@ConfigurationProperties

#### **application.yml配置**

~~~yaml
#User1
user:
  userId: 12
  userName: userName
  bool: false
  date: 2019/04/13
  map:
    key1: value1
    key2: value2
    key3: value3
  list:
    - list01
    - list02
    - list03
    - list04
  dep:
    depId: 11
    depName: IT
~~~

####  JavaBean

~~~java
package com.starfall.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot.bean
 * @className User
 * @date 2019/4/14 21:37
 * @description User
 */
@Component
@ConfigurationProperties(prefix = "user")
public class User implements Serializable {

    private Integer userId;
    private String userName;
    private Boolean bool;
    private Date date;
    private Map<String, Object> map;
    private List list;
    private Department dep;
    
    //getter、setter
} 
~~~

#### 引入依赖

~~~xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
~~~

#### 测试

~~~java
@Autowired
private  User useYaml;
@RequestMapping("/get/user/yaml")
public Map<String,Object> getUserYaml() {
    Map map=new HashMap<String,Object>();
    map.put("user",useYaml);
    return map;
}
~~~

#### 测试结果

~~~json
{
    "user": {
        "userId": 12,
        "userName": "userName",
        "bool": false,
        "date": "2019-04-12T16:00:00.000+0000",
        "map": {
            "key1": "value1",
            "key2": "value2",
            "key3": "value3"
        },
        "list": [
            "list01",
            "list02",
            "list03",
            "list04"
        ],
        "dep": {
            "depId": 11,
            "depName": "IT"
        }
    }
}
~~~

