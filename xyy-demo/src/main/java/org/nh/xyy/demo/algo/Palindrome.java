package org.nh.xyy.demo.algo;

/**
 * Palindrome
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/6 15:36
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(-121));
    }


    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int tmp = x;
        int res = 0;
        while (tmp > 0){
            res = res * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return res == x;
    }

}
