package com.qbt.data.migration.pgsql.entity;

public class PgSettings {
    private String name;

    private String setting;

    private String unit;

    private String category;

    private String short_desc;

    private String extra_desc;

    private String context;

    private String vartype;

    private String source;

    private String min_val;

    private String max_val;

    private Object enumvals;

    private String boot_val;

    private String reset_val;

    private String sourcefile;

    private Integer sourceline;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting == null ? null : setting.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc == null ? null : short_desc.trim();
    }

    public String getExtra_desc() {
        return extra_desc;
    }

    public void setExtra_desc(String extra_desc) {
        this.extra_desc = extra_desc == null ? null : extra_desc.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getVartype() {
        return vartype;
    }

    public void setVartype(String vartype) {
        this.vartype = vartype == null ? null : vartype.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getMin_val() {
        return min_val;
    }

    public void setMin_val(String min_val) {
        this.min_val = min_val == null ? null : min_val.trim();
    }

    public String getMax_val() {
        return max_val;
    }

    public void setMax_val(String max_val) {
        this.max_val = max_val == null ? null : max_val.trim();
    }

    public Object getEnumvals() {
        return enumvals;
    }

    public void setEnumvals(Object enumvals) {
        this.enumvals = enumvals;
    }

    public String getBoot_val() {
        return boot_val;
    }

    public void setBoot_val(String boot_val) {
        this.boot_val = boot_val == null ? null : boot_val.trim();
    }

    public String getReset_val() {
        return reset_val;
    }

    public void setReset_val(String reset_val) {
        this.reset_val = reset_val == null ? null : reset_val.trim();
    }

    public String getSourcefile() {
        return sourcefile;
    }

    public void setSourcefile(String sourcefile) {
        this.sourcefile = sourcefile == null ? null : sourcefile.trim();
    }

    public Integer getSourceline() {
        return sourceline;
    }

    public void setSourceline(Integer sourceline) {
        this.sourceline = sourceline;
    }
}