package com.quxun.object;

/**
 * Description:
 * Created by quxiaozha on 2018-9-18 13:03.
 */
public class Student {
    int id;
    String name;
    Address addr;

    public Student(int id, String name, Address addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddr() {
        return addr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }
}
