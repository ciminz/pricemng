package com.nngdjt.pricemng.entity;

import java.util.ArrayList;
import java.util.List;

public class StationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StationInfoExample() {
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

        public Criteria andStationNoIsNull() {
            addCriterion("station_no is null");
            return (Criteria) this;
        }

        public Criteria andStationNoIsNotNull() {
            addCriterion("station_no is not null");
            return (Criteria) this;
        }

        public Criteria andStationNoEqualTo(String value) {
            addCriterion("station_no =", value, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoNotEqualTo(String value) {
            addCriterion("station_no <>", value, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoGreaterThan(String value) {
            addCriterion("station_no >", value, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoGreaterThanOrEqualTo(String value) {
            addCriterion("station_no >=", value, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoLessThan(String value) {
            addCriterion("station_no <", value, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoLessThanOrEqualTo(String value) {
            addCriterion("station_no <=", value, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoLike(String value) {
            addCriterion("station_no like", value, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoNotLike(String value) {
            addCriterion("station_no not like", value, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoIn(List<String> values) {
            addCriterion("station_no in", values, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoNotIn(List<String> values) {
            addCriterion("station_no not in", values, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoBetween(String value1, String value2) {
            addCriterion("station_no between", value1, value2, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNoNotBetween(String value1, String value2) {
            addCriterion("station_no not between", value1, value2, "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNmeIsNull() {
            addCriterion("station_nme is null");
            return (Criteria) this;
        }

        public Criteria andStationNmeIsNotNull() {
            addCriterion("station_nme is not null");
            return (Criteria) this;
        }

        public Criteria andStationNmeEqualTo(String value) {
            addCriterion("station_nme =", value, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeNotEqualTo(String value) {
            addCriterion("station_nme <>", value, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeGreaterThan(String value) {
            addCriterion("station_nme >", value, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeGreaterThanOrEqualTo(String value) {
            addCriterion("station_nme >=", value, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeLessThan(String value) {
            addCriterion("station_nme <", value, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeLessThanOrEqualTo(String value) {
            addCriterion("station_nme <=", value, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeLike(String value) {
            addCriterion("station_nme like", value, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeNotLike(String value) {
            addCriterion("station_nme not like", value, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeIn(List<String> values) {
            addCriterion("station_nme in", values, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeNotIn(List<String> values) {
            addCriterion("station_nme not in", values, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeBetween(String value1, String value2) {
            addCriterion("station_nme between", value1, value2, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationNmeNotBetween(String value1, String value2) {
            addCriterion("station_nme not between", value1, value2, "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeIsNull() {
            addCriterion("station_en_nme is null");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeIsNotNull() {
            addCriterion("station_en_nme is not null");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeEqualTo(String value) {
            addCriterion("station_en_nme =", value, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeNotEqualTo(String value) {
            addCriterion("station_en_nme <>", value, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeGreaterThan(String value) {
            addCriterion("station_en_nme >", value, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeGreaterThanOrEqualTo(String value) {
            addCriterion("station_en_nme >=", value, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeLessThan(String value) {
            addCriterion("station_en_nme <", value, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeLessThanOrEqualTo(String value) {
            addCriterion("station_en_nme <=", value, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeLike(String value) {
            addCriterion("station_en_nme like", value, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeNotLike(String value) {
            addCriterion("station_en_nme not like", value, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeIn(List<String> values) {
            addCriterion("station_en_nme in", values, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeNotIn(List<String> values) {
            addCriterion("station_en_nme not in", values, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeBetween(String value1, String value2) {
            addCriterion("station_en_nme between", value1, value2, "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeNotBetween(String value1, String value2) {
            addCriterion("station_en_nme not between", value1, value2, "stationEnNme");
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

        public Criteria andLocationXIsNull() {
            addCriterion("location_x is null");
            return (Criteria) this;
        }

        public Criteria andLocationXIsNotNull() {
            addCriterion("location_x is not null");
            return (Criteria) this;
        }

        public Criteria andLocationXEqualTo(String value) {
            addCriterion("location_x =", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXNotEqualTo(String value) {
            addCriterion("location_x <>", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXGreaterThan(String value) {
            addCriterion("location_x >", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXGreaterThanOrEqualTo(String value) {
            addCriterion("location_x >=", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXLessThan(String value) {
            addCriterion("location_x <", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXLessThanOrEqualTo(String value) {
            addCriterion("location_x <=", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXLike(String value) {
            addCriterion("location_x like", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXNotLike(String value) {
            addCriterion("location_x not like", value, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXIn(List<String> values) {
            addCriterion("location_x in", values, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXNotIn(List<String> values) {
            addCriterion("location_x not in", values, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXBetween(String value1, String value2) {
            addCriterion("location_x between", value1, value2, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationXNotBetween(String value1, String value2) {
            addCriterion("location_x not between", value1, value2, "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationYIsNull() {
            addCriterion("location_y is null");
            return (Criteria) this;
        }

        public Criteria andLocationYIsNotNull() {
            addCriterion("location_y is not null");
            return (Criteria) this;
        }

        public Criteria andLocationYEqualTo(String value) {
            addCriterion("location_y =", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYNotEqualTo(String value) {
            addCriterion("location_y <>", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYGreaterThan(String value) {
            addCriterion("location_y >", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYGreaterThanOrEqualTo(String value) {
            addCriterion("location_y >=", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYLessThan(String value) {
            addCriterion("location_y <", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYLessThanOrEqualTo(String value) {
            addCriterion("location_y <=", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYLike(String value) {
            addCriterion("location_y like", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYNotLike(String value) {
            addCriterion("location_y not like", value, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYIn(List<String> values) {
            addCriterion("location_y in", values, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYNotIn(List<String> values) {
            addCriterion("location_y not in", values, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYBetween(String value1, String value2) {
            addCriterion("location_y between", value1, value2, "locationY");
            return (Criteria) this;
        }

        public Criteria andLocationYNotBetween(String value1, String value2) {
            addCriterion("location_y not between", value1, value2, "locationY");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgIsNull() {
            addCriterion("exchange_flg is null");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgIsNotNull() {
            addCriterion("exchange_flg is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgEqualTo(String value) {
            addCriterion("exchange_flg =", value, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgNotEqualTo(String value) {
            addCriterion("exchange_flg <>", value, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgGreaterThan(String value) {
            addCriterion("exchange_flg >", value, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_flg >=", value, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgLessThan(String value) {
            addCriterion("exchange_flg <", value, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgLessThanOrEqualTo(String value) {
            addCriterion("exchange_flg <=", value, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgLike(String value) {
            addCriterion("exchange_flg like", value, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgNotLike(String value) {
            addCriterion("exchange_flg not like", value, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgIn(List<String> values) {
            addCriterion("exchange_flg in", values, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgNotIn(List<String> values) {
            addCriterion("exchange_flg not in", values, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgBetween(String value1, String value2) {
            addCriterion("exchange_flg between", value1, value2, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgNotBetween(String value1, String value2) {
            addCriterion("exchange_flg not between", value1, value2, "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoIsNull() {
            addCriterion("exchange_st_no is null");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoIsNotNull() {
            addCriterion("exchange_st_no is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoEqualTo(String value) {
            addCriterion("exchange_st_no =", value, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoNotEqualTo(String value) {
            addCriterion("exchange_st_no <>", value, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoGreaterThan(String value) {
            addCriterion("exchange_st_no >", value, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_st_no >=", value, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoLessThan(String value) {
            addCriterion("exchange_st_no <", value, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoLessThanOrEqualTo(String value) {
            addCriterion("exchange_st_no <=", value, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoLike(String value) {
            addCriterion("exchange_st_no like", value, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoNotLike(String value) {
            addCriterion("exchange_st_no not like", value, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoIn(List<String> values) {
            addCriterion("exchange_st_no in", values, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoNotIn(List<String> values) {
            addCriterion("exchange_st_no not in", values, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoBetween(String value1, String value2) {
            addCriterion("exchange_st_no between", value1, value2, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoNotBetween(String value1, String value2) {
            addCriterion("exchange_st_no not between", value1, value2, "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoIsNull() {
            addCriterion("exchange_st_li_no is null");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoIsNotNull() {
            addCriterion("exchange_st_li_no is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoEqualTo(String value) {
            addCriterion("exchange_st_li_no =", value, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoNotEqualTo(String value) {
            addCriterion("exchange_st_li_no <>", value, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoGreaterThan(String value) {
            addCriterion("exchange_st_li_no >", value, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_st_li_no >=", value, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoLessThan(String value) {
            addCriterion("exchange_st_li_no <", value, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoLessThanOrEqualTo(String value) {
            addCriterion("exchange_st_li_no <=", value, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoLike(String value) {
            addCriterion("exchange_st_li_no like", value, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoNotLike(String value) {
            addCriterion("exchange_st_li_no not like", value, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoIn(List<String> values) {
            addCriterion("exchange_st_li_no in", values, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoNotIn(List<String> values) {
            addCriterion("exchange_st_li_no not in", values, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoBetween(String value1, String value2) {
            addCriterion("exchange_st_li_no between", value1, value2, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoNotBetween(String value1, String value2) {
            addCriterion("exchange_st_li_no not between", value1, value2, "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andStationDesIsNull() {
            addCriterion("station_des is null");
            return (Criteria) this;
        }

        public Criteria andStationDesIsNotNull() {
            addCriterion("station_des is not null");
            return (Criteria) this;
        }

        public Criteria andStationDesEqualTo(String value) {
            addCriterion("station_des =", value, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesNotEqualTo(String value) {
            addCriterion("station_des <>", value, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesGreaterThan(String value) {
            addCriterion("station_des >", value, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesGreaterThanOrEqualTo(String value) {
            addCriterion("station_des >=", value, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesLessThan(String value) {
            addCriterion("station_des <", value, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesLessThanOrEqualTo(String value) {
            addCriterion("station_des <=", value, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesLike(String value) {
            addCriterion("station_des like", value, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesNotLike(String value) {
            addCriterion("station_des not like", value, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesIn(List<String> values) {
            addCriterion("station_des in", values, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesNotIn(List<String> values) {
            addCriterion("station_des not in", values, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesBetween(String value1, String value2) {
            addCriterion("station_des between", value1, value2, "stationDes");
            return (Criteria) this;
        }

        public Criteria andStationDesNotBetween(String value1, String value2) {
            addCriterion("station_des not between", value1, value2, "stationDes");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNull() {
            addCriterion("sort_id is null");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNotNull() {
            addCriterion("sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andSortIdEqualTo(String value) {
            addCriterion("sort_id =", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotEqualTo(String value) {
            addCriterion("sort_id <>", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThan(String value) {
            addCriterion("sort_id >", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThanOrEqualTo(String value) {
            addCriterion("sort_id >=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThan(String value) {
            addCriterion("sort_id <", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThanOrEqualTo(String value) {
            addCriterion("sort_id <=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLike(String value) {
            addCriterion("sort_id like", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotLike(String value) {
            addCriterion("sort_id not like", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdIn(List<String> values) {
            addCriterion("sort_id in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotIn(List<String> values) {
            addCriterion("sort_id not in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdBetween(String value1, String value2) {
            addCriterion("sort_id between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotBetween(String value1, String value2) {
            addCriterion("sort_id not between", value1, value2, "sortId");
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

        public Criteria andStationNoLikeInsensitive(String value) {
            addCriterion("upper(station_no) like", value.toUpperCase(), "stationNo");
            return (Criteria) this;
        }

        public Criteria andStationNmeLikeInsensitive(String value) {
            addCriterion("upper(station_nme) like", value.toUpperCase(), "stationNme");
            return (Criteria) this;
        }

        public Criteria andStationEnNmeLikeInsensitive(String value) {
            addCriterion("upper(station_en_nme) like", value.toUpperCase(), "stationEnNme");
            return (Criteria) this;
        }

        public Criteria andLineNoLikeInsensitive(String value) {
            addCriterion("upper(line_no) like", value.toUpperCase(), "lineNo");
            return (Criteria) this;
        }

        public Criteria andLocationXLikeInsensitive(String value) {
            addCriterion("upper(location_x) like", value.toUpperCase(), "locationX");
            return (Criteria) this;
        }

        public Criteria andLocationYLikeInsensitive(String value) {
            addCriterion("upper(location_y) like", value.toUpperCase(), "locationY");
            return (Criteria) this;
        }

        public Criteria andExchangeFlgLikeInsensitive(String value) {
            addCriterion("upper(exchange_flg) like", value.toUpperCase(), "exchangeFlg");
            return (Criteria) this;
        }

        public Criteria andExchangeStNoLikeInsensitive(String value) {
            addCriterion("upper(exchange_st_no) like", value.toUpperCase(), "exchangeStNo");
            return (Criteria) this;
        }

        public Criteria andExchangeStLiNoLikeInsensitive(String value) {
            addCriterion("upper(exchange_st_li_no) like", value.toUpperCase(), "exchangeStLiNo");
            return (Criteria) this;
        }

        public Criteria andStationDesLikeInsensitive(String value) {
            addCriterion("upper(station_des) like", value.toUpperCase(), "stationDes");
            return (Criteria) this;
        }

        public Criteria andSortIdLikeInsensitive(String value) {
            addCriterion("upper(sort_id) like", value.toUpperCase(), "sortId");
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