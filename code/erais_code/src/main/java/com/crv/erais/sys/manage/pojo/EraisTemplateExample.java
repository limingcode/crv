package com.crv.erais.sys.manage.pojo;

import java.util.ArrayList;
import java.util.List;

public class EraisTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EraisTemplateExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Short value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Short value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Short value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Short value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Short value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Short value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Short> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Short> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Short value1, Short value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Short value1, Short value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andClasssIsNull() {
            addCriterion("CLASSS is null");
            return (Criteria) this;
        }

        public Criteria andClasssIsNotNull() {
            addCriterion("CLASSS is not null");
            return (Criteria) this;
        }

        public Criteria andClasssEqualTo(String value) {
            addCriterion("CLASSS =", value, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssNotEqualTo(String value) {
            addCriterion("CLASSS <>", value, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssGreaterThan(String value) {
            addCriterion("CLASSS >", value, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssGreaterThanOrEqualTo(String value) {
            addCriterion("CLASSS >=", value, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssLessThan(String value) {
            addCriterion("CLASSS <", value, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssLessThanOrEqualTo(String value) {
            addCriterion("CLASSS <=", value, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssLike(String value) {
            addCriterion("CLASSS like", value, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssNotLike(String value) {
            addCriterion("CLASSS not like", value, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssIn(List<String> values) {
            addCriterion("CLASSS in", values, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssNotIn(List<String> values) {
            addCriterion("CLASSS not in", values, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssBetween(String value1, String value2) {
            addCriterion("CLASSS between", value1, value2, "classs");
            return (Criteria) this;
        }

        public Criteria andClasssNotBetween(String value1, String value2) {
            addCriterion("CLASSS not between", value1, value2, "classs");
            return (Criteria) this;
        }

        public Criteria andDecrIsNull() {
            addCriterion("DECR is null");
            return (Criteria) this;
        }

        public Criteria andDecrIsNotNull() {
            addCriterion("DECR is not null");
            return (Criteria) this;
        }

        public Criteria andDecrEqualTo(String value) {
            addCriterion("DECR =", value, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrNotEqualTo(String value) {
            addCriterion("DECR <>", value, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrGreaterThan(String value) {
            addCriterion("DECR >", value, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrGreaterThanOrEqualTo(String value) {
            addCriterion("DECR >=", value, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrLessThan(String value) {
            addCriterion("DECR <", value, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrLessThanOrEqualTo(String value) {
            addCriterion("DECR <=", value, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrLike(String value) {
            addCriterion("DECR like", value, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrNotLike(String value) {
            addCriterion("DECR not like", value, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrIn(List<String> values) {
            addCriterion("DECR in", values, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrNotIn(List<String> values) {
            addCriterion("DECR not in", values, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrBetween(String value1, String value2) {
            addCriterion("DECR between", value1, value2, "decr");
            return (Criteria) this;
        }

        public Criteria andDecrNotBetween(String value1, String value2) {
            addCriterion("DECR not between", value1, value2, "decr");
            return (Criteria) this;
        }

        public Criteria andExampleIsNull() {
            addCriterion("EXAMPLE is null");
            return (Criteria) this;
        }

        public Criteria andExampleIsNotNull() {
            addCriterion("EXAMPLE is not null");
            return (Criteria) this;
        }

        public Criteria andExampleEqualTo(String value) {
            addCriterion("EXAMPLE =", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleNotEqualTo(String value) {
            addCriterion("EXAMPLE <>", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleGreaterThan(String value) {
            addCriterion("EXAMPLE >", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMPLE >=", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleLessThan(String value) {
            addCriterion("EXAMPLE <", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleLessThanOrEqualTo(String value) {
            addCriterion("EXAMPLE <=", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleLike(String value) {
            addCriterion("EXAMPLE like", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleNotLike(String value) {
            addCriterion("EXAMPLE not like", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleIn(List<String> values) {
            addCriterion("EXAMPLE in", values, "example");
            return (Criteria) this;
        }

        public Criteria andExampleNotIn(List<String> values) {
            addCriterion("EXAMPLE not in", values, "example");
            return (Criteria) this;
        }

        public Criteria andExampleBetween(String value1, String value2) {
            addCriterion("EXAMPLE between", value1, value2, "example");
            return (Criteria) this;
        }

        public Criteria andExampleNotBetween(String value1, String value2) {
            addCriterion("EXAMPLE not between", value1, value2, "example");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMonadlevelIsNull() {
            addCriterion("MONADLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andMonadlevelIsNotNull() {
            addCriterion("MONADLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andMonadlevelEqualTo(String value) {
            addCriterion("MONADLEVEL =", value, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelNotEqualTo(String value) {
            addCriterion("MONADLEVEL <>", value, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelGreaterThan(String value) {
            addCriterion("MONADLEVEL >", value, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelGreaterThanOrEqualTo(String value) {
            addCriterion("MONADLEVEL >=", value, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelLessThan(String value) {
            addCriterion("MONADLEVEL <", value, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelLessThanOrEqualTo(String value) {
            addCriterion("MONADLEVEL <=", value, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelLike(String value) {
            addCriterion("MONADLEVEL like", value, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelNotLike(String value) {
            addCriterion("MONADLEVEL not like", value, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelIn(List<String> values) {
            addCriterion("MONADLEVEL in", values, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelNotIn(List<String> values) {
            addCriterion("MONADLEVEL not in", values, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelBetween(String value1, String value2) {
            addCriterion("MONADLEVEL between", value1, value2, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andMonadlevelNotBetween(String value1, String value2) {
            addCriterion("MONADLEVEL not between", value1, value2, "monadlevel");
            return (Criteria) this;
        }

        public Criteria andProjectclassIsNull() {
            addCriterion("PROJECTCLASS is null");
            return (Criteria) this;
        }

        public Criteria andProjectclassIsNotNull() {
            addCriterion("PROJECTCLASS is not null");
            return (Criteria) this;
        }

        public Criteria andProjectclassEqualTo(String value) {
            addCriterion("PROJECTCLASS =", value, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassNotEqualTo(String value) {
            addCriterion("PROJECTCLASS <>", value, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassGreaterThan(String value) {
            addCriterion("PROJECTCLASS >", value, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECTCLASS >=", value, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassLessThan(String value) {
            addCriterion("PROJECTCLASS <", value, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassLessThanOrEqualTo(String value) {
            addCriterion("PROJECTCLASS <=", value, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassLike(String value) {
            addCriterion("PROJECTCLASS like", value, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassNotLike(String value) {
            addCriterion("PROJECTCLASS not like", value, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassIn(List<String> values) {
            addCriterion("PROJECTCLASS in", values, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassNotIn(List<String> values) {
            addCriterion("PROJECTCLASS not in", values, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassBetween(String value1, String value2) {
            addCriterion("PROJECTCLASS between", value1, value2, "projectclass");
            return (Criteria) this;
        }

        public Criteria andProjectclassNotBetween(String value1, String value2) {
            addCriterion("PROJECTCLASS not between", value1, value2, "projectclass");
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