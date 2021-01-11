package com.halcyon.file_manage.core;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 统一API响应结果封装
 */
@ApiModel(value = " 通用响应数据结构")
public class Result<T> {
	/**
	SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500);//服务器内部错误
	 */
	
	@ApiModelProperty(value = "请求响应码",example = "200、400、401、404、500") 
    private int code;
	@ApiModelProperty(value = "请求响应信息",example = "SUCCESS、FAIL、UNAUTHORIZED、NOT_FOUND、INTERNAL_SERVER_ERROR") 
    private String message;
	@ApiModelProperty(value = "请求响应内容",example = "[{name：xx，age：11}，{name：oo，age：12}]... ") 
    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
