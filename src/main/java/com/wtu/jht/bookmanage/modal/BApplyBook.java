package com.wtu.jht.bookmanage.modal;

import java.io.Serializable;
import java.util.Date;

public class BApplyBook implements Serializable {
    private Integer fId;

    private Integer fUserId;

    private String fBookId;

    private String fApplyYear;

    private String fClass;

    private String fCourseName;

    private String fMajor;

    private String fCourseAttribute;

    private String fRemark;

    private String fState;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfUserId() {
        return fUserId;
    }

    public void setfUserId(Integer fUserId) {
        this.fUserId = fUserId;
    }

    public String getfBookId() {
        return fBookId;
    }

    public void setfBookId(String fBookId) {
        this.fBookId = fBookId == null ? null : fBookId.trim();
    }

    public String getfApplyYear() {
        return fApplyYear;
    }

    public void setfApplyYear(String fApplyYear) {
        this.fApplyYear = fApplyYear == null ? null : fApplyYear.trim();
    }

    public String getfClass() {
        return fClass;
    }

    public void setfClass(String fClass) {
        this.fClass = fClass == null ? null : fClass.trim();
    }

    public String getfCourseName() {
        return fCourseName;
    }

    public void setfCourseName(String fCourseName) {
        this.fCourseName = fCourseName == null ? null : fCourseName.trim();
    }

    public String getfMajor() {
        return fMajor;
    }

    public void setfMajor(String fMajor) {
        this.fMajor = fMajor == null ? null : fMajor.trim();
    }

    public String getfCourseAttribute() {
        return fCourseAttribute;
    }

    public void setfCourseAttribute(String fCourseAttribute) {
        this.fCourseAttribute = fCourseAttribute == null ? null : fCourseAttribute.trim();
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
    }

    public String getfState() {
        return fState;
    }

    public void setfState(String fState) {
        this.fState = fState == null ? null : fState.trim();
    }

    public Integer getfCreatorId() {
        return fCreatorId;
    }

    public void setfCreatorId(Integer fCreatorId) {
        this.fCreatorId = fCreatorId;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public Integer getfOperatorId() {
        return fOperatorId;
    }

    public void setfOperatorId(Integer fOperatorId) {
        this.fOperatorId = fOperatorId;
    }

    public Boolean getfDeleteFlag() {
        return fDeleteFlag;
    }

    public void setfDeleteFlag(Boolean fDeleteFlag) {
        this.fDeleteFlag = fDeleteFlag;
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
        BApplyBook other = (BApplyBook) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfUserId() == null ? other.getfUserId() == null : this.getfUserId().equals(other.getfUserId()))
            && (this.getfBookId() == null ? other.getfBookId() == null : this.getfBookId().equals(other.getfBookId()))
            && (this.getfApplyYear() == null ? other.getfApplyYear() == null : this.getfApplyYear().equals(other.getfApplyYear()))
            && (this.getfClass() == null ? other.getfClass() == null : this.getfClass().equals(other.getfClass()))
            && (this.getfCourseName() == null ? other.getfCourseName() == null : this.getfCourseName().equals(other.getfCourseName()))
            && (this.getfMajor() == null ? other.getfMajor() == null : this.getfMajor().equals(other.getfMajor()))
            && (this.getfCourseAttribute() == null ? other.getfCourseAttribute() == null : this.getfCourseAttribute().equals(other.getfCourseAttribute()))
            && (this.getfRemark() == null ? other.getfRemark() == null : this.getfRemark().equals(other.getfRemark()))
            && (this.getfState() == null ? other.getfState() == null : this.getfState().equals(other.getfState()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfUserId() == null) ? 0 : getfUserId().hashCode());
        result = prime * result + ((getfBookId() == null) ? 0 : getfBookId().hashCode());
        result = prime * result + ((getfApplyYear() == null) ? 0 : getfApplyYear().hashCode());
        result = prime * result + ((getfClass() == null) ? 0 : getfClass().hashCode());
        result = prime * result + ((getfCourseName() == null) ? 0 : getfCourseName().hashCode());
        result = prime * result + ((getfMajor() == null) ? 0 : getfMajor().hashCode());
        result = prime * result + ((getfCourseAttribute() == null) ? 0 : getfCourseAttribute().hashCode());
        result = prime * result + ((getfRemark() == null) ? 0 : getfRemark().hashCode());
        result = prime * result + ((getfState() == null) ? 0 : getfState().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fUserId=").append(fUserId);
        sb.append(", fBookId=").append(fBookId);
        sb.append(", fApplyYear=").append(fApplyYear);
        sb.append(", fClass=").append(fClass);
        sb.append(", fCourseName=").append(fCourseName);
        sb.append(", fMajor=").append(fMajor);
        sb.append(", fCourseAttribute=").append(fCourseAttribute);
        sb.append(", fRemark=").append(fRemark);
        sb.append(", fState=").append(fState);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}