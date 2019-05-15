package com.wtu.jht.bookmanage.modal.vo;

import com.wtu.jht.bookmanage.modal.BBookOrder;

/**
 * @author ：LY
 * @date ：Created in 2019/5/11 13:02
 * @description：
 * @modified By：
 * @version: $
 */
public class BBookOrderVO extends BBookOrder {

    private String level; //申请人单位

    private String fBookName;

    private String realName;

    private String fBookPrice;

    private Integer responsitory;

    private Boolean fBookIswrite;

    private String fState;


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getfBookName() {
        return fBookName;
    }

    public void setfBookName(String fBookName) {
        this.fBookName = fBookName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getfBookPrice() {
        return fBookPrice;
    }

    public void setfBookPrice(String fBookPrice) {
        this.fBookPrice = fBookPrice;
    }

    public Integer getResponsitory() {
        return responsitory;
    }

    public void setResponsitory(Integer responsitory) {
        this.responsitory = responsitory;
    }

    public Boolean getfBookIswrite() {
        return fBookIswrite;
    }

    public void setfBookIswrite(Boolean fBookIswrite) {
        this.fBookIswrite = fBookIswrite;
    }

    public String getfState() {
        return fState;
    }

    public void setfState(String fState) {
        this.fState = fState;
    }
}
