package com.wtu.jht.bookmanage.modal.vo;

import com.wtu.jht.bookmanage.modal.BResponsitory;

/**
 * @date ：Created in 2019/5/15 11:41
 * @description：
 * @modified By：
 * @version: $
 */
public class BResponsitoryVO extends BResponsitory {

    private String fBookName;

    private String fBookPublish;

    private String fBookEditor;

    private String fBookPrice;

    private Boolean fBookIswrite;

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

    public String getfBookEditor() {
        return fBookEditor;
    }

    public void setfBookEditor(String fBookEditor) {
        this.fBookEditor = fBookEditor;
    }

    public String getfBookPrice() {
        return fBookPrice;
    }

    public void setfBookPrice(String fBookPrice) {
        this.fBookPrice = fBookPrice;
    }

    public Boolean getfBookIswrite() {
        return fBookIswrite;
    }

    public void setfBookIswrite(Boolean fBookIswrite) {
        this.fBookIswrite = fBookIswrite;
    }
}
