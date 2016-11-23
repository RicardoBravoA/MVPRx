package com.rba.mvprx.api.client;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ricardo Bravo on 22/11/16.
 */


public class Response {
    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "used by Retrofit"})
    public Response() {
    }

    public Response(String status) {
        this.status = status;
    }
}
