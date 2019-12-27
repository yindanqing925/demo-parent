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

    // 初始化符号容器
    private Map<Character, Character> map = new HashMap<>(4);
    {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    // 声明栈
    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        // 遍历字符串数组
        for (char c : s.toCharArray()) {
            // 如果map的values中包含当前符号, 直接压入栈顶
            if (map.values().contains(c)) {
                stack.push(c);
            } else {
                // 验证当前栈是否为空, 如果为空, 则条件一定不满足
                if (stack.empty()){
                    return false;
                }
                //推出栈顶元素, 如果和当前符号在集合中的映射关系不符合, 则条件一定不满足
                if(stack.pop() != map.get(c)){
                    return false;
                }
            }
        }
        //当所有元素遍历完成时, 栈一定为空, 如果栈不为空, 则条件一定不满足
        return stack.empty();
    }

}
