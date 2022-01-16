package com.qly.task.week09;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 *
 * @author qlylv
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        // 匹配所有空白符，一次多个
        String regex = "\\s+";
        List<String> list = Arrays.asList(s.split(regex));
        Collections.reverse(list);
        return String.join(" ", list);
    }

}
