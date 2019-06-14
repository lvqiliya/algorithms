package com.qly;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }

    private static int reverse(int x) {
        long res = 0;

        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) res;
    }

}
