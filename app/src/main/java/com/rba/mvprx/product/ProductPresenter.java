package com.rba.mvprx.product;

import android.util.Log;

import com.google.gson.Gson;
import com.rba.mvprx.api.client.NetworkError;
import com.rba.mvprx.model.response.ErrorResponse;
import com.rba.mvprx.model.response.ProductResponse;

/**
 * Created by Ricardo Bravo on 21/11/16.
 */


public class ProductPresenter implements ProductCallback {

    private ProductView productView;

    public ProductPresenter(ProductView productView){
        this.productView = productView;
    }

    public void product(){
        productView.showProgress();
        Log.i("z- ProductPresenter", "true");
        ProductInteractor.product(this);
    }

    @Override
    public void onError(ErrorResponse errorResponse) {
        Log.i("z- onError PP", new Gson().toJson(errorResponse));
        productView.hideProgress();
        productView.messageProduct(errorResponse.getStatus());
    }

    @Override
    public void onResponse(ProductResponse productResponse) {
        Log.i("z- onResponse PP", new Gson().toJson(productResponse));
        productView.hideProgress();
        productView.showProduct(productResponse.getData());
    }

    @Override
    public void onFailure(NetworkError error) {
        Log.i("z- onFailure PP", new Gson().toJson(error));
        productView.hideProgress();
        productView.messageProduct(error.getAppErrorMessage());
    }

}
