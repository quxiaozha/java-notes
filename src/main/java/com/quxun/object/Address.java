package com.quxun.object;

/**
 * Description:
 * Created by quxiaozha on 2018-9-18 13:03.
 */
public class Address {
    String homeAddr;
    String workAddr;

    public Address(String homeAddr, String workAddr) {
        this.homeAddr = homeAddr;
        this.workAddr = workAddr;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public String getWorkAddr() {
        return workAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public void setWorkAddr(String workAddr) {
        this.workAddr = workAddr;
    }
}
