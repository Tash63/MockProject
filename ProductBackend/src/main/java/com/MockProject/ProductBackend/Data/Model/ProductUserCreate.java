package com.MockProject.ProductBackend.Data.Model;

public class ProductUserCreate {
    private Integer UID;
    private Long PID;

    public ProductUserCreate() {
    }

    public ProductUserCreate( Integer UID, Long PID) {
        this.UID = UID;
        this.PID = PID;
    }

    public Integer getUID() {
        return UID;
    }

    public Long getPID() {
        return PID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public void setPID(Long PID) {
        this.PID = PID;
    }
}
