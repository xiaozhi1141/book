package com.example.pojo;

public class UserIp {
    private Integer id;
    private Integer userId;
    private String ip;
    private String createTime;

    public UserIp() {
    }

    public UserIp(Integer id, Integer userId, String ip, String createTime) {
        this.id = id;
        this.userId = userId;
        this.ip = ip;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserIp{" +
                "id=" + id +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
