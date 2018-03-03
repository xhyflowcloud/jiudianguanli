package com.ccnu.xiahongyun.stmanagementsystem.model;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;

public class ResponseData{
    private Object data;
    private Integer status;

    private ResponseData() {
    }

    public Integer getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public static class Builder{
        private ResponseData responseData;

        public Builder(){
            responseData = new ResponseData();
        }

        public Builder status(Integer status){
            responseData.status = status;
            return this;
        }
        public Builder data(Object data){
            responseData.data = data;
            return this;
        }

        public ResponseData build() {
            return responseData;
        }
        public ResponseData buildFailureResponse(){
            if (responseData == null) {
                responseData = new ResponseData();
            }
            responseData.status = XHttpStatus.HTTP_EXCEPTION.getCode();
            responseData.data = XHttpStatus.HTTP_EXCEPTION.getMessage();
            return responseData;
        }
    }
}
