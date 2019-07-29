package org.nh.xyy.demo.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * IsValid
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/6 17:54
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("([)]"));
    }

    private Map<Character, Character> map = new HashMap<>();
    {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    private Stack<Character> stack = new Stack<>();
    public boolean isValid(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()){
                    return false;
                }
                if(stack.pop() != map.get(c)){
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
