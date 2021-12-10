package com.qly.leetcode.week04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 433. 最小基因变化
 *
 * @author qlylv
 */
public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        char[] gene = new char[]{'A', 'C', 'G', 'T'};
        Set<String> hashBank = new HashSet<>(Arrays.asList(bank));
        if (!hashBank.contains(end)) {
            return -1;
        }
        Map<String, Integer> depth = new HashMap<>();
        depth.put(start, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char oldStr = chars[i];
                for (int j = 0; j < gene.length; j++) {
                    if (chars[i] != gene[j]) {
                        chars[i] = gene[j];
                        String ns = new String(chars);
                        chars[i] = oldStr;
                        if (!hashBank.contains(ns)) {
                            continue;
                        }
                        if (depth.containsKey(ns)) {
                            continue;
                        }
                        depth.put(ns, depth.get(s) + 1);
                        queue.offer(ns);
                        if (end.equals(ns)) {
                            return depth.get(ns);
                        }
                    }
                }
            }
        }
        return -1;
    }

}
