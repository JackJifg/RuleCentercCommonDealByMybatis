package entity;

import java.util.Date;

public class Rule {
    private Long ruleId;

    private Long catalogId;

    private String ruleCode;

    private String ruleName;

    private String ruleType;

    private String content1;

    private String content3;

    private String content2;

    private String ruleDesc1;

    private String ruleDesc2;

    private String ruleDesc3;

    private Short priority;

    private String notes;

    private String state;

    private Date effectTime;

    private Date expireTime;

    private String remarks;

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode == null ? null : ruleCode.trim();
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType == null ? null : ruleType.trim();
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1 == null ? null : content1.trim();
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3 == null ? null : content3.trim();
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2 == null ? null : content2.trim();
    }

    public String getRuleDesc1() {
        return ruleDesc1;
    }

    public void setRuleDesc1(String ruleDesc1) {
        this.ruleDesc1 = ruleDesc1 == null ? null : ruleDesc1.trim();
    }

    public String getRuleDesc2() {
        return ruleDesc2;
    }

    public void setRuleDesc2(String ruleDesc2) {
        this.ruleDesc2 = ruleDesc2 == null ? null : ruleDesc2.trim();
    }

    public String getRuleDesc3() {
        return ruleDesc3;
    }

    public void setRuleDesc3(String ruleDesc3) {
        this.ruleDesc3 = ruleDesc3 == null ? null : ruleDesc3.trim();
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}