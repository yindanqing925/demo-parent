package org.nh.rq.microservice.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @program: DownloadUtil.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/29 14:00
 */
public class DownloadUtil {

    private static final String requestPropertyName = "User-Agent";
    private static final String requestPropertyValue = "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)";

    /**
     * 从网络Url中下载文件
     * @param urlStr 文件路径
     * @throws IOException
     */
    public static InputStream downLoadFromUrl(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(30*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty(requestPropertyName, requestPropertyValue);
        //得到输入流
        return conn.getInputStream();
    }

}
