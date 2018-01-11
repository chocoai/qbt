package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgPreparedStatements {
    private String name;

    private String statement;

    private Date prepare_time;

    private Object parameter_types;

    private Boolean from_sql;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
    }

    public Date getPrepare_time() {
        return prepare_time;
    }

    public void setPrepare_time(Date prepare_time) {
        this.prepare_time = prepare_time;
    }

    public Object getParameter_types() {
        return parameter_types;
    }

    public void setParameter_types(Object parameter_types) {
        this.parameter_types = parameter_types;
    }

    public Boolean getFrom_sql() {
        return from_sql;
    }

    public void setFrom_sql(Boolean from_sql) {
        this.from_sql = from_sql;
    }
}