package com.lq.stream;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.stream
 * @Author: LuQing
 * @CreateTime: 2023-02-03  15:13
 * @Description: TODO
 * @Version: 1.0
 */
public class Customer {
    private String name;
    private Integer id;

    public Customer() {
    }

    public Customer(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
