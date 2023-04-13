package com.skcx.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) {


//        "Order{ long id; String shop; BigDecimal value};
//        List<Order> orderList;有下列内容：
//        {1,""shopA"",10},{2,""shopB"",10},{3,""shopB"",20},{4,""shopC"",10},{5,""shopC"",20},{6,""shopC"",30}，{7,""shopC"",null}.
//        1) 对orderList 按shop分组；
//        2) 求各个shop的value之和；
//        3) 求各个shop的value的平均值，保留2位小数
//        4)求各个shop的value最大、最小值
//        考虑真实情况下，可能有的order的属性是null，这种order不作处理，
//        尽量使用最简的运算复杂度，循环遍历越少越好"

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1, "shopA", new BigDecimal(10)));
        orderList.add(new Order(2, "shopB", new BigDecimal(10)));
        orderList.add(new Order(3, "shopB", new BigDecimal(20)));
        orderList.add(new Order(4, "shopC", new BigDecimal(10)));
        orderList.add(new Order(5, "shopC", new BigDecimal(20)));
        orderList.add(new Order(6, "shopC", new BigDecimal(30)));
        orderList.add(new Order(7, "shopC", null));
        group(orderList);
        System.out.println(sum(orderList));
        System.out.println(avg(orderList));
        System.out.println(max(orderList));
        System.out.println(min(orderList));
    }

    public static void group(List<Order> orderList) {
        Map<String, List<Order>> listMap = orderList.stream().collect(Collectors.groupingBy(Order::getShop));
        System.out.println(listMap);
    }

    public static BigDecimal sum(List<Order> orderList) {
        BigDecimal reduce = Optional.ofNullable(orderList)
                .orElse(new ArrayList<>())
                .stream()
                .filter(x -> x.getValue() != null) // 避免空指针
                .map(Order::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return reduce;
    }

    public static BigDecimal avg(List<Order> orderList) {
        BigDecimal average = orderList.stream()
                .filter(order -> order.getValue() != null)
                .map(Order::getValue).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(orderList.size()), 2, RoundingMode.HALF_UP);
        return average;
    }

    public static BigDecimal max(List<Order> orderList) {
        BigDecimal maxVal = orderList.stream()
                .filter(friend -> friend.getValue() != null)
                .map(Order::getValue)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        return maxVal;
    }


    public static BigDecimal min(List<Order> orderList) {
        BigDecimal minVal = orderList.stream()
                .filter(friend -> friend.getValue() != null)
                .map(Order::getValue)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        return minVal;
    }
}


class Order {
    private long id;
    private String shop;
    private BigDecimal value;

    public Order(long id, String shop, BigDecimal value) {
        this.id = id;
        this.shop = shop;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", shop='" + shop + '\'' +
                ", value=" + value +
                '}';
    }
}
