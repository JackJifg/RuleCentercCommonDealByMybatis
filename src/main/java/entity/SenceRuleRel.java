package entity;

public class SenceRuleRel {
    private Long relId;

    private Long senceId;

    private Long ruleId;

    private String extType;

    private String notes;

    private String state;

    private String remarks;

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public Long getSenceId() {
        return senceId;
    }

    public void setSenceId(Long senceId) {
        this.senceId = senceId;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getExtType() {
        return extType;
    }

    public void setExtType(String extType) {
        this.extType = extType == null ? null : extType.trim();
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public SenceRuleRel() {

    }

    public SenceRuleRel(Long relId,  Rule rule, Sence sence  ,SenceRuleRel preSenceRuleRel) {
        super();
        this.relId = relId;
        this.senceId = sence.getSenceId();
        this.ruleId = rule.getRuleId();
        this.extType = null;
        this.notes = sence.getSenceName()+"-"+rule.getRuleName();
        this.state = "1";
        this.remarks = preSenceRuleRel.getRemarks();
    }

    @Override
    public String toString() {
        return "SenceRuleRel [relId=" + relId + ", senceId=" + senceId + ", ruleId=" + ruleId + ", extType=" + extType
                + ", notes=" + notes + ", state=" + state + ", remarks=" + remarks + "]";
    }


}