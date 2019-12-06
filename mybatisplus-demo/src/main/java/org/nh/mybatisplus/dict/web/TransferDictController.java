package org.nh.mybatisplus.dict.web;


import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import lombok.extern.log4j.Log4j2;
import org.nh.common.web.ResponseResult;
import org.nh.mybatisplus.dict.domain.TransferDict;
import org.nh.mybatisplus.dict.service.TransferDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author yindanqing
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/dict")
@Log4j2
public class TransferDictController {

    @Autowired
    private TransferDictService transferDictService;

    @RequestMapping(value = "/getTransferDictById/{id}", method = RequestMethod.GET)
    public ResponseResult<TransferDict> getTransferDictById(@PathVariable(value = "id") Long id){
        ResponseResult<TransferDict> responseResult = new ResponseResult<>();
        responseResult.setData(transferDictService.selectById(id));
        return responseResult;
    }

    @RequestMapping(value = "/findTransferDic", method = RequestMethod.GET)
    public ResponseResult<Page<TransferDict>> findTransferDic(){
        ResponseResult<Page<TransferDict>> result = new ResponseResult<>();
        //获取前台发送过来的数据
        Page<TransferDict> page = new Page<>(1, 10);
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("dict_key", "SUMMARY_NOTIFY_MEMBER");
        page.setCondition(hashMap);
        result.setData(transferDictService.selectPage(page));
        return result;
    }

    @RequestMapping(value = "/findTransferDic2", method = RequestMethod.GET)
    public ResponseResult<Page<TransferDict>> findTransferDic2(){
        ResponseResult<Page<TransferDict>> result = new ResponseResult<>();
        //获取前台发送过来的数据
        Page<TransferDict> page = new Page<>(2, 10);
        TransferDict dict = new TransferDict();
        dict.setDictKey("SUMMARY_NOTIFY_MEMBER");
        Wrapper<TransferDict> wrapper = new EntityWrapper<>(dict);
        Page<TransferDict> selectPage = transferDictService.selectPage(page, wrapper);
        result.setData(selectPage);
        log.info("所有记录:" + selectPage.getTotal());
        return result;
    }

    @RequestMapping(value = "/findTransferDic3", method = RequestMethod.GET)
    public ResponseResult<Page<TransferDict>> findTransferDic3(){
        ResponseResult<Page<TransferDict>> result = new ResponseResult<>();
        //获取前台发送过来的数据
        Page<TransferDict> page = new Page<>(1, 5);
        Page<TransferDict> dictPage = transferDictService.findDictList(page);
        //获取分页后查询出的记录
        List<TransferDict> records = page.getRecords();
        System.out.println("数据集合："+records.size());
        System.out.println("-----------------------");
        System.out.println("是否有下一页："+page.hasNext());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("-----------------------");
        System.out.println("是否有下一页："+dictPage.hasNext());
        System.out.println("是否有上一页："+dictPage.hasPrevious());
        System.out.println("总记录数："+dictPage.getTotal());
        return result;
    }

}
