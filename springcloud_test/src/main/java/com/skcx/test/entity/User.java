package com.skcx.test.entity;

/**
 * @Created Guoqz
 * @Date 2023/3/8 16:57
 * @Description TODO
 */
public class User {

    private String name;
    private String age;
    private Integer height;

    public User() {
    }

    public User(String name, String age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", height=" + height +
                '}';
    }


}


