package org.nh.gome.demo.base;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @program: Base64Demo.java
 * @description: Base64
 * @author: yindanqing
 * @create: 2020/6/10 20:35
 */
public class Base64Demo {

    public static void main(String[] args) {
        String password = "123456";
        //密文
        String baseCipherText = new String(Base64.getEncoder().encode(password.getBytes()));
        //明文
        String basePlainText = new String(Base64.getDecoder().decode(baseCipherText.getBytes()));
        System.out.println("baseCipherText:" + baseCipherText);
        System.out.println("basePlainText:" + basePlainText);
        //md5密文
        String md5CipherText = DigestUtils.md5Hex(password);
        System.out.println("md5CipherText:" + md5CipherText);

        String md5CipherText2 = new String(DigestUtils.md5(password.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        System.out.println("md5CipherText2:" + md5CipherText2);
    }
}
