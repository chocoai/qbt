package com.qbt.data.migration.pgsql.entity;

public class PgAvailableExtensionVersions {
    private String name;

    private String version;

    private Boolean installed;

    private Boolean superuser;

    private Boolean relocatable;

    private String schema;

    private Object requires;

    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Boolean getInstalled() {
        return installed;
    }

    public void setInstalled(Boolean installed) {
        this.installed = installed;
    }

    public Boolean getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Boolean superuser) {
        this.superuser = superuser;
    }

    public Boolean getRelocatable() {
        return relocatable;
    }

    public void setRelocatable(Boolean relocatable) {
        this.relocatable = relocatable;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema == null ? null : schema.trim();
    }

    public Object getRequires() {
        return requires;
    }

    public void setRequires(Object requires) {
        this.requires = requires;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}