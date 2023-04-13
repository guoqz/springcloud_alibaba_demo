package com.skcx.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo3 {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(nums);
        List<Integer> collect = list.stream().filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        collect.forEach(s -> System.out.println(s));// 偶数

        int result = 0;
        for (Integer integer : collect) {
            result += Math.pow(integer, 2);
        }
        System.out.println(result); //平方和
    }
}
