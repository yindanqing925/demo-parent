package org.nh.gome.demo.algo;

import java.util.Stack;

/**
 * @program: Solution.java
 * @description: 逆波兰表达式求值
 * @author: yindanqing
 * @create: 2019/12/27 16:12
 */
public class Solution {

    public static void main(String[] args) {
        String[] strings = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(strings));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int rightNum = stack.pop();
                int leftNum = stack.pop();
                stack.push(leftNum + rightNum);
            } else if ("-".equals(token)) {
                int rightNum = stack.pop();
                int leftNum = stack.pop();
                stack.push(leftNum - rightNum);
            } else if ("*".equals(token)) {
                int rightNum = stack.pop();
                int leftNum = stack.pop();
                stack.push(leftNum * rightNum);
            } else if ("/".equals(token)) {
                int rightNum = stack.pop();
                int leftNum = stack.pop();
                stack.push(leftNum / rightNum);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
