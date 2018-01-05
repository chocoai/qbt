package com.qbt.data.migration.pgsql.entity;

public class PgLargeobject {
    private Long loid;

    private Integer pageno;

    private byte[] data;

    public Long getLoid() {
        return loid;
    }

    public void setLoid(Long loid) {
        this.loid = loid;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}