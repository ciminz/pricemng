package com.nngdjt.pricemng.entity;

import java.util.ArrayList;
import java.util.List;

public class LineInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLineNoIsNull() {
            addCriterion("line_no is null");
            return (Criteria) this;
        }

        public Criteria andLineNoIsNotNull() {
            addCriterion("line_no is not null");
            return (Criteria) this;
        }

        public Criteria andLineNoEqualTo(String value) {
            addCriterion("line_no =", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoNotEqualTo(String value) {
            addCriterion("line_no <>", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoGreaterThan(String value) {
            addCriterion("line_no >", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoGreaterThanOrEqualTo(String value) {
            addCriterion("line_no >=", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoLessThan(String value) {
            addCriterion("line_no <", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoLessThanOrEqualTo(String value) {
            addCriterion("line_no <=", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoLike(String value) {
            addCriterion("line_no like", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoNotLike(String value) {
            addCriterion("line_no not like", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoIn(List<String> values) {
            addCriterion("line_no in", values, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoNotIn(List<String> values) {
            addCriterion("line_no not in", values, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoBetween(String value1, String value2) {
            addCriterion("line_no between", value1, value2, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoNotBetween(String value1, String value2) {
            addCriterion("line_no not between", value1, value2, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNmeIsNull() {
            addCriterion("line_nme is null");
            return (Criteria) this;
        }

        public Criteria andLineNmeIsNotNull() {
            addCriterion("line_nme is not null");
            return (Criteria) this;
        }

        public Criteria andLineNmeEqualTo(String value) {
            addCriterion("line_nme =", value, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeNotEqualTo(String value) {
            addCriterion("line_nme <>", value, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeGreaterThan(String value) {
            addCriterion("line_nme >", value, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeGreaterThanOrEqualTo(String value) {
            addCriterion("line_nme >=", value, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeLessThan(String value) {
            addCriterion("line_nme <", value, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeLessThanOrEqualTo(String value) {
            addCriterion("line_nme <=", value, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeLike(String value) {
            addCriterion("line_nme like", value, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeNotLike(String value) {
            addCriterion("line_nme not like", value, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeIn(List<String> values) {
            addCriterion("line_nme in", values, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeNotIn(List<String> values) {
            addCriterion("line_nme not in", values, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeBetween(String value1, String value2) {
            addCriterion("line_nme between", value1, value2, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineNmeNotBetween(String value1, String value2) {
            addCriterion("line_nme not between", value1, value2, "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeIsNull() {
            addCriterion("line_en_nme is null");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeIsNotNull() {
            addCriterion("line_en_nme is not null");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeEqualTo(String value) {
            addCriterion("line_en_nme =", value, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeNotEqualTo(String value) {
            addCriterion("line_en_nme <>", value, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeGreaterThan(String value) {
            addCriterion("line_en_nme >", value, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeGreaterThanOrEqualTo(String value) {
            addCriterion("line_en_nme >=", value, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeLessThan(String value) {
            addCriterion("line_en_nme <", value, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeLessThanOrEqualTo(String value) {
            addCriterion("line_en_nme <=", value, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeLike(String value) {
            addCriterion("line_en_nme like", value, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeNotLike(String value) {
            addCriterion("line_en_nme not like", value, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeIn(List<String> values) {
            addCriterion("line_en_nme in", values, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeNotIn(List<String> values) {
            addCriterion("line_en_nme not in", values, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeBetween(String value1, String value2) {
            addCriterion("line_en_nme between", value1, value2, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeNotBetween(String value1, String value2) {
            addCriterion("line_en_nme not between", value1, value2, "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineColorIsNull() {
            addCriterion("line_color is null");
            return (Criteria) this;
        }

        public Criteria andLineColorIsNotNull() {
            addCriterion("line_color is not null");
            return (Criteria) this;
        }

        public Criteria andLineColorEqualTo(String value) {
            addCriterion("line_color =", value, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorNotEqualTo(String value) {
            addCriterion("line_color <>", value, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorGreaterThan(String value) {
            addCriterion("line_color >", value, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorGreaterThanOrEqualTo(String value) {
            addCriterion("line_color >=", value, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorLessThan(String value) {
            addCriterion("line_color <", value, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorLessThanOrEqualTo(String value) {
            addCriterion("line_color <=", value, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorLike(String value) {
            addCriterion("line_color like", value, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorNotLike(String value) {
            addCriterion("line_color not like", value, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorIn(List<String> values) {
            addCriterion("line_color in", values, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorNotIn(List<String> values) {
            addCriterion("line_color not in", values, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorBetween(String value1, String value2) {
            addCriterion("line_color between", value1, value2, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineColorNotBetween(String value1, String value2) {
            addCriterion("line_color not between", value1, value2, "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineDesIsNull() {
            addCriterion("line_des is null");
            return (Criteria) this;
        }

        public Criteria andLineDesIsNotNull() {
            addCriterion("line_des is not null");
            return (Criteria) this;
        }

        public Criteria andLineDesEqualTo(String value) {
            addCriterion("line_des =", value, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesNotEqualTo(String value) {
            addCriterion("line_des <>", value, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesGreaterThan(String value) {
            addCriterion("line_des >", value, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesGreaterThanOrEqualTo(String value) {
            addCriterion("line_des >=", value, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesLessThan(String value) {
            addCriterion("line_des <", value, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesLessThanOrEqualTo(String value) {
            addCriterion("line_des <=", value, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesLike(String value) {
            addCriterion("line_des like", value, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesNotLike(String value) {
            addCriterion("line_des not like", value, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesIn(List<String> values) {
            addCriterion("line_des in", values, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesNotIn(List<String> values) {
            addCriterion("line_des not in", values, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesBetween(String value1, String value2) {
            addCriterion("line_des between", value1, value2, "lineDes");
            return (Criteria) this;
        }

        public Criteria andLineDesNotBetween(String value1, String value2) {
            addCriterion("line_des not between", value1, value2, "lineDes");
            return (Criteria) this;
        }

        public Criteria andBakFld1IsNull() {
            addCriterion("bak_fld1 is null");
            return (Criteria) this;
        }

        public Criteria andBakFld1IsNotNull() {
            addCriterion("bak_fld1 is not null");
            return (Criteria) this;
        }

        public Criteria andBakFld1EqualTo(String value) {
            addCriterion("bak_fld1 =", value, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1NotEqualTo(String value) {
            addCriterion("bak_fld1 <>", value, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1GreaterThan(String value) {
            addCriterion("bak_fld1 >", value, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1GreaterThanOrEqualTo(String value) {
            addCriterion("bak_fld1 >=", value, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1LessThan(String value) {
            addCriterion("bak_fld1 <", value, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1LessThanOrEqualTo(String value) {
            addCriterion("bak_fld1 <=", value, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1Like(String value) {
            addCriterion("bak_fld1 like", value, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1NotLike(String value) {
            addCriterion("bak_fld1 not like", value, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1In(List<String> values) {
            addCriterion("bak_fld1 in", values, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1NotIn(List<String> values) {
            addCriterion("bak_fld1 not in", values, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1Between(String value1, String value2) {
            addCriterion("bak_fld1 between", value1, value2, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld1NotBetween(String value1, String value2) {
            addCriterion("bak_fld1 not between", value1, value2, "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld2IsNull() {
            addCriterion("bak_fld2 is null");
            return (Criteria) this;
        }

        public Criteria andBakFld2IsNotNull() {
            addCriterion("bak_fld2 is not null");
            return (Criteria) this;
        }

        public Criteria andBakFld2EqualTo(String value) {
            addCriterion("bak_fld2 =", value, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2NotEqualTo(String value) {
            addCriterion("bak_fld2 <>", value, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2GreaterThan(String value) {
            addCriterion("bak_fld2 >", value, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2GreaterThanOrEqualTo(String value) {
            addCriterion("bak_fld2 >=", value, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2LessThan(String value) {
            addCriterion("bak_fld2 <", value, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2LessThanOrEqualTo(String value) {
            addCriterion("bak_fld2 <=", value, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2Like(String value) {
            addCriterion("bak_fld2 like", value, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2NotLike(String value) {
            addCriterion("bak_fld2 not like", value, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2In(List<String> values) {
            addCriterion("bak_fld2 in", values, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2NotIn(List<String> values) {
            addCriterion("bak_fld2 not in", values, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2Between(String value1, String value2) {
            addCriterion("bak_fld2 between", value1, value2, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld2NotBetween(String value1, String value2) {
            addCriterion("bak_fld2 not between", value1, value2, "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld3IsNull() {
            addCriterion("bak_fld3 is null");
            return (Criteria) this;
        }

        public Criteria andBakFld3IsNotNull() {
            addCriterion("bak_fld3 is not null");
            return (Criteria) this;
        }

        public Criteria andBakFld3EqualTo(String value) {
            addCriterion("bak_fld3 =", value, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3NotEqualTo(String value) {
            addCriterion("bak_fld3 <>", value, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3GreaterThan(String value) {
            addCriterion("bak_fld3 >", value, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3GreaterThanOrEqualTo(String value) {
            addCriterion("bak_fld3 >=", value, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3LessThan(String value) {
            addCriterion("bak_fld3 <", value, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3LessThanOrEqualTo(String value) {
            addCriterion("bak_fld3 <=", value, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3Like(String value) {
            addCriterion("bak_fld3 like", value, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3NotLike(String value) {
            addCriterion("bak_fld3 not like", value, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3In(List<String> values) {
            addCriterion("bak_fld3 in", values, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3NotIn(List<String> values) {
            addCriterion("bak_fld3 not in", values, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3Between(String value1, String value2) {
            addCriterion("bak_fld3 between", value1, value2, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld3NotBetween(String value1, String value2) {
            addCriterion("bak_fld3 not between", value1, value2, "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld4IsNull() {
            addCriterion("bak_fld4 is null");
            return (Criteria) this;
        }

        public Criteria andBakFld4IsNotNull() {
            addCriterion("bak_fld4 is not null");
            return (Criteria) this;
        }

        public Criteria andBakFld4EqualTo(String value) {
            addCriterion("bak_fld4 =", value, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4NotEqualTo(String value) {
            addCriterion("bak_fld4 <>", value, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4GreaterThan(String value) {
            addCriterion("bak_fld4 >", value, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4GreaterThanOrEqualTo(String value) {
            addCriterion("bak_fld4 >=", value, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4LessThan(String value) {
            addCriterion("bak_fld4 <", value, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4LessThanOrEqualTo(String value) {
            addCriterion("bak_fld4 <=", value, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4Like(String value) {
            addCriterion("bak_fld4 like", value, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4NotLike(String value) {
            addCriterion("bak_fld4 not like", value, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4In(List<String> values) {
            addCriterion("bak_fld4 in", values, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4NotIn(List<String> values) {
            addCriterion("bak_fld4 not in", values, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4Between(String value1, String value2) {
            addCriterion("bak_fld4 between", value1, value2, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld4NotBetween(String value1, String value2) {
            addCriterion("bak_fld4 not between", value1, value2, "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld5IsNull() {
            addCriterion("bak_fld5 is null");
            return (Criteria) this;
        }

        public Criteria andBakFld5IsNotNull() {
            addCriterion("bak_fld5 is not null");
            return (Criteria) this;
        }

        public Criteria andBakFld5EqualTo(String value) {
            addCriterion("bak_fld5 =", value, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5NotEqualTo(String value) {
            addCriterion("bak_fld5 <>", value, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5GreaterThan(String value) {
            addCriterion("bak_fld5 >", value, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5GreaterThanOrEqualTo(String value) {
            addCriterion("bak_fld5 >=", value, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5LessThan(String value) {
            addCriterion("bak_fld5 <", value, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5LessThanOrEqualTo(String value) {
            addCriterion("bak_fld5 <=", value, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5Like(String value) {
            addCriterion("bak_fld5 like", value, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5NotLike(String value) {
            addCriterion("bak_fld5 not like", value, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5In(List<String> values) {
            addCriterion("bak_fld5 in", values, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5NotIn(List<String> values) {
            addCriterion("bak_fld5 not in", values, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5Between(String value1, String value2) {
            addCriterion("bak_fld5 between", value1, value2, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld5NotBetween(String value1, String value2) {
            addCriterion("bak_fld5 not between", value1, value2, "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld6IsNull() {
            addCriterion("bak_fld6 is null");
            return (Criteria) this;
        }

        public Criteria andBakFld6IsNotNull() {
            addCriterion("bak_fld6 is not null");
            return (Criteria) this;
        }

        public Criteria andBakFld6EqualTo(String value) {
            addCriterion("bak_fld6 =", value, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6NotEqualTo(String value) {
            addCriterion("bak_fld6 <>", value, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6GreaterThan(String value) {
            addCriterion("bak_fld6 >", value, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6GreaterThanOrEqualTo(String value) {
            addCriterion("bak_fld6 >=", value, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6LessThan(String value) {
            addCriterion("bak_fld6 <", value, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6LessThanOrEqualTo(String value) {
            addCriterion("bak_fld6 <=", value, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6Like(String value) {
            addCriterion("bak_fld6 like", value, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6NotLike(String value) {
            addCriterion("bak_fld6 not like", value, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6In(List<String> values) {
            addCriterion("bak_fld6 in", values, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6NotIn(List<String> values) {
            addCriterion("bak_fld6 not in", values, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6Between(String value1, String value2) {
            addCriterion("bak_fld6 between", value1, value2, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld6NotBetween(String value1, String value2) {
            addCriterion("bak_fld6 not between", value1, value2, "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld7IsNull() {
            addCriterion("bak_fld7 is null");
            return (Criteria) this;
        }

        public Criteria andBakFld7IsNotNull() {
            addCriterion("bak_fld7 is not null");
            return (Criteria) this;
        }

        public Criteria andBakFld7EqualTo(String value) {
            addCriterion("bak_fld7 =", value, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7NotEqualTo(String value) {
            addCriterion("bak_fld7 <>", value, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7GreaterThan(String value) {
            addCriterion("bak_fld7 >", value, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7GreaterThanOrEqualTo(String value) {
            addCriterion("bak_fld7 >=", value, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7LessThan(String value) {
            addCriterion("bak_fld7 <", value, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7LessThanOrEqualTo(String value) {
            addCriterion("bak_fld7 <=", value, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7Like(String value) {
            addCriterion("bak_fld7 like", value, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7NotLike(String value) {
            addCriterion("bak_fld7 not like", value, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7In(List<String> values) {
            addCriterion("bak_fld7 in", values, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7NotIn(List<String> values) {
            addCriterion("bak_fld7 not in", values, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7Between(String value1, String value2) {
            addCriterion("bak_fld7 between", value1, value2, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andBakFld7NotBetween(String value1, String value2) {
            addCriterion("bak_fld7 not between", value1, value2, "bakFld7");
            return (Criteria) this;
        }

        public Criteria andLineNoLikeInsensitive(String value) {
            addCriterion("upper(line_no) like", value.toUpperCase(), "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNmeLikeInsensitive(String value) {
            addCriterion("upper(line_nme) like", value.toUpperCase(), "lineNme");
            return (Criteria) this;
        }

        public Criteria andLineEnNmeLikeInsensitive(String value) {
            addCriterion("upper(line_en_nme) like", value.toUpperCase(), "lineEnNme");
            return (Criteria) this;
        }

        public Criteria andLineColorLikeInsensitive(String value) {
            addCriterion("upper(line_color) like", value.toUpperCase(), "lineColor");
            return (Criteria) this;
        }

        public Criteria andLineDesLikeInsensitive(String value) {
            addCriterion("upper(line_des) like", value.toUpperCase(), "lineDes");
            return (Criteria) this;
        }

        public Criteria andBakFld1LikeInsensitive(String value) {
            addCriterion("upper(bak_fld1) like", value.toUpperCase(), "bakFld1");
            return (Criteria) this;
        }

        public Criteria andBakFld2LikeInsensitive(String value) {
            addCriterion("upper(bak_fld2) like", value.toUpperCase(), "bakFld2");
            return (Criteria) this;
        }

        public Criteria andBakFld3LikeInsensitive(String value) {
            addCriterion("upper(bak_fld3) like", value.toUpperCase(), "bakFld3");
            return (Criteria) this;
        }

        public Criteria andBakFld4LikeInsensitive(String value) {
            addCriterion("upper(bak_fld4) like", value.toUpperCase(), "bakFld4");
            return (Criteria) this;
        }

        public Criteria andBakFld5LikeInsensitive(String value) {
            addCriterion("upper(bak_fld5) like", value.toUpperCase(), "bakFld5");
            return (Criteria) this;
        }

        public Criteria andBakFld6LikeInsensitive(String value) {
            addCriterion("upper(bak_fld6) like", value.toUpperCase(), "bakFld6");
            return (Criteria) this;
        }

        public Criteria andBakFld7LikeInsensitive(String value) {
            addCriterion("upper(bak_fld7) like", value.toUpperCase(), "bakFld7");
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