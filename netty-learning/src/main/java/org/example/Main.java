package org.example;

import com.alibaba.fastjson.JSON;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = "['a','b','c']";
        List<Integer> list = JSON.parseObject(s, List.class);
        System.out.println(list.get(0));
    }
}