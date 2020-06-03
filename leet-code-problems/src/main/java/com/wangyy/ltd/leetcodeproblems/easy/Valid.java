package com.wangyy.ltd.leetcodeproblems.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Valid {

    public static void main(String[] args) {
        System.out.println(isValid(")}"));
    }

    public static boolean isValid(String s) {
        if (s == null) return true;
        if (s.length()%2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '{' || charAt == '[' || charAt == '('){
                stack.push(charAt);
            } else {
                if (charAt == '}'){
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    
                }

                if (charAt == ']'){
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }

                if (charAt == ')'){
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
            }
        }
        
        return stack.size() == 0;
    }
}
