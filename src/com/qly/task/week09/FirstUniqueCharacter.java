package com.qly.task.week09;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author qlylv
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        // 将每个字符映射到hash表中
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, -1);
            } else {
                hashMap.put(ch, i);
            }
        }
        // 选举最小下标
        int first = n;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        return first == n ? -1 : first;
    }

}
