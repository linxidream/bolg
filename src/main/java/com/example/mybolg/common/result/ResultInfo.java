package com.example.mybolg.common.result;

import org.apache.commons.lang3.StringUtils;

public class ResultInfo {

    private String mark;
    private String tip;
    private Object obj;

    public ResultInfo() {
    }
    public ResultInfo(String mark,String tip) {
        this.setMark(mark);
        this.setTip(tip);
    }
    public ResultInfo(String mark,String tip,Object obj) {
        this.setMark(mark);
        this.setTip(tip);
        this.setObj(obj);
    }
    /**
     * @param mark
     * 设置返回码（0：成功   1：服务端异常  -1：客户端异常   -2：不知名的错误）
     */
    private void setMark(String mark) {
        this.mark = mark;
    }
    /**
     * @param tip
     * 设置返回提示文本
     */
    private void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * @param obj
     * 设置返回对象
     */
    private void setObj(Object obj) {
        this.obj=obj;
    }

    public static void setSuccessInfo(ResultInfo resultInfo,Object obj){
        resultInfo.setMark(ResultCode.SUCCESS);
        resultInfo.setTip(ResultCode.SUCCESS_MSG_CN);
        resultInfo.setObj(obj);
    }
    public static void setClientErrorInfo(ResultInfo resultInfo,String tip){
        resultInfo.setMark(ResultCode.CLIENT_ERROR);
        if(StringUtils.isBlank(tip)){
            resultInfo.setTip(ResultCode.CLIENT_ERROR_MSG_CN);
        }else{
            resultInfo.setTip(tip);
        }
    }
    public static void setServerErrorInfo(ResultInfo resultInfo,String tip){
        resultInfo.setMark(ResultCode.SERVER_ERROR);
        if(StringUtils.isBlank(tip)){
            resultInfo.setTip(ResultCode.SERVER_ERROR_MSG_CN);
        }else{
            resultInfo.setTip(tip);
        }
    }
    public static void setUnknowErrorInfo(ResultInfo resultInfo,String mark,String tip){
        resultInfo.setMark(mark);
        resultInfo.setTip(tip);
    }

    public String getMark() {
        return mark;
    }

    public String getTip() {
        return tip;
    }

    public Object getObj() {
        return obj;
    }


    public static class ResultCode {
        public static final String SUCCESS = "0";
        public static final String SERVER_ERROR = "1";
        public static final String CLIENT_ERROR = "-1";
        public static final String UNKNOW_ERROR = "-2";

        public static final String SUCCESS_MSG_EN = "SUCCESS";
        public static final String SERVER_ERROR_MSG_EN = "Oops! the internet is abducted by aliens";
        public static final String CLIENT_ERROR_MSG_EN = "Client Error";
        public static final String UNKNOW_ERROR_MSG_EN = "Unknow Error";


        public static final String SUCCESS_MSG_CN = "成功";
        public static final String SERVER_ERROR_MSG_CN = "服务端错误";
        public static final String CLIENT_ERROR_MSG_CN = "客户端错误";
        public static final String UNKNOW_ERROR_MSG_CN = "不知名的错误";

        /**
         * 需要用户重新登录
         */
        public static final String NONE_TOKEN = "100";
        public static final String NONE_TOKEN_MSG_CN = "请重新登录";
        public static final String NONE_TOKEN_MSG_EN = "Please log in again!";
    }
}
