package com.qly.stackandqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑倒最右边，窗口每次向右边滑一个位置。
 * 例如数组为 [4, 3, 5, 4, 3, 3, 6, 7]，窗口大小为 3 时：
 * <p>
 * [4  3  5] 4  3  3  6  7      窗口最大值为 5
 * 4 [3  5  4] 3  3  6  7      窗口最大值为 5
 * 4  3 [5  4  3] 3  6  7      窗口最大值为 5
 * 4  3  5 [4  3  3] 6  7      窗口最大值为 4
 * 4  3  5  4 [3  3  6] 7      窗口最大值为 6
 * 4  3  5  4  3 [3  6  7]     窗口最大值为 7
 * <p>
 * 数组长度为 n，窗口大小为 w，一共产生 n-w+1 个窗口最大值。
 * <p>
 * 实现一个函数：
 * 1. 输入：整型数组 arr，窗口大小 w。
 * 2. 输出：一个长度为 n-w+1 的数组 res，res[i] 表示每一种窗口状态下的最大值。
 * 以上例为例，返回 [5, 5, 5, 4, 6, 7]。
 * <p>
 * 实现思路：
 * 关键点是利用双端列队来实现窗口最大值的更新。首先生成双端队列 deque，用它存放数组 arr 中的下标。
 * 它有一个特点是队头必须是当前队列所有值的最大者，因为题目就是需要取得最大值。
 * <p>
 * 当遍历到 a[i] 的时候，放入规则如下：
 * 1. deque 为空，放入 i；
 * 2. deque 不为空，比较 arr[i] 和 arr[deque.peekLast()] 的大小：
 * arr[i] < arr[deque.peekLast()]，把 i 添加到队尾；
 * arr[i] >= arr[deque.peekLast()]，弹出对尾，重复放入规则。
 * <p>
 * 以上仅仅是如何放入数据到双端队列到 deque，最终还是需要取得各窗口状态下的最大值，也即是 arr[deque.peekFirst()]。
 * <p>
 * 当遍历到 a[i] 的时候，弹出规则如下：
 * 1. 当队头的下标 + w = i 的时候
 * <p>
 * 判断下标是否过期的条件：对头下标 deque.peekFirst() + 窗口大小 w = i
 */
public class GetMaxWindow {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = getMaxWindows(arr, 3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] getMaxWindows(int[] arr, int w) {
        // 数组为空、窗口不大于1、数组长度比窗口还小这三种情况对于此题无意义，故返回 null
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        // 需要用一个双端队列存下标
        Deque<Integer> deque = new LinkedList<>();
        // 需要一个数组存每个窗口的最大值
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 如果 deque 中有数据，且队尾下标对应数组值 <= 当前遍历的数组值，将队尾弹出。
            // 循环检查前面所有下标对应的数组值，保证次双端队列队头一定是该窗口的最大值。
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            // 将当前遍历的下标从队尾放入。
            deque.addLast(i);

            // 因为窗口的长度为 w，如果队列不做弹出规则的话，很可能取到最大值已经不是当前窗口的最大值。
            // 换一种说法，队头的值会因为窗口每次向右移动一位数组导致失效。
            // 那么需要根据 w 对失效队头进行弹出。
            // 当队头 + w = i 时，说明队头刚好失效：
            if (deque.peekFirst() == i - w) {
                deque.pollFirst();
            }

            // 根据题目，最终是需要返回每个窗口的最大值，队列放入规则可以了解到，当前队列的队头一定是当前窗口的最大值。
            // 因为 w >= 1，也即是说至少每一个值都是一个窗口。
            // 假设 w = 1，那么当遍历第一个元素完成的时候，我们就可以将它作为整个窗口的最大值返回至 res 数组中。
            // 元素遍历的下标是从 0 开始的，所以至少要 i = w - 1 才可以将它返回至 res 数组中。
            if (i >= w - 1) {
                // 这个时候需要一个 index 变量来进行 res 数组下标的自增。
                res[index++] = arr[deque.peekFirst()];
            }
        }
        return res;
    }
}
