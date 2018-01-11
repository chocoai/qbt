package com.qbt.common.entity.search;

public class Group {

    // 需要分组的字段
    private String groupField;

    // 是否包含查询的分值
    private boolean isIncludeScore;

    // 每组限制的数量
    private String groupLimit;

    // 是否包含分組的总数
    private boolean isNeedCountGroup;

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public boolean isIncludeScore() {
        return isIncludeScore;
    }

    public void setIncludeScore(boolean isIncludeScore) {
        this.isIncludeScore = isIncludeScore;
    }

    public String getGroupLimit() {
        return groupLimit;
    }

    public void setGroupLimit(String groupLimit) {
        this.groupLimit = groupLimit;
    }

    public boolean isNeedCountGroup() {
        return isNeedCountGroup;
    }

    public void setNeedCountGroup(boolean isNeedCountGroup) {
        this.isNeedCountGroup = isNeedCountGroup;
    }

}
