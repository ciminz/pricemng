package com.nngdjt.pricemng.entity;

import java.util.ArrayList;
import java.util.List;

public class DistanceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DistanceInfoExample() {
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

        public Criteria andOriStationNoLikeInsensitive(String value) {
            addCriterion("upper(ori_station_no) like", value.toUpperCase(), "oriStationNo");
            return (Criteria) this;
        }

        public Criteria andDesStationNoLikeInsensitive(String value) {
            addCriterion("upper(des_station_no) like", value.toUpperCase(), "desStationNo");
            return (Criteria) this;
        }

        public Criteria andDistanceLikeInsensitive(String value) {
            addCriterion("upper(distance) like", value.toUpperCase(), "distance");
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