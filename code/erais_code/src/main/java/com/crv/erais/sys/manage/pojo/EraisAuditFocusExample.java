package com.crv.erais.sys.manage.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EraisAuditFocusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EraisAuditFocusExample() {
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

        public Criteria andNumbberIsNull() {
            addCriterion("NUMBBER is null");
            return (Criteria) this;
        }

        public Criteria andNumbberIsNotNull() {
            addCriterion("NUMBBER is not null");
            return (Criteria) this;
        }

        public Criteria andNumbberEqualTo(String value) {
            addCriterion("NUMBBER =", value, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberNotEqualTo(String value) {
            addCriterion("NUMBBER <>", value, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberGreaterThan(String value) {
            addCriterion("NUMBBER >", value, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberGreaterThanOrEqualTo(String value) {
            addCriterion("NUMBBER >=", value, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberLessThan(String value) {
            addCriterion("NUMBBER <", value, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberLessThanOrEqualTo(String value) {
            addCriterion("NUMBBER <=", value, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberLike(String value) {
            addCriterion("NUMBBER like", value, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberNotLike(String value) {
            addCriterion("NUMBBER not like", value, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberIn(List<String> values) {
            addCriterion("NUMBBER in", values, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberNotIn(List<String> values) {
            addCriterion("NUMBBER not in", values, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberBetween(String value1, String value2) {
            addCriterion("NUMBBER between", value1, value2, "numbber");
            return (Criteria) this;
        }

        public Criteria andNumbberNotBetween(String value1, String value2) {
            addCriterion("NUMBBER not between", value1, value2, "numbber");
            return (Criteria) this;
        }

        public Criteria andFocusIsNull() {
            addCriterion("FOCUS is null");
            return (Criteria) this;
        }

        public Criteria andFocusIsNotNull() {
            addCriterion("FOCUS is not null");
            return (Criteria) this;
        }

        public Criteria andFocusEqualTo(String value) {
            addCriterion("FOCUS =", value, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusNotEqualTo(String value) {
            addCriterion("FOCUS <>", value, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusGreaterThan(String value) {
            addCriterion("FOCUS >", value, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusGreaterThanOrEqualTo(String value) {
            addCriterion("FOCUS >=", value, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusLessThan(String value) {
            addCriterion("FOCUS <", value, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusLessThanOrEqualTo(String value) {
            addCriterion("FOCUS <=", value, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusLike(String value) {
            addCriterion("FOCUS like", value, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusNotLike(String value) {
            addCriterion("FOCUS not like", value, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusIn(List<String> values) {
            addCriterion("FOCUS in", values, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusNotIn(List<String> values) {
            addCriterion("FOCUS not in", values, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusBetween(String value1, String value2) {
            addCriterion("FOCUS between", value1, value2, "focus");
            return (Criteria) this;
        }

        public Criteria andFocusNotBetween(String value1, String value2) {
            addCriterion("FOCUS not between", value1, value2, "focus");
            return (Criteria) this;
        }

        public Criteria andSystemIsNull() {
            addCriterion("SYSTEM is null");
            return (Criteria) this;
        }

        public Criteria andSystemIsNotNull() {
            addCriterion("SYSTEM is not null");
            return (Criteria) this;
        }

        public Criteria andSystemEqualTo(String value) {
            addCriterion("SYSTEM =", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotEqualTo(String value) {
            addCriterion("SYSTEM <>", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThan(String value) {
            addCriterion("SYSTEM >", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM >=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThan(String value) {
            addCriterion("SYSTEM <", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM <=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLike(String value) {
            addCriterion("SYSTEM like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotLike(String value) {
            addCriterion("SYSTEM not like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemIn(List<String> values) {
            addCriterion("SYSTEM in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotIn(List<String> values) {
            addCriterion("SYSTEM not in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemBetween(String value1, String value2) {
            addCriterion("SYSTEM between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotBetween(String value1, String value2) {
            addCriterion("SYSTEM not between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andIssuetimeIsNull() {
            addCriterion("ISSUETIME is null");
            return (Criteria) this;
        }

        public Criteria andIssuetimeIsNotNull() {
            addCriterion("ISSUETIME is not null");
            return (Criteria) this;
        }

        public Criteria andIssuetimeEqualTo(Date value) {
            addCriterion("ISSUETIME =", value, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeNotEqualTo(Date value) {
            addCriterion("ISSUETIME <>", value, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeGreaterThan(Date value) {
            addCriterion("ISSUETIME >", value, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ISSUETIME >=", value, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeLessThan(Date value) {
            addCriterion("ISSUETIME <", value, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeLessThanOrEqualTo(Date value) {
            addCriterion("ISSUETIME <=", value, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeIn(List<Date> values) {
            addCriterion("ISSUETIME in", values, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeNotIn(List<Date> values) {
            addCriterion("ISSUETIME not in", values, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeBetween(Date value1, Date value2) {
            addCriterion("ISSUETIME between", value1, value2, "issuetime");
            return (Criteria) this;
        }

        public Criteria andIssuetimeNotBetween(Date value1, Date value2) {
            addCriterion("ISSUETIME not between", value1, value2, "issuetime");
            return (Criteria) this;
        }

        public Criteria andRegimedigestIsNull() {
            addCriterion("REGIMEDIGEST is null");
            return (Criteria) this;
        }

        public Criteria andRegimedigestIsNotNull() {
            addCriterion("REGIMEDIGEST is not null");
            return (Criteria) this;
        }

        public Criteria andRegimedigestEqualTo(String value) {
            addCriterion("REGIMEDIGEST =", value, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestNotEqualTo(String value) {
            addCriterion("REGIMEDIGEST <>", value, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestGreaterThan(String value) {
            addCriterion("REGIMEDIGEST >", value, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestGreaterThanOrEqualTo(String value) {
            addCriterion("REGIMEDIGEST >=", value, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestLessThan(String value) {
            addCriterion("REGIMEDIGEST <", value, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestLessThanOrEqualTo(String value) {
            addCriterion("REGIMEDIGEST <=", value, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestLike(String value) {
            addCriterion("REGIMEDIGEST like", value, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestNotLike(String value) {
            addCriterion("REGIMEDIGEST not like", value, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestIn(List<String> values) {
            addCriterion("REGIMEDIGEST in", values, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestNotIn(List<String> values) {
            addCriterion("REGIMEDIGEST not in", values, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestBetween(String value1, String value2) {
            addCriterion("REGIMEDIGEST between", value1, value2, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andRegimedigestNotBetween(String value1, String value2) {
            addCriterion("REGIMEDIGEST not between", value1, value2, "regimedigest");
            return (Criteria) this;
        }

        public Criteria andFocusidIsNull() {
            addCriterion("FOCUSID is null");
            return (Criteria) this;
        }

        public Criteria andFocusidIsNotNull() {
            addCriterion("FOCUSID is not null");
            return (Criteria) this;
        }

        public Criteria andFocusidEqualTo(String value) {
            addCriterion("FOCUSID =", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotEqualTo(String value) {
            addCriterion("FOCUSID <>", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidGreaterThan(String value) {
            addCriterion("FOCUSID >", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidGreaterThanOrEqualTo(String value) {
            addCriterion("FOCUSID >=", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidLessThan(String value) {
            addCriterion("FOCUSID <", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidLessThanOrEqualTo(String value) {
            addCriterion("FOCUSID <=", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidLike(String value) {
            addCriterion("FOCUSID like", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotLike(String value) {
            addCriterion("FOCUSID not like", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidIn(List<String> values) {
            addCriterion("FOCUSID in", values, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotIn(List<String> values) {
            addCriterion("FOCUSID not in", values, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidBetween(String value1, String value2) {
            addCriterion("FOCUSID between", value1, value2, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotBetween(String value1, String value2) {
            addCriterion("FOCUSID not between", value1, value2, "focusid");
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