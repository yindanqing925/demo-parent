package org.nh.demo.common.web;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.StringUtils;
import org.nh.demo.common.exception.BusinessException;

import java.io.Serializable;

/**
 * 接口统一返参类型
 * @param <T>
 */
public class ResponseResult<T> implements Serializable {

	private static final long serialVersionUID = -1917760115313349704L;

	public static final int CODE_OK = 1;
	public static final int CODE_ERROR = 10000;

	//接口状态码：200成功其他失败
	private int code = 200;
	//业务状态码：1：成功，10000：服务器内部错误，其他状态见接口说明
	private int subCode = ResponseResult.CODE_OK;
	//业务消息：成功为空字符串
	private String subMessage = StringUtils.EMPTY;
	//业务对象
	private T data;
	//时间戳
	private long timestamp;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setData(T data) {
		this.data = data;
	}

	@JsonIgnore
	public T getDataWithException() {
		if(subCode != ResponseResult.CODE_OK){
			throw new BusinessException(subCode, subMessage);
		}
		return data;
	}

	public T getData() {
		return data;
	}
	
	public int getSubCode() {
		return subCode;
	}

	public void setSubCode(int subCode) {
		this.subCode = subCode;
	}

	public String getSubMessage() {
		return subMessage;
	}

	public void setSubMessage(String subMessage) {
		this.subMessage = subMessage;
	}

	public long getTimestamp() {
		long millis = System.currentTimeMillis();
		if (timestamp == 0) {
			timestamp = millis;
		}
		return timestamp;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}


	public ResponseResult() {
		new ResponseResult(1);
	}

	public ResponseResult(int subCode) {
		this.subCode = subCode;
		this.timestamp = System.currentTimeMillis();
	}

	public ResponseResult(T data) {
		this.data = data;
	}

}
