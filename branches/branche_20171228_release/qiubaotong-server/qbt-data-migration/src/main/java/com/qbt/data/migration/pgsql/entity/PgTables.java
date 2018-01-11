package com.qbt.data.migration.pgsql.entity;

public class PgTables {
    private String schemaname;

    private String tablename;

    private String tableowner;

    private String tablespace;

    private Boolean hasindexes;

    private Boolean hasrules;

    private Boolean hastriggers;

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

    public String getTableowner() {
        return tableowner;
    }

    public void setTableowner(String tableowner) {
        this.tableowner = tableowner == null ? null : tableowner.trim();
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(String tablespace) {
        this.tablespace = tablespace == null ? null : tablespace.trim();
    }

    public Boolean getHasindexes() {
        return hasindexes;
    }

    public void setHasindexes(Boolean hasindexes) {
        this.hasindexes = hasindexes;
    }

    public Boolean getHasrules() {
        return hasrules;
    }

    public void setHasrules(Boolean hasrules) {
        this.hasrules = hasrules;
    }

    public Boolean getHastriggers() {
        return hastriggers;
    }

    public void setHastriggers(Boolean hastriggers) {
        this.hastriggers = hastriggers;
    }
}