package com.qbt.data.migration.pgsql.entity;

public class PgStats {
    private String schemaname;

    private String tablename;

    private String attname;

    private Boolean inherited;

    private Float null_frac;

    private Integer avg_width;

    private Float n_distinct;

    private Object most_common_vals;

    private Object most_common_freqs;

    private Object histogram_bounds;

    private Float correlation;

    private Object most_common_elems;

    private Object most_common_elem_freqs;

    private Object elem_count_histogram;

    public String getSchemaname() {
        return schemaname;
    }

    public void setSchemaname(String schemaname) {
        this.schemaname = schemaname == null ? null : schemaname.trim();
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname == null ? null : attname.trim();
    }

    public Boolean getInherited() {
        return inherited;
    }

    public void setInherited(Boolean inherited) {
        this.inherited = inherited;
    }

    public Float getNull_frac() {
        return null_frac;
    }

    public void setNull_frac(Float null_frac) {
        this.null_frac = null_frac;
    }

    public Integer getAvg_width() {
        return avg_width;
    }

    public void setAvg_width(Integer avg_width) {
        this.avg_width = avg_width;
    }

    public Float getN_distinct() {
        return n_distinct;
    }

    public void setN_distinct(Float n_distinct) {
        this.n_distinct = n_distinct;
    }

    public Object getMost_common_vals() {
        return most_common_vals;
    }

    public void setMost_common_vals(Object most_common_vals) {
        this.most_common_vals = most_common_vals;
    }

    public Object getMost_common_freqs() {
        return most_common_freqs;
    }

    public void setMost_common_freqs(Object most_common_freqs) {
        this.most_common_freqs = most_common_freqs;
    }

    public Object getHistogram_bounds() {
        return histogram_bounds;
    }

    public void setHistogram_bounds(Object histogram_bounds) {
        this.histogram_bounds = histogram_bounds;
    }

    public Float getCorrelation() {
        return correlation;
    }

    public void setCorrelation(Float correlation) {
        this.correlation = correlation;
    }

    public Object getMost_common_elems() {
        return most_common_elems;
    }

    public void setMost_common_elems(Object most_common_elems) {
        this.most_common_elems = most_common_elems;
    }

    public Object getMost_common_elem_freqs() {
        return most_common_elem_freqs;
    }

    public void setMost_common_elem_freqs(Object most_common_elem_freqs) {
        this.most_common_elem_freqs = most_common_elem_freqs;
    }

    public Object getElem_count_histogram() {
        return elem_count_histogram;
    }

    public void setElem_count_histogram(Object elem_count_histogram) {
        this.elem_count_histogram = elem_count_histogram;
    }
}