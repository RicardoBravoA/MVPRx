package com.rba.mvprx.login;

import android.util.Log;

import com.rba.mvprx.R;
import com.rba.mvprx.api.client.NetworkError;
import com.rba.mvprx.app.MVPRxApplication;
import com.rba.mvprx.model.response.LoginResponse;
import com.rba.mvprx.storage.SessionManager;
import com.rba.mvprx.util.Constant;

import java.util.Map;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public class LoginPresenter implements LoginCallback {

    private LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }

    public void login(Map<String, String> data) {
        loginView.showProgress();
        LoginInteractor.login(data, this);
    }


    @Override
    public void onResponse(LoginResponse loginResponse) {
        if(loginResponse.get_meta().getStatus().equals(Constant.KEY_SUCCESS)){
            SessionManager.addSession(MVPRxApplication.getAppContext(),
                    loginResponse.getData().get(0));
            loginView.hideProgress();
            loginView.nextActivity();
        }else{
            loginView.showErrorMessage(MVPRxApplication.getAppContext().getString(R.string.message_login));
        }
    }

    @Override
    public void onFailure(NetworkError networkError) {
        Log.i("x- onError", networkError.getAppErrorMessage());
        loginView.showErrorMessage(networkError.getAppErrorMessage());
    }

}
