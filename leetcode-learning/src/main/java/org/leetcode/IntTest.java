package org.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class IntTest {
    public static void main(String[] args) {
        Integer i = 1;
        i = i+1;
        System.out.println(i);

        AtomicInteger count = new AtomicInteger(i);

    }
}
