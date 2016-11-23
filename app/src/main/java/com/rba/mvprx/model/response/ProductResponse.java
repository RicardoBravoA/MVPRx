package com.rba.mvprx.model.response;

import java.util.List;

/**
 * Created by Ricardo Bravo on 21/11/16.
 */


public class ProductResponse {

    /**
     * _meta : {"status":"success","code":"200"}
     * data : [{"product_id":1,"description":"Product 1","price":"1.00","brand_id":1,"category_id":1,"latitude":"","longitude":"","image":"https://alicarnold.files.wordpress.com/2009/11/new-product.jpg","outstanding":1},{"product_id":2,"description":"Product 2","price":"2.00","brand_id":1,"category_id":2,"latitude":"","longitude":"","image":"http://mcdbros.ie/wp-content/uploads/2012/12/new-product.png","outstanding":1},{"product_id":3,"description":"Product 3","price":"3.00","brand_id":2,"category_id":1,"latitude":"","longitude":"","image":"http://2.bp.blogspot.com/-xC6bhbtfkU4/Vg3lGWA1doI/AAAAAAAAABY/AwePpj6TuTc/s1600/produk%2Bapa%2Byang%2Bakan%2Bdibeli%2Boleh%2Ballah%2B-%2Bhaspray.png","outstanding":1},{"product_id":4,"description":"Product 4","price":"4.00","brand_id":2,"category_id":2,"latitude":"","longitude":"","image":"http://www.techcounsellor.com/img/work/approach/p.png","outstanding":1},{"product_id":5,"description":"Product 5","price":"5.00","brand_id":1,"category_id":1,"latitude":"","longitude":"","image":"http://dabketna.com/wp-content/uploads/2014/10/New_product.jpg","outstanding":0},{"product_id":6,"description":"Product 6","price":"6.00","brand_id":2,"category_id":2,"latitude":"","longitude":"","image":"https://index.tnwcdn.com/images/8983580c647b9bc0fdde5352f2980975f33552ea.png","outstanding":0},{"product_id":7,"description":"Product 7","price":"5.00","brand_id":1,"category_id":1,"latitude":"","longitude":"","image":"http://www.sr-research.com/images/New-sticker.png","outstanding":1},{"product_id":8,"description":"Product 8","price":"8.00","brand_id":2,"category_id":2,"latitude":"","longitude":"","image":"http://www.hcgdropblogs.com/product_images/uploaded_images/mbg.png","outstanding":1},{"product_id":9,"description":"Product 9","price":"9.00","brand_id":1,"category_id":1,"latitude":"1","longitude":"1","image":"http://www.honeybeardeodorant.com/wp-content/uploads/2015/05/New-Product.jpg","outstanding":1},{"product_id":10,"description":"Product 10","price":"10.50","brand_id":3,"category_id":1,"latitude":"1","longitude":"1","image":"https://www.arxan.com/wp-content/uploads/assets1/images/demo.png","outstanding":1}]
     */

    private MetaBean _meta;
    private List<DataBean> data;

    public MetaBean get_meta() {
        return _meta;
    }

    public void set_meta(MetaBean _meta) {
        this._meta = _meta;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class MetaBean {
        /**
         * status : success
         * code : 200
         */

        private String status;
        private String code;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class DataBean {
        /**
         * product_id : 1
         * description : Product 1
         * price : 1.00
         * brand_id : 1
         * category_id : 1
         * latitude :
         * longitude :
         * image : https://alicarnold.files.wordpress.com/2009/11/new-product.jpg
         * outstanding : 1
         */

        private int product_id;
        private String description;
        private String price;
        private int brand_id;
        private int category_id;
        private String latitude;
        private String longitude;
        private String image;
        private int outstanding;

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getBrand_id() {
            return brand_id;
        }

        public void setBrand_id(int brand_id) {
            this.brand_id = brand_id;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getOutstanding() {
            return outstanding;
        }

        public void setOutstanding(int outstanding) {
            this.outstanding = outstanding;
        }
    }
}
