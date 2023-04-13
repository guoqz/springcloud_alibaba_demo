package com.skcx.test.stream;

import com.skcx.test.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Created Guoqz
 * @Date 2023/3/8 16:59
 * @Description TODO
 */
public class StreamDemo {

    // 创建三个user
    static User user1 = new User("111", "18", 180);
    static User user2 = new User("222", "18", 175);
    static User user3 = new User("333", "19", 170);


    // 遍历
    public static void test(List<User> userList) {

//        List<String> userNameList = new ArrayList<>();
//        for (User user : userList) {
//            userNameList.add(user.getName());
//        }
//        System.out.println("userNameList = " + userNameList);

        // Stream流
        List<String> userNameList2 = userList.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println("userNameList2 = " + userNameList2);
    }


    // 过滤，或者说是根据一个判断条件筛选出目标对象
    public static void test2(List<User> userList) {

        List<User> newUserList = new ArrayList<>();
        // if判断
        for (User user : userList) {
            if (user.getName() != null) {
                newUserList.add(user);
            }
        }
        System.out.println("newUserList = " + newUserList);


        // 获取userName不为空的user的List
        List<User> list = userList.stream()
                .filter(user -> user.getName() != null)
                .collect(Collectors.toList());
        System.out.println("list = " + list);

    }


    // 分组
    public static void test3(List<User> userList) {
        Map<String, List<User>> map = new HashMap<>();
        // if判断
        for (User user : userList) {
            if (map.get(user.getAge()) == null) {
                map.put(user.getAge(), new ArrayList());
            }
            map.get(user.getAge()).add(user);
        }
        System.out.println("map = " + map);


        // Stream流：groupingBy
        Map<String, List<User>> map2 = userList.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
        System.out.println("map2 = " + map2);

    }


    public static void test4(List<User> userList) {
        userList.stream().map(user -> {
            user.setHeight(null);
            return user;
        }).collect(Collectors.toList());
        userList.forEach(System.out::println);
    }


    public static void main(String[] args) {

        // stream流，创建的是动态数组，可以添加元素
        List<User> userList = Stream.of(user1, user2, user3).collect(Collectors.toList());

//        test(userList);
//        test2(userList);
//        test3(userList);
        test4(userList);

    }


}
