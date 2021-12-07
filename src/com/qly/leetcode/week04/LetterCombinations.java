package com.qly.leetcode.week04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * @author qlylv
 */
public class LetterCombinations {

    private final Map<Character, String> alphabet = new HashMap<>();
    private final List<String> ans = new ArrayList<>();
    private String digits;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return ans;
        }
        this.digits = digits;
        alphabet.put('2', "abc");
        alphabet.put('3', "def");
        alphabet.put('4', "ghi");
        alphabet.put('5', "jkl");
        alphabet.put('6', "mno");
        alphabet.put('7', "pqrs");
        alphabet.put('8', "tuv");
        alphabet.put('9', "xyz");
        dfs(0, "");
        return ans;
    }

    private void dfs(int index, String str) {
        // 递归边界
        if (index == digits.length()) {
            ans.add(str);
            return;
        }
        char[] chars = alphabet.get(digits.toCharArray()[index]).toCharArray();
        for (char ch : chars) {
            dfs(index + 1, str + ch);
        }
    }

}
