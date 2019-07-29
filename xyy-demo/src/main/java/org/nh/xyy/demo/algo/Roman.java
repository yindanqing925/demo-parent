package org.nh.xyy.demo.algo;

/**
 * Roman
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/6 16:02
 */
public class Roman {



    public static void main(String[] args) {
        System.out.println(new Roman().romanToInt("MCMXCIV"));
    }

    //1
    private final char I = 'I';
    //5
    private final char V = 'V';
    //10
    private final char X = 'X';
    //50
    private final char L = 'L';
    //100
    private final char C = 'C';
    //500
    private final char D = 'D';
    //1000
    private final char M = 'M';

    public int romanToInt(String s) {
        int res = 0;
        char[] value = s.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (value[i] == I) {
                if((i+1) == value.length){
                    res += 1;
                    continue;
                }
                if (value[i + 1] == V) {
                    res += 4;
                    i++;
                } else if (value[i + 1] == X) {
                    res += 9;
                    i++;
                } else {
                    res += 1;
                }
            } else if (value[i] == V) {
                res += 5;
            } else if (value[i] == X) {
                if((i+1) == value.length){
                    res += 10;
                    continue;
                }
                if (value[i + 1] == L) {
                    res += 40;
                    i++;
                } else if (value[i + 1] == C) {
                    res += 90;
                    i++;
                } else {
                    res += 10;
                }
            } else if (value[i] == L) {
                res += 50;
            } else if (value[i] == C) {
                if((i+1) == value.length){
                    res += 100;
                    continue;
                }
                if (value[i + 1] == D) {
                    res += 400;
                    i++;
                } else if (value[i + 1] == M) {
                    res += 900;
                    i++;
                } else {
                    res += 100;
                }
            } else if (value[i] == D) {
                res += 500;
            } else if (value[i] == M) {
                res += 1000;
            }
        }
        return res;
    }
}
