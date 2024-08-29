package com.example.entrance_exit.Model.Request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EntranceExitRecordRequest {
    private String status;
    private Long pid;

    public EntranceExitRecordRequest(String status, Long pid, Date startDate, Date endDate, String personalName) {
        this.status = status;
        this.pid = pid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.personalName = personalName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    private Date startDate;
    private Date endDate;
    private String personalName;
}
