package com.qbt.common.entity.search;

public class Facet {

    // 需要Facet的字段
    private String facetField;

    // 每组限制的数量
    private String facetLimit;

    // 至少应该包含几条记录
    private String facetMinCount;

    public String getFacetField() {
        return facetField;
    }

    public void setFacetField(String facetField) {
        this.facetField = facetField;
    }

    public String getFacetLimit() {
        return facetLimit;
    }

    public void setFacetLimit(String facetLimit) {
        this.facetLimit = facetLimit;
    }

    public String getFacetMinCount() {
        return facetMinCount;
    }

    public void setFacetMinCount(String facetMinCount) {
        this.facetMinCount = facetMinCount;
    }

}
