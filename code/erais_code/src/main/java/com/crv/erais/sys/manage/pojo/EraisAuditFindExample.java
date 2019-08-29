package com.crv.erais.sys.manage.pojo;

import java.util.ArrayList;
import java.util.List;

public class EraisAuditFindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EraisAuditFindExample() {
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

        public Criteria andFindIsNull() {
            addCriterion("FIND is null");
            return (Criteria) this;
        }

        public Criteria andFindIsNotNull() {
            addCriterion("FIND is not null");
            return (Criteria) this;
        }

        public Criteria andFindEqualTo(String value) {
            addCriterion("FIND =", value, "find");
            return (Criteria) this;
        }

        public Criteria andFindNotEqualTo(String value) {
            addCriterion("FIND <>", value, "find");
            return (Criteria) this;
        }

        public Criteria andFindGreaterThan(String value) {
            addCriterion("FIND >", value, "find");
            return (Criteria) this;
        }

        public Criteria andFindGreaterThanOrEqualTo(String value) {
            addCriterion("FIND >=", value, "find");
            return (Criteria) this;
        }

        public Criteria andFindLessThan(String value) {
            addCriterion("FIND <", value, "find");
            return (Criteria) this;
        }

        public Criteria andFindLessThanOrEqualTo(String value) {
            addCriterion("FIND <=", value, "find");
            return (Criteria) this;
        }

        public Criteria andFindLike(String value) {
            addCriterion("FIND like", value, "find");
            return (Criteria) this;
        }

        public Criteria andFindNotLike(String value) {
            addCriterion("FIND not like", value, "find");
            return (Criteria) this;
        }

        public Criteria andFindIn(List<String> values) {
            addCriterion("FIND in", values, "find");
            return (Criteria) this;
        }

        public Criteria andFindNotIn(List<String> values) {
            addCriterion("FIND not in", values, "find");
            return (Criteria) this;
        }

        public Criteria andFindBetween(String value1, String value2) {
            addCriterion("FIND between", value1, value2, "find");
            return (Criteria) this;
        }

        public Criteria andFindNotBetween(String value1, String value2) {
            addCriterion("FIND not between", value1, value2, "find");
            return (Criteria) this;
        }

        public Criteria andNatureIsNull() {
            addCriterion("NATURE is null");
            return (Criteria) this;
        }

        public Criteria andNatureIsNotNull() {
            addCriterion("NATURE is not null");
            return (Criteria) this;
        }

