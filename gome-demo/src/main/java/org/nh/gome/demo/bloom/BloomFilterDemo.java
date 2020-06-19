package org.nh.gome.demo.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.lang.StringUtils;

import java.nio.charset.Charset;

/**
 * 布隆过滤器
 * @program: BloomFilterDemo.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/19 10:32
 */
public class BloomFilterDemo {

    private static final String PADDING = "0";

    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 1_0000_0000);
        for (int i = 0; i < 1_0000_0000; i++) {
            bloomFilter.put(StringUtils.leftPad(String.valueOf(i),9, PADDING));
        }
        System.out.println(bloomFilter.mightContain(StringUtils.leftPad("100",9, PADDING)));
        System.out.println(bloomFilter.mightContain(StringUtils.leftPad("332256",9, PADDING)));
    }

}
