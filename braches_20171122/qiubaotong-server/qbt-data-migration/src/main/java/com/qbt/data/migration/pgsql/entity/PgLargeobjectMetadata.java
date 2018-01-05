package com.qbt.data.migration.pgsql.entity;

public class PgLargeobjectMetadata {
    private Long lomowner;

    private Object lomacl;

    public Long getLomowner() {
        return lomowner;
    }

    public void setLomowner(Long lomowner) {
        this.lomowner = lomowner;
    }

    public Object getLomacl() {
        return lomacl;
    }

    public void setLomacl(Object lomacl) {
        this.lomacl = lomacl;
    }
}