        public Criteria andNatureEqualTo(String value) {
            addCriterion("NATURE =", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotEqualTo(String value) {
            addCriterion("NATURE <>", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThan(String value) {
            addCriterion("NATURE >", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThanOrEqualTo(String value) {
            addCriterion("NATURE >=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThan(String value) {
            addCriterion("NATURE <", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThanOrEqualTo(String value) {
            addCriterion("NATURE <=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLike(String value) {
            addCriterion("NATURE like", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotLike(String value) {
            addCriterion("NATURE not like", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureIn(List<String> values) {
            addCriterion("NATURE in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotIn(List<String> values) {
            addCriterion("NATURE not in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureBetween(String value1, String value2) {
            addCriterion("NATURE between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotBetween(String value1, String value2) {
            addCriterion("NATURE not between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andAnalysIsNull() {
            addCriterion("ANALYS is null");
            return (Criteria) this;
        }

        public Criteria andAnalysIsNotNull() {
            addCriterion("ANALYS is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysEqualTo(String value) {
            addCriterion("ANALYS =", value, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysNotEqualTo(String value) {
            addCriterion("ANALYS <>", value, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysGreaterThan(String value) {
            addCriterion("ANALYS >", value, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysGreaterThanOrEqualTo(String value) {
            addCriterion("ANALYS >=", value, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysLessThan(String value) {
            addCriterion("ANALYS <", value, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysLessThanOrEqualTo(String value) {
            addCriterion("ANALYS <=", value, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysLike(String value) {
            addCriterion("ANALYS like", value, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysNotLike(String value) {
            addCriterion("ANALYS not like", value, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysIn(List<String> values) {
            addCriterion("ANALYS in", values, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysNotIn(List<String> values) {
            addCriterion("ANALYS not in", values, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysBetween(String value1, String value2) {
            addCriterion("ANALYS between", value1, value2, "analys");
            return (Criteria) this;
        }

        public Criteria andAnalysNotBetween(String value1, String value2) {
            addCriterion("ANALYS not between", value1, value2, "analys");
            return (Criteria) this;
        }

        public Criteria andRiskIsNull() {
            addCriterion("RISK is null");
            return (Criteria) this;
        }

        public Criteria andRiskIsNotNull() {
            addCriterion("RISK is not null");
            return (Criteria) this;
        }

        public Criteria andRiskEqualTo(String value) {
            addCriterion("RISK =", value, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskNotEqualTo(String value) {
            addCriterion("RISK <>", value, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskGreaterThan(String value) {
            addCriterion("RISK >", value, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskGreaterThanOrEqualTo(String value) {
            addCriterion("RISK >=", value, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskLessThan(String value) {
            addCriterion("RISK <", value, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskLessThanOrEqualTo(String value) {
            addCriterion("RISK <=", value, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskLike(String value) {
            addCriterion("RISK like", value, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskNotLike(String value) {
            addCriterion("RISK not like", value, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskIn(List<String> values) {
            addCriterion("RISK in", values, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskNotIn(List<String> values) {
            addCriterion("RISK not in", values, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskBetween(String value1, String value2) {
            addCriterion("RISK between", value1, value2, "risk");
            return (Criteria) this;
        }

        public Criteria andRiskNotBetween(String value1, String value2) {
            addCriterion("RISK not between", value1, value2, "risk");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("RECOMMEND is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("RECOMMEND is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(String value) {
            addCriterion("RECOMMEND =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(String value) {
            addCriterion("RECOMMEND <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(String value) {
            addCriterion("RECOMMEND >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(String value) {
            addCriterion("RECOMMEND >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(String value) {
            addCriterion("RECOMMEND <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(String value) {
            addCriterion("RECOMMEND <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLike(String value) {
            addCriterion("RECOMMEND like", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotLike(String value) {
            addCriterion("RECOMMEND not like", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<String> values) {
            addCriterion("RECOMMEND in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<String> values) {
            addCriterion("RECOMMEND not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(String value1, String value2) {
            addCriterion("RECOMMEND between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(String value1, String value2) {
            addCriterion("RECOMMEND not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
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

        public Criteria andFindidIsNull() {
            addCriterion("FINDID is null");
            return (Criteria) this;
        }

        public Criteria andFindidIsNotNull() {
            addCriterion("FINDID is not null");
            return (Criteria) this;
        }

        public Criteria andFindidEqualTo(String value) {
            addCriterion("FINDID =", value, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidNotEqualTo(String value) {
            addCriterion("FINDID <>", value, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidGreaterThan(String value) {
            addCriterion("FINDID >", value, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidGreaterThanOrEqualTo(String value) {
            addCriterion("FINDID >=", value, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidLessThan(String value) {
            addCriterion("FINDID <", value, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidLessThanOrEqualTo(String value) {
            addCriterion("FINDID <=", value, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidLike(String value) {
            addCriterion("FINDID like", value, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidNotLike(String value) {
            addCriterion("FINDID not like", value, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidIn(List<String> values) {
            addCriterion("FINDID in", values, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidNotIn(List<String> values) {
            addCriterion("FINDID not in", values, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidBetween(String value1, String value2) {
            addCriterion("FINDID between", value1, value2, "findid");
            return (Criteria) this;
        }

        public Criteria andFindidNotBetween(String value1, String value2) {
            addCriterion("FINDID not between", value1, value2, "findid");
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