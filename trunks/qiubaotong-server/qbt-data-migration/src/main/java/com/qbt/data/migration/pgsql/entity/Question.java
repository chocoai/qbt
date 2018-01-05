package com.qbt.data.migration.pgsql.entity;

public class Question {
    private Integer id;

    private Long research_id;

    private Integer type;

    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getResearch_id() {
        return research_id;
    }

    public void setResearch_id(Long research_id) {
        this.research_id = research_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}