package com.wtu.jht.bookmanage.modal;

import java.io.Serializable;
import java.util.Date;

public class BBookList implements Serializable {
    private Integer fId;

    private String fBookNumber;

    private String fBookName;

    private String fBookPublish;

    private String fBookIsbn;

    private String fBookEditor;

    private String fBookEdtion;

    private String fBookPrice;

    private String fBookType;

    private Boolean fBookIswrite;

    private Integer fWriteId;

    private String fBookUrl;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private Byte fState;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfBookNumber() {
        return fBookNumber;
    }

    public void setfBookNumber(String fBookNumber) {
        this.fBookNumber = fBookNumber == null ? null : fBookNumber.trim();
    }

    public String getfBookName() {
        return fBookName;
    }

    public void setfBookName(String fBookName) {
        this.fBookName = fBookName == null ? null : fBookName.trim();
    }

    public String getfBookPublish() {
        return fBookPublish;
    }

    public void setfBookPublish(String fBookPublish) {
        this.fBookPublish = fBookPublish == null ? null : fBookPublish.trim();
    }

    public String getfBookIsbn() {
        return fBookIsbn;
    }

    public void setfBookIsbn(String fBookIsbn) {
        this.fBookIsbn = fBookIsbn == null ? null : fBookIsbn.trim();
    }

    public String getfBookEditor() {
        return fBookEditor;
    }

    public void setfBookEditor(String fBookEditor) {
        this.fBookEditor = fBookEditor == null ? null : fBookEditor.trim();
    }

    public String getfBookEdtion() {
        return fBookEdtion;
    }

    public void setfBookEdtion(String fBookEdtion) {
        this.fBookEdtion = fBookEdtion == null ? null : fBookEdtion.trim();
    }

    public String getfBookPrice() {
        return fBookPrice;
    }

    public void setfBookPrice(String fBookPrice) {
        this.fBookPrice = fBookPrice == null ? null : fBookPrice.trim();
    }

    public String getfBookType() {
        return fBookType;
    }

    public void setfBookType(String fBookType) {
        this.fBookType = fBookType == null ? null : fBookType.trim();
    }

    public Boolean getfBookIswrite() {
        return fBookIswrite;
    }

    public void setfBookIswrite(Boolean fBookIswrite) {
        this.fBookIswrite = fBookIswrite;
    }

    public Integer getfWriteId() {
        return fWriteId;
    }

    public void setfWriteId(Integer fWriteId) {
        this.fWriteId = fWriteId;
    }

    public String getfBookUrl() {
        return fBookUrl;
    }

    public void setfBookUrl(String fBookUrl) {
        this.fBookUrl = fBookUrl == null ? null : fBookUrl.trim();
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

    public Byte getfState() {
        return fState;
    }

    public void setfState(Byte fState) {
        this.fState = fState;
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
        BBookList other = (BBookList) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfBookNumber() == null ? other.getfBookNumber() == null : this.getfBookNumber().equals(other.getfBookNumber()))
            && (this.getfBookName() == null ? other.getfBookName() == null : this.getfBookName().equals(other.getfBookName()))
            && (this.getfBookPublish() == null ? other.getfBookPublish() == null : this.getfBookPublish().equals(other.getfBookPublish()))
            && (this.getfBookIsbn() == null ? other.getfBookIsbn() == null : this.getfBookIsbn().equals(other.getfBookIsbn()))
            && (this.getfBookEditor() == null ? other.getfBookEditor() == null : this.getfBookEditor().equals(other.getfBookEditor()))
            && (this.getfBookEdtion() == null ? other.getfBookEdtion() == null : this.getfBookEdtion().equals(other.getfBookEdtion()))
            && (this.getfBookPrice() == null ? other.getfBookPrice() == null : this.getfBookPrice().equals(other.getfBookPrice()))
            && (this.getfBookType() == null ? other.getfBookType() == null : this.getfBookType().equals(other.getfBookType()))
            && (this.getfBookIswrite() == null ? other.getfBookIswrite() == null : this.getfBookIswrite().equals(other.getfBookIswrite()))
            && (this.getfWriteId() == null ? other.getfWriteId() == null : this.getfWriteId().equals(other.getfWriteId()))
            && (this.getfBookUrl() == null ? other.getfBookUrl() == null : this.getfBookUrl().equals(other.getfBookUrl()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()))
            && (this.getfState() == null ? other.getfState() == null : this.getfState().equals(other.getfState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfBookNumber() == null) ? 0 : getfBookNumber().hashCode());
        result = prime * result + ((getfBookName() == null) ? 0 : getfBookName().hashCode());
        result = prime * result + ((getfBookPublish() == null) ? 0 : getfBookPublish().hashCode());
        result = prime * result + ((getfBookIsbn() == null) ? 0 : getfBookIsbn().hashCode());
        result = prime * result + ((getfBookEditor() == null) ? 0 : getfBookEditor().hashCode());
        result = prime * result + ((getfBookEdtion() == null) ? 0 : getfBookEdtion().hashCode());
        result = prime * result + ((getfBookPrice() == null) ? 0 : getfBookPrice().hashCode());
        result = prime * result + ((getfBookType() == null) ? 0 : getfBookType().hashCode());
        result = prime * result + ((getfBookIswrite() == null) ? 0 : getfBookIswrite().hashCode());
        result = prime * result + ((getfWriteId() == null) ? 0 : getfWriteId().hashCode());
        result = prime * result + ((getfBookUrl() == null) ? 0 : getfBookUrl().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        result = prime * result + ((getfState() == null) ? 0 : getfState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fBookNumber=").append(fBookNumber);
        sb.append(", fBookName=").append(fBookName);
        sb.append(", fBookPublish=").append(fBookPublish);
        sb.append(", fBookIsbn=").append(fBookIsbn);
        sb.append(", fBookEditor=").append(fBookEditor);
        sb.append(", fBookEdtion=").append(fBookEdtion);
        sb.append(", fBookPrice=").append(fBookPrice);
        sb.append(", fBookType=").append(fBookType);
        sb.append(", fBookIswrite=").append(fBookIswrite);
        sb.append(", fWriteId=").append(fWriteId);
        sb.append(", fBookUrl=").append(fBookUrl);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", fState=").append(fState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}