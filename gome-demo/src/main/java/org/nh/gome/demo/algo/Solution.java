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
        //声明栈
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            // 匹配符号
            // 如果命中, 则推出栈顶两个元素用当前符号进行运算, 栈顶第一个元素在运算符右边, 第二个元素在运算符左边(先进后出)
            // 运算结果直接压入栈顶, 待下一次出栈运算使用(并不一定是下一个符号)
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
                //如果没有命中符号, 则默认为待操作数, 直接压入栈顶, 不做异常处理
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
