package org.nh.gome.demo.algo;

/**
 * @program: LongestPrefix.java
 * @description: 寻找字符串数组中最长前缀
 * @author: yindanqing
 * @create: 2019/10/24 19:52
 */
public class LongestPrefix {

    public static void main(String[] args) {
        String[] strs5 = {"a","b"};
        System.out.println(new LongestPrefix().longestCommonPrefix(strs5));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

/*
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        if (strs[0].length() == 0){
            return strs[0];
        }
        int i = strs[0].length() / 2 + 1;
        return getLongestCommonPrefix(strs, i, 0);
    }
*/

    private String getLongestCommonPrefix(String[] strs, int i, int dir){
        if (i == 0) {
            return "";
        }
        if(i==strs[0].length()){
            return strs[0];
        }
        String substring = strs[0].substring(0, i);
        if (doesContains(substring, strs)) {
            if(dir == -1){
                return substring;
            }
            i++;
            return getLongestCommonPrefix(strs, i, 1);
        } else {
            if(dir == 1){
                return strs[0].substring(0, i-1);
            }
            i--;
            return getLongestCommonPrefix(strs, i, -1);
        }
    }

    private boolean doesContains(String substring, String[] strs){
        for (int i = 1; i < strs.length; i++){
            if(!strs[i].startsWith(substring)){
                return false;
            }
        }
        return true;
    }

}
