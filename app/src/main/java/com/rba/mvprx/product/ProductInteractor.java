package com.rba.mvprx.product;

import android.util.Log;

import com.google.gson.Gson;
import com.rba.mvprx.api.client.DemoApiManager;
import com.rba.mvprx.api.client.NetworkError;
import com.rba.mvprx.model.response.ErrorResponse;
import com.rba.mvprx.model.response.ProductResponse;
import com.rba.mvprx.util.Util;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Ricardo Bravo on 21/11/16.
 */


public class ProductInteractor {

    public static void product(final ProductCallback callback){

        Log.i("z- ProductInteractor", "product");

        DemoApiManager.apiManager().product()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<?>>() {
                    @Override
                    public Observable<?> call(Throwable throwable) {
                        Log.i("z- onErrorResumeNext", throwable.getMessage());
                        return Observable.error(throwable);
                    }
                }).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                Log.i("z- onCompleted", "true");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("z- onError", new Gson().toJson(e));
                callback.onFailure(new NetworkError(e));
            }

            @Override
            public void onNext(Object object) {
                Log.i("z- onNext", "true");
                Log.i("z- onNext", new Gson().toJson(object));

                if(Util.isError(new Gson().toJson(object))){
                    Log.i("z- instanceof", "ErrorResponse");

                    ErrorResponse errorResponse = new Gson().fromJson(new Gson().toJson(object), ErrorResponse.class);
                    Log.i("z- error", new Gson().toJson(object));
                    callback.onError(errorResponse);

                }else{
                    ProductResponse productResponse = new Gson().fromJson(new Gson().toJson(object), ProductResponse.class);
                    Log.i("z- onResponse", new Gson().toJson(object));
                    callback.onResponse(productResponse);
                }


            }
        });



    }

}
