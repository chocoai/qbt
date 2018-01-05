package com.qbt.data.migration.pgsql.entity;

public class PgAggregate {
    private Object aggfnoid;

    private Object aggtransfn;

    private Object aggfinalfn;

    private Long aggsortop;

    private Long aggtranstype;

    private String agginitval;

    public Object getAggfnoid() {
        return aggfnoid;
    }

    public void setAggfnoid(Object aggfnoid) {
        this.aggfnoid = aggfnoid;
    }

    public Object getAggtransfn() {
        return aggtransfn;
    }

    public void setAggtransfn(Object aggtransfn) {
        this.aggtransfn = aggtransfn;
    }

    public Object getAggfinalfn() {
        return aggfinalfn;
    }

    public void setAggfinalfn(Object aggfinalfn) {
        this.aggfinalfn = aggfinalfn;
    }

    public Long getAggsortop() {
        return aggsortop;
    }

    public void setAggsortop(Long aggsortop) {
        this.aggsortop = aggsortop;
    }

    public Long getAggtranstype() {
        return aggtranstype;
    }

    public void setAggtranstype(Long aggtranstype) {
        this.aggtranstype = aggtranstype;
    }

    public String getAgginitval() {
        return agginitval;
    }

    public void setAgginitval(String agginitval) {
        this.agginitval = agginitval == null ? null : agginitval.trim();
    }
}