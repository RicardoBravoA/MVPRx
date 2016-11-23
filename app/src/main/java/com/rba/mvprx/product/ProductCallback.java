package com.rba.mvprx.product;

import com.rba.mvprx.api.client.NetworkError;
import com.rba.mvprx.model.response.ErrorResponse;
import com.rba.mvprx.model.response.ProductResponse;

/**
 * Created by Ricardo Bravo on 21/11/16.
 */


public interface ProductCallback {

    void onResponse(ProductResponse productResponse);

    void onError(ErrorResponse errorResponse);

    void onFailure(NetworkError error);

}
