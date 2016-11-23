package com.rba.mvprx.login;

import com.rba.mvprx.api.client.NetworkError;
import com.rba.mvprx.model.response.LoginResponse;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public interface LoginCallback {

    void onResponse(LoginResponse loginResponse);

    void onFailure(NetworkError networkError);

}
