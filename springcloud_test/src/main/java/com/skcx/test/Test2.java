package com.skcx.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

    //    输入任意一种物质，要求输出其每种元素的数量.
//    比如
//    输入CaC03 ,其组成分别为Ca : 1, C : 1,0 : 3 ,输出Ca1C103
//    输入 Fe2(SO4)3 ,其组成分别为 Fe : 2 , S : 3,0 : 12 ,输出 Fe2S3O12
//            (注意：元素名称首字母大写，剩余字母都小写；括号括起来表示括号中的结构作为整体出现多少次)
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        String demo = "C3((CO)2)4";
//        String demo = "C6H12O6";
//        String demo = "CaC03";
        String demo = "Fe2(SO4)3";
        System.out.println(demo);
        splitString(demo, 1);
        System.out.println(map.toString());
    }

    private static void splitString(String demo, int rdx) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < demo.length(); i++) {
            char c = demo.charAt(i);
            if (Character.isUpperCase(c) && i != idx || c == '(') {
                String keyVal = demo.substring(idx, i);
                list.add(keyVal);
                idx = i;
                if (c == '(') {
                    i = demo.lastIndexOf(')');
                }
            }
        }
        if (idx < demo.length()) {
            list.add(demo.substring(idx));
        }
        for (String val : list) {
            if (val.contains("(")) {
                int composeVal = getComposeVal(val);
                splitString(val.substring(1, val.lastIndexOf(')')), composeVal * rdx);
            } else {
                putMap(val, rdx);
            }
        }
    }


    private static int getComposeVal(String val) {
        int rdx = 1;
        int idx = val.lastIndexOf(')');
        if (++idx < val.length())
            rdx = Integer.parseInt(val.substring(idx));
        return rdx;
    }

    private static void putMap(String keyVal, int rdx) {
        String key;
        int val = 1;
        int k = 0;
        for (int i = 0; i < keyVal.length(); i++) {
            if (Character.isDigit(keyVal.charAt(i))) {
                k = i;
                break;
            }
        }
        if (k != 0) {
            key = keyVal.substring(0, k);
            val = Integer.parseInt(keyVal.substring(k));
        } else {
            key = keyVal;
        }
        if (!key.isEmpty()) {
            Integer result = map.get(key);
            if (result == null)
                result = 0;
            map.put(key, val * rdx + result);
        }
    }
}
