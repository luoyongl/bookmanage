package com.wtu.jht.bookmanage.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BApplyBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BApplyBookExample() {
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

        public Criteria andFBookIdIsNull() {
            addCriterion("f_book_id is null");
            return (Criteria) this;
        }

        public Criteria andFBookIdIsNotNull() {
            addCriterion("f_book_id is not null");
            return (Criteria) this;
        }

        public Criteria andFBookIdEqualTo(String value) {
            addCriterion("f_book_id =", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdNotEqualTo(String value) {
            addCriterion("f_book_id <>", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdGreaterThan(String value) {
            addCriterion("f_book_id >", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_book_id >=", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdLessThan(String value) {
            addCriterion("f_book_id <", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdLessThanOrEqualTo(String value) {
            addCriterion("f_book_id <=", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdLike(String value) {
            addCriterion("f_book_id like", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdNotLike(String value) {
            addCriterion("f_book_id not like", value, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdIn(List<String> values) {
            addCriterion("f_book_id in", values, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdNotIn(List<String> values) {
            addCriterion("f_book_id not in", values, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdBetween(String value1, String value2) {
            addCriterion("f_book_id between", value1, value2, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFBookIdNotBetween(String value1, String value2) {
            addCriterion("f_book_id not between", value1, value2, "fBookId");
            return (Criteria) this;
        }

        public Criteria andFApplyYearIsNull() {
            addCriterion("f_apply_year is null");
            return (Criteria) this;
        }

        public Criteria andFApplyYearIsNotNull() {
            addCriterion("f_apply_year is not null");
            return (Criteria) this;
        }

        public Criteria andFApplyYearEqualTo(String value) {
            addCriterion("f_apply_year =", value, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearNotEqualTo(String value) {
            addCriterion("f_apply_year <>", value, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearGreaterThan(String value) {
            addCriterion("f_apply_year >", value, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearGreaterThanOrEqualTo(String value) {
            addCriterion("f_apply_year >=", value, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearLessThan(String value) {
            addCriterion("f_apply_year <", value, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearLessThanOrEqualTo(String value) {
            addCriterion("f_apply_year <=", value, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearLike(String value) {
            addCriterion("f_apply_year like", value, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearNotLike(String value) {
            addCriterion("f_apply_year not like", value, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearIn(List<String> values) {
            addCriterion("f_apply_year in", values, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearNotIn(List<String> values) {
            addCriterion("f_apply_year not in", values, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearBetween(String value1, String value2) {
            addCriterion("f_apply_year between", value1, value2, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFApplyYearNotBetween(String value1, String value2) {
            addCriterion("f_apply_year not between", value1, value2, "fApplyYear");
            return (Criteria) this;
        }

        public Criteria andFClassIsNull() {
            addCriterion("f_class is null");
            return (Criteria) this;
        }

        public Criteria andFClassIsNotNull() {
            addCriterion("f_class is not null");
            return (Criteria) this;
        }

        public Criteria andFClassEqualTo(String value) {
            addCriterion("f_class =", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassNotEqualTo(String value) {
            addCriterion("f_class <>", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassGreaterThan(String value) {
            addCriterion("f_class >", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassGreaterThanOrEqualTo(String value) {
            addCriterion("f_class >=", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassLessThan(String value) {
            addCriterion("f_class <", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassLessThanOrEqualTo(String value) {
            addCriterion("f_class <=", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassLike(String value) {
            addCriterion("f_class like", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassNotLike(String value) {
            addCriterion("f_class not like", value, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassIn(List<String> values) {
            addCriterion("f_class in", values, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassNotIn(List<String> values) {
            addCriterion("f_class not in", values, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassBetween(String value1, String value2) {
            addCriterion("f_class between", value1, value2, "fClass");
            return (Criteria) this;
        }

        public Criteria andFClassNotBetween(String value1, String value2) {
            addCriterion("f_class not between", value1, value2, "fClass");
            return (Criteria) this;
        }

        public Criteria andFCourseNameIsNull() {
            addCriterion("f_course_name is null");
            return (Criteria) this;
        }

        public Criteria andFCourseNameIsNotNull() {
            addCriterion("f_course_name is not null");
            return (Criteria) this;
        }

        public Criteria andFCourseNameEqualTo(String value) {
            addCriterion("f_course_name =", value, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameNotEqualTo(String value) {
            addCriterion("f_course_name <>", value, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameGreaterThan(String value) {
            addCriterion("f_course_name >", value, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_course_name >=", value, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameLessThan(String value) {
            addCriterion("f_course_name <", value, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameLessThanOrEqualTo(String value) {
            addCriterion("f_course_name <=", value, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameLike(String value) {
            addCriterion("f_course_name like", value, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameNotLike(String value) {
            addCriterion("f_course_name not like", value, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameIn(List<String> values) {
            addCriterion("f_course_name in", values, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameNotIn(List<String> values) {
            addCriterion("f_course_name not in", values, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameBetween(String value1, String value2) {
            addCriterion("f_course_name between", value1, value2, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFCourseNameNotBetween(String value1, String value2) {
            addCriterion("f_course_name not between", value1, value2, "fCourseName");
            return (Criteria) this;
        }

        public Criteria andFMajorIsNull() {
            addCriterion("f_major is null");
            return (Criteria) this;
        }

        public Criteria andFMajorIsNotNull() {
            addCriterion("f_major is not null");
            return (Criteria) this;
        }

        public Criteria andFMajorEqualTo(String value) {
            addCriterion("f_major =", value, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorNotEqualTo(String value) {
            addCriterion("f_major <>", value, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorGreaterThan(String value) {
            addCriterion("f_major >", value, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorGreaterThanOrEqualTo(String value) {
            addCriterion("f_major >=", value, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorLessThan(String value) {
            addCriterion("f_major <", value, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorLessThanOrEqualTo(String value) {
            addCriterion("f_major <=", value, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorLike(String value) {
            addCriterion("f_major like", value, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorNotLike(String value) {
            addCriterion("f_major not like", value, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorIn(List<String> values) {
            addCriterion("f_major in", values, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorNotIn(List<String> values) {
            addCriterion("f_major not in", values, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorBetween(String value1, String value2) {
            addCriterion("f_major between", value1, value2, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFMajorNotBetween(String value1, String value2) {
            addCriterion("f_major not between", value1, value2, "fMajor");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeIsNull() {
            addCriterion("f_course_attribute is null");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeIsNotNull() {
            addCriterion("f_course_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeEqualTo(String value) {
            addCriterion("f_course_attribute =", value, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeNotEqualTo(String value) {
            addCriterion("f_course_attribute <>", value, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeGreaterThan(String value) {
            addCriterion("f_course_attribute >", value, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("f_course_attribute >=", value, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeLessThan(String value) {
            addCriterion("f_course_attribute <", value, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeLessThanOrEqualTo(String value) {
            addCriterion("f_course_attribute <=", value, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeLike(String value) {
            addCriterion("f_course_attribute like", value, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeNotLike(String value) {
            addCriterion("f_course_attribute not like", value, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeIn(List<String> values) {
            addCriterion("f_course_attribute in", values, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeNotIn(List<String> values) {
            addCriterion("f_course_attribute not in", values, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeBetween(String value1, String value2) {
            addCriterion("f_course_attribute between", value1, value2, "fCourseAttribute");
            return (Criteria) this;
        }

        public Criteria andFCourseAttributeNotBetween(String value1, String value2) {
            addCriterion("f_course_attribute not between", value1, value2, "fCourseAttribute");
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

        public Criteria andFStateIsNull() {
            addCriterion("f_state is null");
            return (Criteria) this;
        }

        public Criteria andFStateIsNotNull() {
            addCriterion("f_state is not null");
            return (Criteria) this;
        }

        public Criteria andFStateEqualTo(String value) {
            addCriterion("f_state =", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotEqualTo(String value) {
            addCriterion("f_state <>", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateGreaterThan(String value) {
            addCriterion("f_state >", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateGreaterThanOrEqualTo(String value) {
            addCriterion("f_state >=", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateLessThan(String value) {
            addCriterion("f_state <", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateLessThanOrEqualTo(String value) {
            addCriterion("f_state <=", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateLike(String value) {
            addCriterion("f_state like", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotLike(String value) {
            addCriterion("f_state not like", value, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateIn(List<String> values) {
            addCriterion("f_state in", values, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotIn(List<String> values) {
            addCriterion("f_state not in", values, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateBetween(String value1, String value2) {
            addCriterion("f_state between", value1, value2, "fState");
            return (Criteria) this;
        }

        public Criteria andFStateNotBetween(String value1, String value2) {
            addCriterion("f_state not between", value1, value2, "fState");
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