package org.nh.xyy.demo.algo;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * PlusOne
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/6 16:26
 */
public class PlusOne {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9,9,9,9,9,9,9,9,9,9,9,9})));
        System.out.println(Arrays.toString((new int[]{9,9,9,9,9,9,9,9,9,9,9,9})));
        System.out.println(Arrays.toString((new int[]{5,2,2,6,5,7,1,9,0,3,8,6,8,6,5,2,1,8,7,9,8,3,8,4,7,2,5,8,9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{5,2,2,6,5,7,1,9,0,3,8,6,8,6,5,2,1,8,7,9,8,3,8,4,7,2,5,8,9})));
    }

    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1] < 9){
            digits[digits.length-1] ++;
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--){
            digits[i] += 1;
            if(digits[i] > 9){
                digits[i] = 0;
            }else {
                return digits;
            }
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
