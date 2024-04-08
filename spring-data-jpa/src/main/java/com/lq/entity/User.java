package com.lq.entity;



import javax.persistence.*;
import java.time.LocalDate;


/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.entity
 * @Author: LuQing
 * @CreateTime: 2023-02-13  20:20
 * @Description: TODO
 * @Version: 1.0
 */

//@Entity用来声明该类是一个实体类
@Entity
//@Table可以通过name属性指定与实体类对应的表，如果我们的实体类和表名相同，那么可以省略。
//Indexes属性和 @Index注解用来设置索引
@Table(indexes = {@Index(name = "uk_email",columnList = "email",unique = true)})
public class User {
    //@Id用来标识id字段为user表的主键
    @Id
    //@GeneratedValue用来指定主键的策略，这里使用的是MySQL的自增主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column可以对表字段进行详细配置，如是否可以为空、类型、长 度、备注等
    @Column(nullable = false,columnDefinition = "varchar(20) comment'姓名'")
    private String name;
    //@Transient表示被修饰属性不映射到表，即生成的user表里不会有age字段
    @Transient
    private int age;
    @Column(nullable = false,length = 50)
    private String email;

    private LocalDate birthday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
