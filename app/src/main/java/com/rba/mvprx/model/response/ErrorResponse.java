package com.rba.mvprx.model.response;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public class ErrorResponse {

    /**
     * status : error
     * code : 101
     */

    private String status;
    private String code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
