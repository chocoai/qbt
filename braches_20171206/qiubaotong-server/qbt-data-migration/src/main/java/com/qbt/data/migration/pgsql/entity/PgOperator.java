package com.qbt.data.migration.pgsql.entity;

public class PgOperator {
    private String oprname;

    private Long oprnamespace;

    private Long oprowner;

    private String oprkind;

    private Boolean oprcanmerge;

    private Boolean oprcanhash;

    private Long oprleft;

    private Long oprright;

    private Long oprresult;

    private Long oprcom;

    private Long oprnegate;

    private Object oprcode;

    private Object oprrest;

    private Object oprjoin;

    public String getOprname() {
        return oprname;
    }

    public void setOprname(String oprname) {
        this.oprname = oprname == null ? null : oprname.trim();
    }

    public Long getOprnamespace() {
        return oprnamespace;
    }

    public void setOprnamespace(Long oprnamespace) {
        this.oprnamespace = oprnamespace;
    }

    public Long getOprowner() {
        return oprowner;
    }

    public void setOprowner(Long oprowner) {
        this.oprowner = oprowner;
    }

    public String getOprkind() {
        return oprkind;
    }

    public void setOprkind(String oprkind) {
        this.oprkind = oprkind == null ? null : oprkind.trim();
    }

    public Boolean getOprcanmerge() {
        return oprcanmerge;
    }

    public void setOprcanmerge(Boolean oprcanmerge) {
        this.oprcanmerge = oprcanmerge;
    }

    public Boolean getOprcanhash() {
        return oprcanhash;
    }

    public void setOprcanhash(Boolean oprcanhash) {
        this.oprcanhash = oprcanhash;
    }

    public Long getOprleft() {
        return oprleft;
    }

    public void setOprleft(Long oprleft) {
        this.oprleft = oprleft;
    }

    public Long getOprright() {
        return oprright;
    }

    public void setOprright(Long oprright) {
        this.oprright = oprright;
    }

    public Long getOprresult() {
        return oprresult;
    }

    public void setOprresult(Long oprresult) {
        this.oprresult = oprresult;
    }

    public Long getOprcom() {
        return oprcom;
    }

    public void setOprcom(Long oprcom) {
        this.oprcom = oprcom;
    }

    public Long getOprnegate() {
        return oprnegate;
    }

    public void setOprnegate(Long oprnegate) {
        this.oprnegate = oprnegate;
    }

    public Object getOprcode() {
        return oprcode;
    }

    public void setOprcode(Object oprcode) {
        this.oprcode = oprcode;
    }

    public Object getOprrest() {
        return oprrest;
    }

    public void setOprrest(Object oprrest) {
        this.oprrest = oprrest;
    }

    public Object getOprjoin() {
        return oprjoin;
    }

    public void setOprjoin(Object oprjoin) {
        this.oprjoin = oprjoin;
    }
}