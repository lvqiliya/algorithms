package com.qly.task.week05;

/**
 * 74. 搜索二维矩阵
 *
 * 解题思路
 * 将该二维数组当做一维数组来进行二分查找，需要处理好二维下标
 *
 * @author qlylv
 */
public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // mid / n代表行下标，mid % n代表列下标
            if (target < matrix[mid / n][mid % n]) {
                right = mid - 1;
            } else if (target > matrix[mid / n][mid % n]){
                left = mid + 1;
            } else{
                return true;
            }
        }
        return false;
    }

}
