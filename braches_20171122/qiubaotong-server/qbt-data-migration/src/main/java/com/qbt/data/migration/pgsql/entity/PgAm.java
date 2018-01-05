package com.qbt.data.migration.pgsql.entity;

public class PgAm {
    private String amname;

    private Short amstrategies;

    private Short amsupport;

    private Boolean amcanorder;

    private Boolean amcanorderbyop;

    private Boolean amcanbackward;

    private Boolean amcanunique;

    private Boolean amcanmulticol;

    private Boolean amoptionalkey;

    private Boolean amsearcharray;

    private Boolean amsearchnulls;

    private Boolean amstorage;

    private Boolean amclusterable;

    private Boolean ampredlocks;

    private Long amkeytype;

    private Object aminsert;

    private Object ambeginscan;

    private Object amgettuple;

    private Object amgetbitmap;

    private Object amrescan;

    private Object amendscan;

    private Object ammarkpos;

    private Object amrestrpos;

    private Object ambuild;

    private Object ambuildempty;

    private Object ambulkdelete;

    private Object amvacuumcleanup;

    private Object amcanreturn;

    private Object amcostestimate;

    private Object amoptions;

    public String getAmname() {
        return amname;
    }

    public void setAmname(String amname) {
        this.amname = amname == null ? null : amname.trim();
    }

    public Short getAmstrategies() {
        return amstrategies;
    }

    public void setAmstrategies(Short amstrategies) {
        this.amstrategies = amstrategies;
    }

    public Short getAmsupport() {
        return amsupport;
    }

    public void setAmsupport(Short amsupport) {
        this.amsupport = amsupport;
    }

    public Boolean getAmcanorder() {
        return amcanorder;
    }

    public void setAmcanorder(Boolean amcanorder) {
        this.amcanorder = amcanorder;
    }

    public Boolean getAmcanorderbyop() {
        return amcanorderbyop;
    }

    public void setAmcanorderbyop(Boolean amcanorderbyop) {
        this.amcanorderbyop = amcanorderbyop;
    }

    public Boolean getAmcanbackward() {
        return amcanbackward;
    }

    public void setAmcanbackward(Boolean amcanbackward) {
        this.amcanbackward = amcanbackward;
    }

    public Boolean getAmcanunique() {
        return amcanunique;
    }

    public void setAmcanunique(Boolean amcanunique) {
        this.amcanunique = amcanunique;
    }

    public Boolean getAmcanmulticol() {
        return amcanmulticol;
    }

    public void setAmcanmulticol(Boolean amcanmulticol) {
        this.amcanmulticol = amcanmulticol;
    }

    public Boolean getAmoptionalkey() {
        return amoptionalkey;
    }

    public void setAmoptionalkey(Boolean amoptionalkey) {
        this.amoptionalkey = amoptionalkey;
    }

    public Boolean getAmsearcharray() {
        return amsearcharray;
    }

    public void setAmsearcharray(Boolean amsearcharray) {
        this.amsearcharray = amsearcharray;
    }

    public Boolean getAmsearchnulls() {
        return amsearchnulls;
    }

    public void setAmsearchnulls(Boolean amsearchnulls) {
        this.amsearchnulls = amsearchnulls;
    }

    public Boolean getAmstorage() {
        return amstorage;
    }

    public void setAmstorage(Boolean amstorage) {
        this.amstorage = amstorage;
    }

    public Boolean getAmclusterable() {
        return amclusterable;
    }

    public void setAmclusterable(Boolean amclusterable) {
        this.amclusterable = amclusterable;
    }

    public Boolean getAmpredlocks() {
        return ampredlocks;
    }

    public void setAmpredlocks(Boolean ampredlocks) {
        this.ampredlocks = ampredlocks;
    }

    public Long getAmkeytype() {
        return amkeytype;
    }

    public void setAmkeytype(Long amkeytype) {
        this.amkeytype = amkeytype;
    }

    public Object getAminsert() {
        return aminsert;
    }

    public void setAminsert(Object aminsert) {
        this.aminsert = aminsert;
    }

    public Object getAmbeginscan() {
        return ambeginscan;
    }

    public void setAmbeginscan(Object ambeginscan) {
        this.ambeginscan = ambeginscan;
    }

    public Object getAmgettuple() {
        return amgettuple;
    }

    public void setAmgettuple(Object amgettuple) {
        this.amgettuple = amgettuple;
    }

    public Object getAmgetbitmap() {
        return amgetbitmap;
    }

    public void setAmgetbitmap(Object amgetbitmap) {
        this.amgetbitmap = amgetbitmap;
    }

    public Object getAmrescan() {
        return amrescan;
    }

    public void setAmrescan(Object amrescan) {
        this.amrescan = amrescan;
    }

    public Object getAmendscan() {
        return amendscan;
    }

    public void setAmendscan(Object amendscan) {
        this.amendscan = amendscan;
    }

    public Object getAmmarkpos() {
        return ammarkpos;
    }

    public void setAmmarkpos(Object ammarkpos) {
        this.ammarkpos = ammarkpos;
    }

    public Object getAmrestrpos() {
        return amrestrpos;
    }

    public void setAmrestrpos(Object amrestrpos) {
        this.amrestrpos = amrestrpos;
    }

    public Object getAmbuild() {
        return ambuild;
    }

    public void setAmbuild(Object ambuild) {
        this.ambuild = ambuild;
    }

    public Object getAmbuildempty() {
        return ambuildempty;
    }

    public void setAmbuildempty(Object ambuildempty) {
        this.ambuildempty = ambuildempty;
    }

    public Object getAmbulkdelete() {
        return ambulkdelete;
    }

    public void setAmbulkdelete(Object ambulkdelete) {
        this.ambulkdelete = ambulkdelete;
    }

    public Object getAmvacuumcleanup() {
        return amvacuumcleanup;
    }

    public void setAmvacuumcleanup(Object amvacuumcleanup) {
        this.amvacuumcleanup = amvacuumcleanup;
    }

    public Object getAmcanreturn() {
        return amcanreturn;
    }

    public void setAmcanreturn(Object amcanreturn) {
        this.amcanreturn = amcanreturn;
    }

    public Object getAmcostestimate() {
        return amcostestimate;
    }

    public void setAmcostestimate(Object amcostestimate) {
        this.amcostestimate = amcostestimate;
    }

    public Object getAmoptions() {
        return amoptions;
    }

    public void setAmoptions(Object amoptions) {
        this.amoptions = amoptions;
    }
}