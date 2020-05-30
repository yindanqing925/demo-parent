package org.nh.gome.demo.algo;

/**
 * @program: DecodeString.java
 * @description:
 * @author: yindanqing
 * @create: 2020/1/14 16:22
 */
public class DecodeString {

    public static void main(String[] args){
        String aa = "3[a]2[bc]";
        String bb = "3[a2[c]]2[a]";
        String cc = "2[abc]3[cd]ef";
        DecodeString decodeString = new DecodeString();
        decodeString.decodeString(aa);
        decodeString.decodeString(bb);
        decodeString.decodeString(cc);
    }

    private static final char PREFIX = '[';
    private static final char SUFFIX = ']';

    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = 0;
        while (true){
            if(i == chars.length-1){
                str.append(chars[i]);
                break;
            }
            if(chars[i] == PREFIX){

            }
        }
        return str.toString();
    }


}
