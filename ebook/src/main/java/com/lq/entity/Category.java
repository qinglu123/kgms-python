package com.lq.entity;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.entity
 * @Author: LuQing
 * @CreateTime: 2023-02-11  21:52
 * @Description: TODO
 * @Version: 1.0
 */
public class Category {
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
