package org.nh.xyy.demo.base;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Base64Demo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/11 11:53
 */
public class Base64Demo {

    public static void main(String[] args) {
        String str = "我爱北京天安门, 我爱毛主席";

/*
        String encode = Base64.getEncoder().encodeToString(str.getBytes(Charset.forName("UTF-8")));
        System.out.println("Base64 编码字符串 (基本) :" + encode);
        String decode = new String(Base64.getDecoder().decode(encode), Charset.forName("UTF-8"));
        System.out.println(decode);

        String encode1 = Base64.getUrlEncoder().encodeToString(str.getBytes(Charset.forName("UTF-8")));
        System.out.println("Base64 编码字符串 (基本) :" + encode1);
        String decode1 = new String(Base64.getUrlDecoder().decode(encode1), Charset.forName("UTF-8"));
        System.out.println(decode1);

        String encode2 = Base64.getMimeEncoder().encodeToString(str.getBytes(Charset.forName("UTF-8")));
        System.out.println("Base64 编码字符串 (基本) :" + encode2);
        String decode2 = new String(Base64.getUrlDecoder().decode(encode2), Charset.forName("UTF-8"));
        System.out.println(decode2);
*/


        String encode3 = Base64.getEncoder().encodeToString("为山九仞, 功亏一篑".getBytes(Charset.forName("UTF-8")));
        System.out.println(encode3);
        String decode3 = new String(Base64.getMimeDecoder().decode(encode3), Charset.forName("UTF-8"));
        System.out.println(decode3);

    }

}
