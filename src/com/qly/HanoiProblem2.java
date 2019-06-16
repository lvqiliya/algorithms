package com.qly;

import java.util.Stack;


/**
 * 修改后的 Hanoi 问题不能让任何塔从左直接移到右，也不能直接从右移到左，必须通过中间的柱子。
 * 也就是说，实际动作只有四个：左到中，中到左，中到右， 右到中。
 * 把左中右三个点抽象为三个栈并分别记为 LS、MS、RS。最初所有的元素都在 LS 上。
 * 上面提到的四个动作可以抽象为从某一个栈 pop，然后 push 到另一个栈。这些移动需要遵守以下规则：
 * 1. 压大不压小。出栈的栈顶元素大小不能入栈的当前栈顶元素大。
 * 2. 相邻不可逆。要求得最优的步数，那么相邻的动作不能互为逆过程。一个元素先从左移到中，再从中移到左是属于无效操作。
 */
public class HanoiProblem2 {
    public static void main(String[] args) {
        System.out.println(move(3, "left", "mid", "right"));
    }

    public enum Action {
        /**
         *
         */
        No,
        LToM,
        MToL,
        MToR,
        RToM
    }

    public static int move(int n, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = n; i > 0; i--) {
            lS.push(i);
        }
        // 至此，万事俱备。有三个栈，并保证三个栈的值不会溢出。将所有元素从大到小分别 push 到栈中。

        // 接下来是针对每个元素的移动，直到所有元素全都装进 rS 中方可结束。
        // 根据规则 2，若要想确保本次移动是有效的，那么需要知道上一次移动。所以需要一个用来存储每一步操作的数组。
        Action[] record = {Action.No};
        // 当然，本来就是需要求出一共花了多少步。所以需要 step 来存步数到时候再返回即可。
        int step = 0;
        while (rS.size() != n + 1) {
            // 看起来四个动作用到的是一个方法，先不考虑方法体，我们设计一下方法。
            // 移动的时候给出指定动作，同时需要知道前一个动作，这个动作应该是存在 record 中的；
            // 接下来需要从哪个栈出栈，然后压入哪个栈。
            step += fStackToStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackToStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackToStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackToStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    private static int fStackToStack(Action[] record, Action preAct, Action nowAct,
                                      Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        if (record[0] != preAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

}
