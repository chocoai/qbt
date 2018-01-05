package com.qbt.data.migration.pgsql.entity;

public class CourseRoutineWork {
    private Integer id;

    private Long course_id;

    private String weather;

    private String activity_info;

    private String promotion_info;

    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getActivity_info() {
        return activity_info;
    }

    public void setActivity_info(String activity_info) {
        this.activity_info = activity_info == null ? null : activity_info.trim();
    }

    public String getPromotion_info() {
        return promotion_info;
    }

    public void setPromotion_info(String promotion_info) {
        this.promotion_info = promotion_info == null ? null : promotion_info.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}