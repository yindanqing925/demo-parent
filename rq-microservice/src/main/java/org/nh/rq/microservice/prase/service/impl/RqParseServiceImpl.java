package org.nh.rq.microservice.prase.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.nh.rq.microservice.prase.service.RqParseService;
import org.nh.rq.microservice.util.DownloadUtil;
import org.nh.rq.microservice.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @program: RqParseServiceImpl.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/29 11:46
 */
@Service
@Slf4j
public class RqParseServiceImpl implements RqParseService {

    @Value("${file.path}")
    private String filePath;

    @Override
    public String getRoomRqInfo(String roomNo) {
        try {
            log.info("roomNo:{}", roomNo);
            InputStream inputStream = DownloadUtil.downLoadFromUrl(filePath);
            return ExcelUtil.getRoomRqInfo(inputStream, roomNo);
        } catch (Exception ex){
            log.info(ExceptionUtils.getStackTrace(ex));
        }
        return null;
    }
}
