package com.never.left.utils;


import java.util.Objects;

/**
 * @author dong.zhang
 * @description
 * @date 2022/11/9 1:30
 */
//@ApiModel("统一返回格式")
public class ResultVo<T> {
    private static final int SUCCESS_STATUS = 1;
    private static final String SUCCESS_MESSAGE = "success";
    //@ApiModelProperty("状态码，1：成功")
    private Integer code;
    //@ApiModelProperty("提示信息")
    private String msg;
    //@ApiModelProperty("返回数据，泛型")
    private T data;
    //@ApiModelProperty("拓展信息")
    private Object extra;

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo(Integer code, String msg, T data, Object extra) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.extra = extra;
    }

    public static ResultVo getSuccess() {
        return new ResultVo(1, "success");
    }

    public static <T> ResultVo getSuccess(T data) {
        return new ResultVo(1, "success", data);
    }

    public static <T> ResultVo getSuccess(T data, Object extra) {
        return new ResultVo(1, "success", data, extra);
    }

    public static boolean checkSuccess(ResultVo resultVo) {
        return resultVo != null && resultVo.isSuccess();
    }

    public boolean isSuccess() {
        return Objects.equals(this.code, 1);
    }

    public static ResultVo getSystemError() {
        return new ResultVo(9999, "system server error");
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public ResultVo() {
    }
}
