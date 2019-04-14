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

    private Date dateTime;
    private String dateStr;
    private String boolStr;
    private Department depNull;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getBoolStr() {
        return boolStr;
    }

    public void setBoolStr(String boolStr) {
        this.boolStr = boolStr;
    }

    public Department getDepNull() {
        return depNull;
    }

    public void setDepNull(Department depNull) {
        this.depNull = depNull;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", bool=" + bool +
                ", date=" + date +
                ", map=" + map +
                ", list=" + list +
                ", dep=" + dep +
                ", dateTime=" + dateTime +
                ", dateStr='" + dateStr + '\'' +
                ", boolStr='" + boolStr + '\'' +
                ", depNull=" + depNull +
                '}';
    }
}
