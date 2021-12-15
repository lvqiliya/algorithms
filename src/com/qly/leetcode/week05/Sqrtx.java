package com.qly.leetcode.week05;

/**
 * 69. Sqrt(x)
 *
 * @author qlylv
 */
public class Sqrtx {

    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

}
