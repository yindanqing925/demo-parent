package org.nh.xyy.demo.algo;

/**
 * Reverse
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/6 14:28
 */
public class Reverse {

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(214748364));
    }

    public int reverse(int x) {
        int sign = 1;
        if(x < 0){
            sign = -1;
        }
        String value = new StringBuffer(String.valueOf(Math.abs((long)x))).reverse().toString();
        long aLong = Long.parseLong(value);
        if(aLong*sign > Integer.MAX_VALUE || aLong*sign < Integer.MIN_VALUE){
            return 0;
        }
        return (int)aLong * sign;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
