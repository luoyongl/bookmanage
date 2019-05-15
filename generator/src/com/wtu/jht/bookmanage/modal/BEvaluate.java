package com.wtu.jht.bookmanage.modal;

import java.io.Serializable;
import java.util.Date;

public class BEvaluate implements Serializable {
    private Integer fId;

    private Integer fBookId;

    private Integer fGrade;

    private String fRemark;

    private Integer fUserId;

    private String fList;

    private Date fCreateTime;

    private Date fUpdateTime;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfBookId() {
        return fBookId;
    }

    public void setfBookId(Integer fBookId) {
        this.fBookId = fBookId;
    }

    public Integer getfGrade() {
        return fGrade;
    }

    public void setfGrade(Integer fGrade) {
        this.fGrade = fGrade;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
    }

    public Integer getfUserId() {
        return fUserId;
    }

    public void setfUserId(Integer fUserId) {
        this.fUserId = fUserId;
    }

    public String getfList() {
        return fList;
    }

    public void setfList(String fList) {
        this.fList = fList == null ? null : fList.trim();
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BEvaluate other = (BEvaluate) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfBookId() == null ? other.getfBookId() == null : this.getfBookId().equals(other.getfBookId()))
            && (this.getfGrade() == null ? other.getfGrade() == null : this.getfGrade().equals(other.getfGrade()))
            && (this.getfRemark() == null ? other.getfRemark() == null : this.getfRemark().equals(other.getfRemark()))
            && (this.getfUserId() == null ? other.getfUserId() == null : this.getfUserId().equals(other.getfUserId()))
            && (this.getfList() == null ? other.getfList() == null : this.getfList().equals(other.getfList()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfBookId() == null) ? 0 : getfBookId().hashCode());
        result = prime * result + ((getfGrade() == null) ? 0 : getfGrade().hashCode());
        result = prime * result + ((getfRemark() == null) ? 0 : getfRemark().hashCode());
        result = prime * result + ((getfUserId() == null) ? 0 : getfUserId().hashCode());
        result = prime * result + ((getfList() == null) ? 0 : getfList().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fBookId=").append(fBookId);
        sb.append(", fGrade=").append(fGrade);
        sb.append(", fRemark=").append(fRemark);
        sb.append(", fUserId=").append(fUserId);
        sb.append(", fList=").append(fList);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}