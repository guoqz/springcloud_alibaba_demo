package com.skcx.test;

import java.util.Arrays;
import java.util.HashMap;

public class Demo2 {

    public static void main(String[] args) {

        //arr1 =[1,2,2,3,3,3,4,5,5]请提供代码，要求返回数组重复的元素个数转换为map
        //期望结果: map = {1:1,2:2,3:3,4:1,5:2}

        Integer[] arr = new Integer[]{1, 2, 2, 3, 3, 3, 4, 5, 5};

        System.out.println(Arrays.toString(arr));

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer integer : arr) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                map.put(integer, map.get(integer) + 1);
            }
        }

        System.out.println("map = " + map.toString().replace('=', ':')); // map = {1:1, 2:2, 3:3, 4:1, 5:2}
    }

}
