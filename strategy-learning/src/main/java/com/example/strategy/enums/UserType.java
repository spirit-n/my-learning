package com.example.strategy.enums;

import java.util.function.IntPredicate;

public enum UserType {
    NORMAL(recharge -> recharge > 0 && recharge <= 1000),
    VIP(recharge -> recharge > 1000 && recharge <= 10000),
    SVIP(recharge -> recharge > 10000);

    private final IntPredicate support;

    UserType(IntPredicate support) {
        this.support = support;
    }

    public static UserType typeOf(int recharge) {
        for (UserType userType : UserType.values()) {
            if (userType.support.test(recharge)) {
                return userType;
            }
        }
        return null;
    }
}
