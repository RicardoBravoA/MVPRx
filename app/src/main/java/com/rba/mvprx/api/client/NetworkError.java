package com.rba.mvprx.api.client;

import com.rba.mvprx.util.Constant;

import java.io.IOException;

/**
 * Created by Ricardo Bravo on 22/11/16.
 */


public class NetworkError extends Throwable {

    private final Throwable error;

    public NetworkError(Throwable e) {
        super(e);
        this.error = e;
    }

    public String getMessage() {
        return error.getMessage();
    }

    public String getAppErrorMessage() {
        if (this.error instanceof IOException) {
            return Constant.NETWORK_ERROR_MESSAGE;
        }

        return Constant.DEFAULT_ERROR_MESSAGE;
    }

    public Throwable getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NetworkError that = (NetworkError) o;

        return error != null ? error.equals(that.error) : that.error == null;

    }

    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }
}
