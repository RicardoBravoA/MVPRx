package com.rba.mvprx.login;

import android.util.Log;

import com.rba.mvprx.api.client.DemoApiManager;
import com.rba.mvprx.api.client.NetworkError;
import com.rba.mvprx.model.response.LoginResponse;

import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public class LoginInteractor {

    public static void login(Map<String, String> data, final LoginCallback callback){

        Log.i("x- parameter", data.toString());

        DemoApiManager.apiManager().login(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorResumeNext(new Func1<Throwable, Observable<? extends LoginResponse>>() {
                @Override
                public Observable<? extends LoginResponse> call(Throwable throwable) {
                    return Observable.error(throwable);
                }
            }).subscribe(new Subscriber<LoginResponse>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    callback.onFailure(new NetworkError(e));
                }

                @Override
                public void onNext(LoginResponse loginResponse) {
                    callback.onResponse(loginResponse);
                }
            });

    }

}
