package com.nngdjt.pricemng.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuitemExample() {
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

        public Criteria andMenuitemnameIsNull() {
            addCriterion("menuItemName is null");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameIsNotNull() {
            addCriterion("menuItemName is not null");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameEqualTo(String value) {
            addCriterion("menuItemName =", value, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameNotEqualTo(String value) {
            addCriterion("menuItemName <>", value, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameGreaterThan(String value) {
            addCriterion("menuItemName >", value, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameGreaterThanOrEqualTo(String value) {
            addCriterion("menuItemName >=", value, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameLessThan(String value) {
            addCriterion("menuItemName <", value, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameLessThanOrEqualTo(String value) {
            addCriterion("menuItemName <=", value, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameLike(String value) {
            addCriterion("menuItemName like", value, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameNotLike(String value) {
            addCriterion("menuItemName not like", value, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameIn(List<String> values) {
            addCriterion("menuItemName in", values, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameNotIn(List<String> values) {
            addCriterion("menuItemName not in", values, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameBetween(String value1, String value2) {
            addCriterion("menuItemName between", value1, value2, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameNotBetween(String value1, String value2) {
            addCriterion("menuItemName not between", value1, value2, "menuitemname");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNull() {
            addCriterion("isParent is null");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNotNull() {
            addCriterion("isParent is not null");
            return (Criteria) this;
        }

        public Criteria andIsparentEqualTo(Integer value) {
            addCriterion("isParent =", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotEqualTo(Integer value) {
            addCriterion("isParent <>", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThan(Integer value) {
            addCriterion("isParent >", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThanOrEqualTo(Integer value) {
            addCriterion("isParent >=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThan(Integer value) {
            addCriterion("isParent <", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThanOrEqualTo(Integer value) {
            addCriterion("isParent <=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentIn(List<Integer> values) {
            addCriterion("isParent in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotIn(List<Integer> values) {
            addCriterion("isParent not in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentBetween(Integer value1, Integer value2) {
            addCriterion("isParent between", value1, value2, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotBetween(Integer value1, Integer value2) {
            addCriterion("isParent not between", value1, value2, "isparent");
            return (Criteria) this;
        }

        public Criteria andParentIsNull() {
            addCriterion("parent is null");
            return (Criteria) this;
        }

        public Criteria andParentIsNotNull() {
            addCriterion("parent is not null");
            return (Criteria) this;
        }

        public Criteria andParentEqualTo(Long value) {
            addCriterion("parent =", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotEqualTo(Long value) {
            addCriterion("parent <>", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThan(Long value) {
            addCriterion("parent >", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThanOrEqualTo(Long value) {
            addCriterion("parent >=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThan(Long value) {
            addCriterion("parent <", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThanOrEqualTo(Long value) {
            addCriterion("parent <=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentIn(List<Long> values) {
            addCriterion("parent in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotIn(List<Long> values) {
            addCriterion("parent not in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentBetween(Long value1, Long value2) {
            addCriterion("parent between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotBetween(Long value1, Long value2) {
            addCriterion("parent not between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andMenuitemnameLikeInsensitive(String value) {
            addCriterion("upper(menuItemName) like", value.toUpperCase(), "menuitemname");
            return (Criteria) this;
        }

        public Criteria andUrlLikeInsensitive(String value) {
            addCriterion("upper(url) like", value.toUpperCase(), "url");
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