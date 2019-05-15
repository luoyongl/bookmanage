package com.wtu.jht.bookmanage.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BBookListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBookListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFBookNumberIsNull() {
            addCriterion("f_book_number is null");
            return (Criteria) this;
        }

        public Criteria andFBookNumberIsNotNull() {
            addCriterion("f_book_number is not null");
            return (Criteria) this;
        }

        public Criteria andFBookNumberEqualTo(String value) {
            addCriterion("f_book_number =", value, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberNotEqualTo(String value) {
            addCriterion("f_book_number <>", value, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberGreaterThan(String value) {
            addCriterion("f_book_number >", value, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_number >=", value, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberLessThan(String value) {
            addCriterion("f_book_number <", value, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberLessThanOrEqualTo(String value) {
            addCriterion("f_book_number <=", value, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberLike(String value) {
            addCriterion("f_book_number like", value, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberNotLike(String value) {
            addCriterion("f_book_number not like", value, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberIn(List<String> values) {
            addCriterion("f_book_number in", values, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberNotIn(List<String> values) {
            addCriterion("f_book_number not in", values, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberBetween(String value1, String value2) {
            addCriterion("f_book_number between", value1, value2, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNumberNotBetween(String value1, String value2) {
            addCriterion("f_book_number not between", value1, value2, "fBookNumber");
            return (Criteria) this;
        }

        public Criteria andFBookNameIsNull() {
            addCriterion("f_book_name is null");
            return (Criteria) this;
        }

        public Criteria andFBookNameIsNotNull() {
            addCriterion("f_book_name is not null");
            return (Criteria) this;
        }

        public Criteria andFBookNameEqualTo(String value) {
            addCriterion("f_book_name =", value, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameNotEqualTo(String value) {
            addCriterion("f_book_name <>", value, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameGreaterThan(String value) {
            addCriterion("f_book_name >", value, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_name >=", value, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameLessThan(String value) {
            addCriterion("f_book_name <", value, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameLessThanOrEqualTo(String value) {
            addCriterion("f_book_name <=", value, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameLike(String value) {
            addCriterion("f_book_name like", value, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameNotLike(String value) {
            addCriterion("f_book_name not like", value, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameIn(List<String> values) {
            addCriterion("f_book_name in", values, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameNotIn(List<String> values) {
            addCriterion("f_book_name not in", values, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameBetween(String value1, String value2) {
            addCriterion("f_book_name between", value1, value2, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookNameNotBetween(String value1, String value2) {
            addCriterion("f_book_name not between", value1, value2, "fBookName");
            return (Criteria) this;
        }

        public Criteria andFBookPublishIsNull() {
            addCriterion("f_book_publish is null");
            return (Criteria) this;
        }

        public Criteria andFBookPublishIsNotNull() {
            addCriterion("f_book_publish is not null");
            return (Criteria) this;
        }

        public Criteria andFBookPublishEqualTo(String value) {
            addCriterion("f_book_publish =", value, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishNotEqualTo(String value) {
            addCriterion("f_book_publish <>", value, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishGreaterThan(String value) {
            addCriterion("f_book_publish >", value, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_publish >=", value, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishLessThan(String value) {
            addCriterion("f_book_publish <", value, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishLessThanOrEqualTo(String value) {
            addCriterion("f_book_publish <=", value, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishLike(String value) {
            addCriterion("f_book_publish like", value, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishNotLike(String value) {
            addCriterion("f_book_publish not like", value, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishIn(List<String> values) {
            addCriterion("f_book_publish in", values, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishNotIn(List<String> values) {
            addCriterion("f_book_publish not in", values, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishBetween(String value1, String value2) {
            addCriterion("f_book_publish between", value1, value2, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookPublishNotBetween(String value1, String value2) {
            addCriterion("f_book_publish not between", value1, value2, "fBookPublish");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnIsNull() {
            addCriterion("f_book_isbn is null");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnIsNotNull() {
            addCriterion("f_book_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnEqualTo(String value) {
            addCriterion("f_book_isbn =", value, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnNotEqualTo(String value) {
            addCriterion("f_book_isbn <>", value, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnGreaterThan(String value) {
            addCriterion("f_book_isbn >", value, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_isbn >=", value, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnLessThan(String value) {
            addCriterion("f_book_isbn <", value, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnLessThanOrEqualTo(String value) {
            addCriterion("f_book_isbn <=", value, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnLike(String value) {
            addCriterion("f_book_isbn like", value, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnNotLike(String value) {
            addCriterion("f_book_isbn not like", value, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnIn(List<String> values) {
            addCriterion("f_book_isbn in", values, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnNotIn(List<String> values) {
            addCriterion("f_book_isbn not in", values, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnBetween(String value1, String value2) {
            addCriterion("f_book_isbn between", value1, value2, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookIsbnNotBetween(String value1, String value2) {
            addCriterion("f_book_isbn not between", value1, value2, "fBookIsbn");
            return (Criteria) this;
        }

        public Criteria andFBookEditorIsNull() {
            addCriterion("f_book_editor is null");
            return (Criteria) this;
        }

        public Criteria andFBookEditorIsNotNull() {
            addCriterion("f_book_editor is not null");
            return (Criteria) this;
        }

        public Criteria andFBookEditorEqualTo(String value) {
            addCriterion("f_book_editor =", value, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorNotEqualTo(String value) {
            addCriterion("f_book_editor <>", value, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorGreaterThan(String value) {
            addCriterion("f_book_editor >", value, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_editor >=", value, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorLessThan(String value) {
            addCriterion("f_book_editor <", value, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorLessThanOrEqualTo(String value) {
            addCriterion("f_book_editor <=", value, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorLike(String value) {
            addCriterion("f_book_editor like", value, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorNotLike(String value) {
            addCriterion("f_book_editor not like", value, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorIn(List<String> values) {
            addCriterion("f_book_editor in", values, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorNotIn(List<String> values) {
            addCriterion("f_book_editor not in", values, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorBetween(String value1, String value2) {
            addCriterion("f_book_editor between", value1, value2, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEditorNotBetween(String value1, String value2) {
            addCriterion("f_book_editor not between", value1, value2, "fBookEditor");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionIsNull() {
            addCriterion("f_book_edtion is null");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionIsNotNull() {
            addCriterion("f_book_edtion is not null");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionEqualTo(String value) {
            addCriterion("f_book_edtion =", value, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionNotEqualTo(String value) {
            addCriterion("f_book_edtion <>", value, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionGreaterThan(String value) {
            addCriterion("f_book_edtion >", value, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_edtion >=", value, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionLessThan(String value) {
            addCriterion("f_book_edtion <", value, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionLessThanOrEqualTo(String value) {
            addCriterion("f_book_edtion <=", value, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionLike(String value) {
            addCriterion("f_book_edtion like", value, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionNotLike(String value) {
            addCriterion("f_book_edtion not like", value, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionIn(List<String> values) {
            addCriterion("f_book_edtion in", values, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionNotIn(List<String> values) {
            addCriterion("f_book_edtion not in", values, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionBetween(String value1, String value2) {
            addCriterion("f_book_edtion between", value1, value2, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookEdtionNotBetween(String value1, String value2) {
            addCriterion("f_book_edtion not between", value1, value2, "fBookEdtion");
            return (Criteria) this;
        }

        public Criteria andFBookPriceIsNull() {
            addCriterion("f_book_price is null");
            return (Criteria) this;
        }

        public Criteria andFBookPriceIsNotNull() {
            addCriterion("f_book_price is not null");
            return (Criteria) this;
        }

        public Criteria andFBookPriceEqualTo(String value) {
            addCriterion("f_book_price =", value, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceNotEqualTo(String value) {
            addCriterion("f_book_price <>", value, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceGreaterThan(String value) {
            addCriterion("f_book_price >", value, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_price >=", value, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceLessThan(String value) {
            addCriterion("f_book_price <", value, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceLessThanOrEqualTo(String value) {
            addCriterion("f_book_price <=", value, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceLike(String value) {
            addCriterion("f_book_price like", value, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceNotLike(String value) {
            addCriterion("f_book_price not like", value, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceIn(List<String> values) {
            addCriterion("f_book_price in", values, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceNotIn(List<String> values) {
            addCriterion("f_book_price not in", values, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceBetween(String value1, String value2) {
            addCriterion("f_book_price between", value1, value2, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookPriceNotBetween(String value1, String value2) {
            addCriterion("f_book_price not between", value1, value2, "fBookPrice");
            return (Criteria) this;
        }

        public Criteria andFBookTypeIsNull() {
            addCriterion("f_book_type is null");
            return (Criteria) this;
        }

        public Criteria andFBookTypeIsNotNull() {
            addCriterion("f_book_type is not null");
            return (Criteria) this;
        }

        public Criteria andFBookTypeEqualTo(String value) {
            addCriterion("f_book_type =", value, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeNotEqualTo(String value) {
            addCriterion("f_book_type <>", value, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeGreaterThan(String value) {
            addCriterion("f_book_type >", value, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_type >=", value, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeLessThan(String value) {
            addCriterion("f_book_type <", value, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeLessThanOrEqualTo(String value) {
            addCriterion("f_book_type <=", value, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeLike(String value) {
            addCriterion("f_book_type like", value, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeNotLike(String value) {
            addCriterion("f_book_type not like", value, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeIn(List<String> values) {
            addCriterion("f_book_type in", values, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeNotIn(List<String> values) {
            addCriterion("f_book_type not in", values, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeBetween(String value1, String value2) {
            addCriterion("f_book_type between", value1, value2, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookTypeNotBetween(String value1, String value2) {
            addCriterion("f_book_type not between", value1, value2, "fBookType");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteIsNull() {
            addCriterion("f_book_iswrite is null");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteIsNotNull() {
            addCriterion("f_book_iswrite is not null");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteEqualTo(Boolean value) {
            addCriterion("f_book_iswrite =", value, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteNotEqualTo(Boolean value) {
            addCriterion("f_book_iswrite <>", value, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteGreaterThan(Boolean value) {
            addCriterion("f_book_iswrite >", value, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_book_iswrite >=", value, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteLessThan(Boolean value) {
            addCriterion("f_book_iswrite <", value, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteLessThanOrEqualTo(Boolean value) {
            addCriterion("f_book_iswrite <=", value, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteIn(List<Boolean> values) {
            addCriterion("f_book_iswrite in", values, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteNotIn(List<Boolean> values) {
            addCriterion("f_book_iswrite not in", values, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteBetween(Boolean value1, Boolean value2) {
            addCriterion("f_book_iswrite between", value1, value2, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFBookIswriteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_book_iswrite not between", value1, value2, "fBookIswrite");
            return (Criteria) this;
        }

        public Criteria andFWriteIdIsNull() {
            addCriterion("f_write_id is null");
            return (Criteria) this;
        }

        public Criteria andFWriteIdIsNotNull() {
            addCriterion("f_write_id is not null");
            return (Criteria) this;
        }

        public Criteria andFWriteIdEqualTo(Integer value) {
            addCriterion("f_write_id =", value, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdNotEqualTo(Integer value) {
            addCriterion("f_write_id <>", value, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdGreaterThan(Integer value) {
            addCriterion("f_write_id >", value, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_write_id >=", value, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdLessThan(Integer value) {
            addCriterion("f_write_id <", value, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_write_id <=", value, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdIn(List<Integer> values) {
            addCriterion("f_write_id in", values, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdNotIn(List<Integer> values) {
            addCriterion("f_write_id not in", values, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdBetween(Integer value1, Integer value2) {
            addCriterion("f_write_id between", value1, value2, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFWriteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_write_id not between", value1, value2, "fWriteId");
            return (Criteria) this;
        }

        public Criteria andFBookUrlIsNull() {
            addCriterion("f_book_url is null");
            return (Criteria) this;
        }

        public Criteria andFBookUrlIsNotNull() {
            addCriterion("f_book_url is not null");
            return (Criteria) this;
        }

        public Criteria andFBookUrlEqualTo(String value) {
            addCriterion("f_book_url =", value, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlNotEqualTo(String value) {
            addCriterion("f_book_url <>", value, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlGreaterThan(String value) {
            addCriterion("f_book_url >", value, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_url >=", value, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlLessThan(String value) {
            addCriterion("f_book_url <", value, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlLessThanOrEqualTo(String value) {
            addCriterion("f_book_url <=", value, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlLike(String value) {
            addCriterion("f_book_url like", value, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlNotLike(String value) {
            addCriterion("f_book_url not like", value, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlIn(List<String> values) {
            addCriterion("f_book_url in", values, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlNotIn(List<String> values) {
            addCriterion("f_book_url not in", values, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlBetween(String value1, String value2) {
            addCriterion("f_book_url between", value1, value2, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFBookUrlNotBetween(String value1, String value2) {
            addCriterion("f_book_url not between", value1, value2, "fBookUrl");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIsNull() {
            addCriterion("f_creator_id is null");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIsNotNull() {
            addCriterion("f_creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdEqualTo(Integer value) {
            addCriterion("f_creator_id =", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotEqualTo(Integer value) {
            addCriterion("f_creator_id <>", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdGreaterThan(Integer value) {
            addCriterion("f_creator_id >", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_creator_id >=", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdLessThan(Integer value) {
            addCriterion("f_creator_id <", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_creator_id <=", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIn(List<Integer> values) {
            addCriterion("f_creator_id in", values, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotIn(List<Integer> values) {
            addCriterion("f_creator_id not in", values, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("f_creator_id between", value1, value2, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_creator_id not between", value1, value2, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIsNull() {
            addCriterion("f_update_time is null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIsNotNull() {
            addCriterion("f_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeEqualTo(Date value) {
            addCriterion("f_update_time =", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotEqualTo(Date value) {
            addCriterion("f_update_time <>", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeGreaterThan(Date value) {
            addCriterion("f_update_time >", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_update_time >=", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeLessThan(Date value) {
            addCriterion("f_update_time <", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_update_time <=", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIn(List<Date> values) {
            addCriterion("f_update_time in", values, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotIn(List<Date> values) {
            addCriterion("f_update_time not in", values, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("f_update_time between", value1, value2, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_update_time not between", value1, value2, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIsNull() {
            addCriterion("f_operator_id is null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIsNotNull() {
            addCriterion("f_operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdEqualTo(Integer value) {
            addCriterion("f_operator_id =", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotEqualTo(Integer value) {
            addCriterion("f_operator_id <>", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdGreaterThan(Integer value) {
            addCriterion("f_operator_id >", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_operator_id >=", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdLessThan(Integer value) {
            addCriterion("f_operator_id <", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_operator_id <=", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIn(List<Integer> values) {
            addCriterion("f_operator_id in", values, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotIn(List<Integer> values) {
            addCriterion("f_operator_id not in", values, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("f_operator_id between", value1, value2, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_operator_id not between", value1, value2, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIsNull() {
            addCriterion("f_delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIsNotNull() {
            addCriterion("f_delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagEqualTo(Boolean value) {
            addCriterion("f_delete_flag =", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotEqualTo(Boolean value) {
            addCriterion("f_delete_flag <>", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagGreaterThan(Boolean value) {
            addCriterion("f_delete_flag >", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_delete_flag >=", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagLessThan(Boolean value) {
            addCriterion("f_delete_flag <", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("f_delete_flag <=", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIn(List<Boolean> values) {
            addCriterion("f_delete_flag in", values, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotIn(List<Boolean> values) {
            addCriterion("f_delete_flag not in", values, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("f_delete_flag between", value1, value2, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_delete_flag not between", value1, value2, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFStateIsNull() {
            addCriterion("f_state is null");
            return (Criteria) this;
        }

        public Criteria andFStateIsNotNull() {
            addCriterion("f_state is not null");
            return (Criteria) this;
        }

        public Criteria andFStateEqualTo(Byte value) {
            addCriterion("f_state =", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotEqualTo(Byte value) {
            addCriterion("f_state <>", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateGreaterThan(Byte value) {
            addCriterion("f_state >", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_state >=", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateLessThan(Byte value) {
            addCriterion("f_state <", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateLessThanOrEqualTo(Byte value) {
            addCriterion("f_state <=", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateIn(List<Byte> values) {
            addCriterion("f_state in", values, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotIn(List<Byte> values) {
            addCriterion("f_state not in", values, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateBetween(Byte value1, Byte value2) {
            addCriterion("f_state between", value1, value2, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotBetween(Byte value1, Byte value2) {
            addCriterion("f_state not between", value1, value2, "fState");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}