package com.rba.mvprx.product;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rba.mvprx.R;
import com.rba.mvprx.model.response.ProductResponse;

import java.util.List;

public class ProductActivity extends AppCompatActivity implements ProductView {

    private RecyclerView rcvProduct;
    private ProductAdapter productAdapter;
    private ProductPresenter productPresenter;
    private View viewLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productPresenter = new ProductPresenter(this);
        rcvProduct = (RecyclerView) findViewById(R.id.rcvProduct);
        viewLoading = findViewById(R.id.viewLoading);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcvProduct.setLayoutManager(layoutManager);
        rcvProduct.setItemAnimator(new DefaultItemAnimator());

        setupRecyclerView();

    }

    @Override
    public void showProgress() {
        viewLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        viewLoading.setVisibility(View.GONE);
    }

    @Override
    public void messageProduct(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProductPressed(ProductResponse.DataBean productDataBean) {
        Toast.makeText(this, productDataBean.getDescription(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProduct(List<ProductResponse.DataBean> productDataBeanList) {
        Log.i("x- showProduct", new Gson().toJson(productDataBeanList));
        /*
        productAdapter.setProduct(productDataBeanList);
        productAdapter.notifyDataSetChanged();
        */

        //ProductAdapter productAdapter = (ProductAdapter) rcvProduct.getAdapter();
        productAdapter.setProduct(productDataBeanList);
        productAdapter.notifyDataSetChanged();

    }

    @Override
    public void setupRecyclerView() {
        Log.i("z- setupRecyclerView", "true");
        productAdapter = new ProductAdapter(this);
        rcvProduct.setAdapter(productAdapter);
        productPresenter.product();
    }
}
