package com.qbt.data.migration.pgsql.entity;

public class PgViews {
    private String schemaname;

    private String viewname;

    private String viewowner;

    private String definition;

    public String getSchemaname() {
        return schemaname;
    }

    public void setSchemaname(String schemaname) {
        this.schemaname = schemaname == null ? null : schemaname.trim();
    }

    public String getViewname() {
        return viewname;
    }

    public void setViewname(String viewname) {
        this.viewname = viewname == null ? null : viewname.trim();
    }

    public String getViewowner() {
        return viewowner;
    }

    public void setViewowner(String viewowner) {
        this.viewowner = viewowner == null ? null : viewowner.trim();
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition == null ? null : definition.trim();
    }
}