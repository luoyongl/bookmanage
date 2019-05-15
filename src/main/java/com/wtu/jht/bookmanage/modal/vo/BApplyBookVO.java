package com.wtu.jht.bookmanage.modal.vo;

import com.wtu.jht.bookmanage.modal.BApplyBook;

import java.io.Serializable;

public class BApplyBookVO extends BApplyBook implements Serializable {

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

    private String college;

    private  String username;

    private Integer chooseId;

    private Integer number;

    private Integer fGrade;

    private String fRemark;


    private String fList;

    private Integer EvaId;

    public String getfBookName() {
        return fBookName;
    }

    public void setfBookName(String fBookName) {
        this.fBookName = fBookName;
    }

    public String getfBookPublish() {
        return fBookPublish;
    }

    public void setfBookPublish(String fBookPublish) {
        this.fBookPublish = fBookPublish;
    }

    public String getfBookIsbn() {
        return fBookIsbn;
    }

    public void setfBookIsbn(String fBookIsbn) {
        this.fBookIsbn = fBookIsbn;
    }

    public String getfBookEditor() {
        return fBookEditor;
    }

    public void setfBookEditor(String fBookEditor) {
        this.fBookEditor = fBookEditor;
    }

    public String getfBookEdtion() {
        return fBookEdtion;
    }

    public void setfBookEdtion(String fBookEdtion) {
        this.fBookEdtion = fBookEdtion;
    }

    public String getfBookPrice() {
        return fBookPrice;
    }

    public void setfBookPrice(String fBookPrice) {
        this.fBookPrice = fBookPrice;
    }

    public String getfBookType() {
        return fBookType;
    }

    public void setfBookType(String fBookType) {
        this.fBookType = fBookType;
    }

    public Boolean getfBookIswrite() {
        return fBookIswrite;
    }

    public void setfBookIswrite(Boolean fBookIswrite) {
        this.fBookIswrite = fBookIswrite;
    }

    public String getfBookNumber() {
        return fBookNumber;
    }

    public void setfBookNumber(String fBookNumber) {
        this.fBookNumber = fBookNumber;
    }

    public Integer getfWriteId() {
        return fWriteId;
    }

    public void setfWriteId(Integer fWriteId) {
        this.fWriteId = fWriteId;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getChooseId() {
        return chooseId;
    }

    public void setChooseId(Integer chooseId) {
        this.chooseId = chooseId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getfGrade() {
        return fGrade;
    }

    public void setfGrade(Integer fGrade) {
        this.fGrade = fGrade;
    }

    @Override
    public String getfRemark() {
        return fRemark;
    }

    @Override
    public void setfRemark(String fRemark) {
        this.fRemark = fRemark;
    }

    public String getfList() {
        return fList;
    }

    public void setfList(String fList) {
        this.fList = fList;
    }

    public Integer getEvaId() {
        return EvaId;
    }

    public void setEvaId(Integer evaId) {
        EvaId = evaId;
    }
}
