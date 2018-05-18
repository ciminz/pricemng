package com.nngdjt.pricemng.entity;

import java.util.ArrayList;
import java.util.List;

public class ViewStationDistanceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewStationDistanceInfoExample() {
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

        public Criteria andOriStationNoIsNull() {
            addCriterion("ori_station_no is null");
            return (Criteria) this;
        }

        public Criteria andOriStationNoIsNotNull() {
            addCriterion("ori_station_no is not null");
            return (Criteria) this;
        }

        public Criteria andOriStationNoEqualTo(String value) {
            addCriterion("ori_station_no =", value, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoNotEqualTo(String value) {
            addCriterion("ori_station_no <>", value, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoGreaterThan(String value) {
            addCriterion("ori_station_no >", value, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoGreaterThanOrEqualTo(String value) {
            addCriterion("ori_station_no >=", value, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoLessThan(String value) {
            addCriterion("ori_station_no <", value, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoLessThanOrEqualTo(String value) {
            addCriterion("ori_station_no <=", value, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoLike(String value) {
            addCriterion("ori_station_no like", value, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoNotLike(String value) {
            addCriterion("ori_station_no not like", value, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoIn(List<String> values) {
            addCriterion("ori_station_no in", values, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoNotIn(List<String> values) {
            addCriterion("ori_station_no not in", values, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoBetween(String value1, String value2) {
            addCriterion("ori_station_no between", value1, value2, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNoNotBetween(String value1, String value2) {
            addCriterion("ori_station_no not between", value1, value2, "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeIsNull() {
            addCriterion("ori_station_nme is null");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeIsNotNull() {
            addCriterion("ori_station_nme is not null");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeEqualTo(String value) {
            addCriterion("ori_station_nme =", value, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeNotEqualTo(String value) {
            addCriterion("ori_station_nme <>", value, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeGreaterThan(String value) {
            addCriterion("ori_station_nme >", value, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeGreaterThanOrEqualTo(String value) {
            addCriterion("ori_station_nme >=", value, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeLessThan(String value) {
            addCriterion("ori_station_nme <", value, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeLessThanOrEqualTo(String value) {
            addCriterion("ori_station_nme <=", value, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeLike(String value) {
            addCriterion("ori_station_nme like", value, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeNotLike(String value) {
            addCriterion("ori_station_nme not like", value, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeIn(List<String> values) {
            addCriterion("ori_station_nme in", values, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeNotIn(List<String> values) {
            addCriterion("ori_station_nme not in", values, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeBetween(String value1, String value2) {
            addCriterion("ori_station_nme between", value1, value2, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeNotBetween(String value1, String value2) {
            addCriterion("ori_station_nme not between", value1, value2, "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNoIsNull() {
            addCriterion("des_station_no is null");
            return (Criteria) this;
        }

        public Criteria andDesStationNoIsNotNull() {
            addCriterion("des_station_no is not null");
            return (Criteria) this;
        }

        public Criteria andDesStationNoEqualTo(String value) {
            addCriterion("des_station_no =", value, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoNotEqualTo(String value) {
            addCriterion("des_station_no <>", value, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoGreaterThan(String value) {
            addCriterion("des_station_no >", value, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoGreaterThanOrEqualTo(String value) {
            addCriterion("des_station_no >=", value, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoLessThan(String value) {
            addCriterion("des_station_no <", value, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoLessThanOrEqualTo(String value) {
            addCriterion("des_station_no <=", value, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoLike(String value) {
            addCriterion("des_station_no like", value, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoNotLike(String value) {
            addCriterion("des_station_no not like", value, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoIn(List<String> values) {
            addCriterion("des_station_no in", values, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoNotIn(List<String> values) {
            addCriterion("des_station_no not in", values, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoBetween(String value1, String value2) {
            addCriterion("des_station_no between", value1, value2, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoNotBetween(String value1, String value2) {
            addCriterion("des_station_no not between", value1, value2, "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeIsNull() {
            addCriterion("des_station_nme is null");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeIsNotNull() {
            addCriterion("des_station_nme is not null");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeEqualTo(String value) {
            addCriterion("des_station_nme =", value, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeNotEqualTo(String value) {
            addCriterion("des_station_nme <>", value, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeGreaterThan(String value) {
            addCriterion("des_station_nme >", value, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeGreaterThanOrEqualTo(String value) {
            addCriterion("des_station_nme >=", value, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeLessThan(String value) {
            addCriterion("des_station_nme <", value, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeLessThanOrEqualTo(String value) {
            addCriterion("des_station_nme <=", value, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeLike(String value) {
            addCriterion("des_station_nme like", value, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeNotLike(String value) {
            addCriterion("des_station_nme not like", value, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeIn(List<String> values) {
            addCriterion("des_station_nme in", values, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeNotIn(List<String> values) {
            addCriterion("des_station_nme not in", values, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeBetween(String value1, String value2) {
            addCriterion("des_station_nme between", value1, value2, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeNotBetween(String value1, String value2) {
            addCriterion("des_station_nme not between", value1, value2, "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(String value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(String value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(String value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(String value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(String value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(String value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLike(String value) {
            addCriterion("distance like", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotLike(String value) {
            addCriterion("distance not like", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<String> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<String> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(String value1, String value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(String value1, String value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andOriStationNoLikeInsensitive(String value) {
            addCriterion("upper(ori_station_no) like", value.toUpperCase(), "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andOriStationNmeLikeInsensitive(String value) {
            addCriterion("upper(ori_station_nme) like", value.toUpperCase(), "oriStationNme");
            return (Criteria) this;
        }

        public Criteria andDesStationNoLikeInsensitive(String value) {
            addCriterion("upper(des_station_no) like", value.toUpperCase(), "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNmeLikeInsensitive(String value) {
            addCriterion("upper(des_station_nme) like", value.toUpperCase(), "desStationNme");
            return (Criteria) this;
        }

        public Criteria andDistanceLikeInsensitive(String value) {
            addCriterion("upper(distance) like", value.toUpperCase(), "distance");
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