package com.wtu.jht.bookmanage.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BEvaluateExample() {
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

        public Criteria andFBookIdIsNull() {
            addCriterion("f_book_id is null");
            return (Criteria) this;
        }

        public Criteria andFBookIdIsNotNull() {
            addCriterion("f_book_id is not null");
            return (Criteria) this;
        }

        public Criteria andFBookIdEqualTo(Integer value) {
            addCriterion("f_book_id =", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdNotEqualTo(Integer value) {
            addCriterion("f_book_id <>", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdGreaterThan(Integer value) {
            addCriterion("f_book_id >", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_book_id >=", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdLessThan(Integer value) {
            addCriterion("f_book_id <", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_book_id <=", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdIn(List<Integer> values) {
            addCriterion("f_book_id in", values, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdNotIn(List<Integer> values) {
            addCriterion("f_book_id not in", values, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdBetween(Integer value1, Integer value2) {
            addCriterion("f_book_id between", value1, value2, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_book_id not between", value1, value2, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFGradeIsNull() {
            addCriterion("f_grade is null");
            return (Criteria) this;
        }

        public Criteria andFGradeIsNotNull() {
            addCriterion("f_grade is not null");
            return (Criteria) this;
        }

        public Criteria andFGradeEqualTo(Integer value) {
            addCriterion("f_grade =", value, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeNotEqualTo(Integer value) {
            addCriterion("f_grade <>", value, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeGreaterThan(Integer value) {
            addCriterion("f_grade >", value, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_grade >=", value, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeLessThan(Integer value) {
            addCriterion("f_grade <", value, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeLessThanOrEqualTo(Integer value) {
            addCriterion("f_grade <=", value, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeIn(List<Integer> values) {
            addCriterion("f_grade in", values, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeNotIn(List<Integer> values) {
            addCriterion("f_grade not in", values, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeBetween(Integer value1, Integer value2) {
            addCriterion("f_grade between", value1, value2, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_grade not between", value1, value2, "fGrade");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNull() {
            addCriterion("f_remark is null");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNotNull() {
            addCriterion("f_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFRemarkEqualTo(String value) {
            addCriterion("f_remark =", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotEqualTo(String value) {
            addCriterion("f_remark <>", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThan(String value) {
            addCriterion("f_remark >", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("f_remark >=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThan(String value) {
            addCriterion("f_remark <", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThanOrEqualTo(String value) {
            addCriterion("f_remark <=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLike(String value) {
            addCriterion("f_remark like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotLike(String value) {
            addCriterion("f_remark not like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkIn(List<String> values) {
            addCriterion("f_remark in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotIn(List<String> values) {
            addCriterion("f_remark not in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkBetween(String value1, String value2) {
            addCriterion("f_remark between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotBetween(String value1, String value2) {
            addCriterion("f_remark not between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFUserIdIsNull() {
            addCriterion("f_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFUserIdIsNotNull() {
            addCriterion("f_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFUserIdEqualTo(Integer value) {
            addCriterion("f_user_id =", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotEqualTo(Integer value) {
            addCriterion("f_user_id <>", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdGreaterThan(Integer value) {
            addCriterion("f_user_id >", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_user_id >=", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdLessThan(Integer value) {
            addCriterion("f_user_id <", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_user_id <=", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdIn(List<Integer> values) {
            addCriterion("f_user_id in", values, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotIn(List<Integer> values) {
            addCriterion("f_user_id not in", values, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdBetween(Integer value1, Integer value2) {
            addCriterion("f_user_id between", value1, value2, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_user_id not between", value1, value2, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFListIsNull() {
            addCriterion("f_list is null");
            return (Criteria) this;
        }

        public Criteria andFListIsNotNull() {
            addCriterion("f_list is not null");
            return (Criteria) this;
        }

        public Criteria andFListEqualTo(String value) {
            addCriterion("f_list =", value, "fList");
            return (Criteria) this;
        }

        public Criteria andFListNotEqualTo(String value) {
            addCriterion("f_list <>", value, "fList");
            return (Criteria) this;
        }

        public Criteria andFListGreaterThan(String value) {
            addCriterion("f_list >", value, "fList");
            return (Criteria) this;
        }

        public Criteria andFListGreaterThanOrEqualTo(String value) {
            addCriterion("f_list >=", value, "fList");
            return (Criteria) this;
        }

        public Criteria andFListLessThan(String value) {
            addCriterion("f_list <", value, "fList");
            return (Criteria) this;
        }

        public Criteria andFListLessThanOrEqualTo(String value) {
            addCriterion("f_list <=", value, "fList");
            return (Criteria) this;
        }

        public Criteria andFListLike(String value) {
            addCriterion("f_list like", value, "fList");
            return (Criteria) this;
        }

        public Criteria andFListNotLike(String value) {
            addCriterion("f_list not like", value, "fList");
            return (Criteria) this;
        }

        public Criteria andFListIn(List<String> values) {
            addCriterion("f_list in", values, "fList");
            return (Criteria) this;
        }

        public Criteria andFListNotIn(List<String> values) {
            addCriterion("f_list not in", values, "fList");
            return (Criteria) this;
        }

        public Criteria andFListBetween(String value1, String value2) {
            addCriterion("f_list between", value1, value2, "fList");
            return (Criteria) this;
        }

        public Criteria andFListNotBetween(String value1, String value2) {
            addCriterion("f_list not between", value1, value2, "fList");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNull() {
            addCriterion("f_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNotNull() {
            addCriterion("f_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeEqualTo(Date value) {
            addCriterion("f_create_time =", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotEqualTo(Date value) {
            addCriterion("f_create_time <>", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThan(Date value) {
            addCriterion("f_create_time >", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_create_time >=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThan(Date value) {
            addCriterion("f_create_time <", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_create_time <=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIn(List<Date> values) {
            addCriterion("f_create_time in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotIn(List<Date> values) {
            addCriterion("f_create_time not in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeBetween(Date value1, Date value2) {
            addCriterion("f_create_time between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_create_time not between", value1, value2, "fCreateTime");
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