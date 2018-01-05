package com.qbt.data.migration.pgsql.entity;

public class SqlFeatures {
    private Object feature_id;

    private Object feature_name;

    private Object sub_feature_id;

    private Object sub_feature_name;

    private Object is_supported;

    private Object is_verified_by;

    private Object comments;

    public Object getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(Object feature_id) {
        this.feature_id = feature_id;
    }

    public Object getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(Object feature_name) {
        this.feature_name = feature_name;
    }

    public Object getSub_feature_id() {
        return sub_feature_id;
    }

    public void setSub_feature_id(Object sub_feature_id) {
        this.sub_feature_id = sub_feature_id;
    }

    public Object getSub_feature_name() {
        return sub_feature_name;
    }

    public void setSub_feature_name(Object sub_feature_name) {
        this.sub_feature_name = sub_feature_name;
    }

    public Object getIs_supported() {
        return is_supported;
    }

    public void setIs_supported(Object is_supported) {
        this.is_supported = is_supported;
    }

    public Object getIs_verified_by() {
        return is_verified_by;
    }

    public void setIs_verified_by(Object is_verified_by) {
        this.is_verified_by = is_verified_by;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }
}