package com.rba.mvprx.product;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rba.mvprx.R;
import com.rba.mvprx.model.response.ProductResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo Bravo on 21/11/16.
 */


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductResponse.DataBean> productEntityList;
    static LayoutInflater inflater = null;
    private ProductActivity productActivity;


    public ProductAdapter(ProductActivity productActivity) {
        this.productActivity = productActivity;
        inflater = (LayoutInflater) productActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        productEntityList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ProductResponse.DataBean productDataBean = productEntityList.get(position);
        holder.lblDescription.setText(productDataBean.getDescription());

        Picasso.with(productActivity.getApplicationContext())
                .load(productDataBean.getImage())
                .error(R.drawable.ic_image_not_found)
                .placeholder(R.drawable.ic_image_not_found)
                .resize(300, 300)
                .into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return productEntityList.size();
    }

    public void setProduct(List<ProductResponse.DataBean> productEntityList){
        this.productEntityList.addAll(productEntityList);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgProduct;
        private TextView lblDescription;
        private CardView cvProduct;

        public ViewHolder(View view) {
            super(view);
            lblDescription = (TextView) view.findViewById(R.id.lblDescription);
            cvProduct = (CardView) view.findViewById(R.id.cvProduct);
            imgProduct = (ImageView) view.findViewById(R.id.imgProduct);

            cvProduct.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.cvProduct:
                    productActivity.onProductPressed(productEntityList.get(getAdapterPosition()));
                    break;
                default:
                    break;
            }
        }
    }

}
