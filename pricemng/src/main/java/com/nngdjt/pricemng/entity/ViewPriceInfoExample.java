package com.nngdjt.pricemng.entity;

import java.util.ArrayList;
import java.util.List;

public class ViewPriceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewPriceInfoExample() {
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIsNull() {
            addCriterion("audit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIsNotNull() {
            addCriterion("audit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdEqualTo(String value) {
            addCriterion("audit_user_id =", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotEqualTo(String value) {
            addCriterion("audit_user_id <>", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdGreaterThan(String value) {
            addCriterion("audit_user_id >", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("audit_user_id >=", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLessThan(String value) {
            addCriterion("audit_user_id <", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLessThanOrEqualTo(String value) {
            addCriterion("audit_user_id <=", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLike(String value) {
            addCriterion("audit_user_id like", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotLike(String value) {
            addCriterion("audit_user_id not like", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIn(List<String> values) {
            addCriterion("audit_user_id in", values, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotIn(List<String> values) {
            addCriterion("audit_user_id not in", values, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdBetween(String value1, String value2) {
            addCriterion("audit_user_id between", value1, value2, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotBetween(String value1, String value2) {
            addCriterion("audit_user_id not between", value1, value2, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameIsNull() {
            addCriterion("audit_username is null");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameIsNotNull() {
            addCriterion("audit_username is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameEqualTo(String value) {
            addCriterion("audit_username =", value, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameNotEqualTo(String value) {
            addCriterion("audit_username <>", value, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameGreaterThan(String value) {
            addCriterion("audit_username >", value, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("audit_username >=", value, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameLessThan(String value) {
            addCriterion("audit_username <", value, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameLessThanOrEqualTo(String value) {
            addCriterion("audit_username <=", value, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameLike(String value) {
            addCriterion("audit_username like", value, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameNotLike(String value) {
            addCriterion("audit_username not like", value, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameIn(List<String> values) {
            addCriterion("audit_username in", values, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameNotIn(List<String> values) {
            addCriterion("audit_username not in", values, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameBetween(String value1, String value2) {
            addCriterion("audit_username between", value1, value2, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameNotBetween(String value1, String value2) {
            addCriterion("audit_username not between", value1, value2, "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameIsNull() {
            addCriterion("audit_realusername is null");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameIsNotNull() {
            addCriterion("audit_realusername is not null");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameEqualTo(String value) {
            addCriterion("audit_realusername =", value, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameNotEqualTo(String value) {
            addCriterion("audit_realusername <>", value, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameGreaterThan(String value) {
            addCriterion("audit_realusername >", value, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameGreaterThanOrEqualTo(String value) {
            addCriterion("audit_realusername >=", value, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameLessThan(String value) {
            addCriterion("audit_realusername <", value, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameLessThanOrEqualTo(String value) {
            addCriterion("audit_realusername <=", value, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameLike(String value) {
            addCriterion("audit_realusername like", value, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameNotLike(String value) {
            addCriterion("audit_realusername not like", value, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameIn(List<String> values) {
            addCriterion("audit_realusername in", values, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameNotIn(List<String> values) {
            addCriterion("audit_realusername not in", values, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameBetween(String value1, String value2) {
            addCriterion("audit_realusername between", value1, value2, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameNotBetween(String value1, String value2) {
            addCriterion("audit_realusername not between", value1, value2, "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditFlgIsNull() {
            addCriterion("audit_flg is null");
            return (Criteria) this;
        }

        public Criteria andAuditFlgIsNotNull() {
            addCriterion("audit_flg is not null");
            return (Criteria) this;
        }

        public Criteria andAuditFlgEqualTo(String value) {
            addCriterion("audit_flg =", value, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgNotEqualTo(String value) {
            addCriterion("audit_flg <>", value, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgGreaterThan(String value) {
            addCriterion("audit_flg >", value, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgGreaterThanOrEqualTo(String value) {
            addCriterion("audit_flg >=", value, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgLessThan(String value) {
            addCriterion("audit_flg <", value, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgLessThanOrEqualTo(String value) {
            addCriterion("audit_flg <=", value, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgLike(String value) {
            addCriterion("audit_flg like", value, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgNotLike(String value) {
            addCriterion("audit_flg not like", value, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgIn(List<String> values) {
            addCriterion("audit_flg in", values, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgNotIn(List<String> values) {
            addCriterion("audit_flg not in", values, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgBetween(String value1, String value2) {
            addCriterion("audit_flg between", value1, value2, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditFlgNotBetween(String value1, String value2) {
            addCriterion("audit_flg not between", value1, value2, "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNull() {
            addCriterion("audit_date is null");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNotNull() {
            addCriterion("audit_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDateEqualTo(String value) {
            addCriterion("audit_date =", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotEqualTo(String value) {
            addCriterion("audit_date <>", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThan(String value) {
            addCriterion("audit_date >", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThanOrEqualTo(String value) {
            addCriterion("audit_date >=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThan(String value) {
            addCriterion("audit_date <", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThanOrEqualTo(String value) {
            addCriterion("audit_date <=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLike(String value) {
            addCriterion("audit_date like", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotLike(String value) {
            addCriterion("audit_date not like", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateIn(List<String> values) {
            addCriterion("audit_date in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotIn(List<String> values) {
            addCriterion("audit_date not in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateBetween(String value1, String value2) {
            addCriterion("audit_date between", value1, value2, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotBetween(String value1, String value2) {
            addCriterion("audit_date not between", value1, value2, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditTmeIsNull() {
            addCriterion("audit_tme is null");
            return (Criteria) this;
        }

        public Criteria andAuditTmeIsNotNull() {
            addCriterion("audit_tme is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTmeEqualTo(String value) {
            addCriterion("audit_tme =", value, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeNotEqualTo(String value) {
            addCriterion("audit_tme <>", value, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeGreaterThan(String value) {
            addCriterion("audit_tme >", value, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeGreaterThanOrEqualTo(String value) {
            addCriterion("audit_tme >=", value, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeLessThan(String value) {
            addCriterion("audit_tme <", value, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeLessThanOrEqualTo(String value) {
            addCriterion("audit_tme <=", value, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeLike(String value) {
            addCriterion("audit_tme like", value, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeNotLike(String value) {
            addCriterion("audit_tme not like", value, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeIn(List<String> values) {
            addCriterion("audit_tme in", values, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeNotIn(List<String> values) {
            addCriterion("audit_tme not in", values, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeBetween(String value1, String value2) {
            addCriterion("audit_tme between", value1, value2, "auditTme");
            return (Criteria) this;
        }

        public Criteria andAuditTmeNotBetween(String value1, String value2) {
            addCriterion("audit_tme not between", value1, value2, "auditTme");
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

        public Criteria andPriceLikeInsensitive(String value) {
            addCriterion("upper(price) like", value.toUpperCase(), "price");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLikeInsensitive(String value) {
            addCriterion("upper(audit_user_id) like", value.toUpperCase(), "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUsernameLikeInsensitive(String value) {
            addCriterion("upper(audit_username) like", value.toUpperCase(), "auditUsername");
            return (Criteria) this;
        }

        public Criteria andAuditRealusernameLikeInsensitive(String value) {
            addCriterion("upper(audit_realusername) like", value.toUpperCase(), "auditRealusername");
            return (Criteria) this;
        }

        public Criteria andAuditFlgLikeInsensitive(String value) {
            addCriterion("upper(audit_flg) like", value.toUpperCase(), "auditFlg");
            return (Criteria) this;
        }

        public Criteria andAuditDateLikeInsensitive(String value) {
            addCriterion("upper(audit_date) like", value.toUpperCase(), "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditTmeLikeInsensitive(String value) {
            addCriterion("upper(audit_tme) like", value.toUpperCase(), "auditTme");
            return (Criteria) this;
        }

        public Criteria andBakFld1LikeInsensitive(String value) {
            addCriterion("upper(bak_fld1) like", value.toUpperCase(), "bakFld1");
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