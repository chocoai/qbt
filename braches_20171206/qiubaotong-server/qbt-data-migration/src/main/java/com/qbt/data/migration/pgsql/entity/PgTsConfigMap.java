package com.qbt.data.migration.pgsql.entity;

public class PgTsConfigMap {
    private Long mapcfg;

    private Integer maptokentype;

    private Integer mapseqno;

    private Long mapdict;

    public Long getMapcfg() {
        return mapcfg;
    }

    public void setMapcfg(Long mapcfg) {
        this.mapcfg = mapcfg;
    }

    public Integer getMaptokentype() {
        return maptokentype;
    }

    public void setMaptokentype(Integer maptokentype) {
        this.maptokentype = maptokentype;
    }

    public Integer getMapseqno() {
        return mapseqno;
    }

    public void setMapseqno(Integer mapseqno) {
        this.mapseqno = mapseqno;
    }

    public Long getMapdict() {
        return mapdict;
    }

    public void setMapdict(Long mapdict) {
        this.mapdict = mapdict;
    }
}