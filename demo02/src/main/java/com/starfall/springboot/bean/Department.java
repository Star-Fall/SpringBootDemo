package com.starfall.springboot.bean;

/**
 * @author StarFall
 * @project SpringBootDemo
 * @package com.starfall.springboot.bean
 * @className Department
 * @date 2019/4/14 22:33
 * @description Department
 */
public class Department {

    private Integer depId;
    private String depName;

    public Department() {
    }

    public Department(Integer depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                '}';
    }
}