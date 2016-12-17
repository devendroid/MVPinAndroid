package com.devs.mvpinandroid.model.dto;

/**
 * Created by ${Deven} on 17/12/16.
 */

public class RespObj<OBJ> {

    private String respCode;
    private String respMessage;
    private boolean success;
    private OBJ dataObj;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public OBJ getDataObj() {
        return dataObj;
    }

    public void setDataObj(OBJ dataObj) {
        this.dataObj = dataObj;
    }
}
