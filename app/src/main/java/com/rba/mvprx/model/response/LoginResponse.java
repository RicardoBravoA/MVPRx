package com.rba.mvprx.model.response;

import java.util.List;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */

public class LoginResponse {
    /**
     * status : success
     * code : 200
     */

    private MetaEntity _meta;
    /**
     * user_id : 1
     * name : Ricardo
     * lastname : Bravo
     * email : richard90_15@hotmail.com
     */

    private List<DataEntity> data;

    public MetaEntity get_meta() {
        return _meta;
    }

    public void set_meta(MetaEntity _meta) {
        this._meta = _meta;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class MetaEntity {
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

    public static class DataEntity {
        private int user_id;
        private String name;
        private String lastname;
        private String email;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
