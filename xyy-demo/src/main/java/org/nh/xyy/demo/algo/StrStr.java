package org.nh.xyy.demo.algo;

/**
 * StrStr
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/6 17:09
 */
public class StrStr {

    public static void main(String[] args) {
        String haystack = "hello", needle = "o";
        System.out.println(new StrStr().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() ==0){
            return 0;
        }
        String tmp;
        for (int i = 0; i <= haystack.length() - needle.length() ; i++) {
            tmp = haystack.substring(i);
            if(tmp.startsWith(needle)){
                return i;
            }
        }
        return -1;
    }

}
