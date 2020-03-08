package entity;

public class RuleExt {
    private Long extId;

    private Long ruleId;

    private String code;

    private String codeDesc;

    private String val;

    private String valDesc;

    private String notes;

    private String state;

    private String remarks;

    private String extA;

    private String extB;

    private String extC;

    public Long getExtId() {
        return extId;
    }

    public void setExtId(Long extId) {
        this.extId = extId;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc == null ? null : codeDesc.trim();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    public String getValDesc() {
        return valDesc;
    }

    public void setValDesc(String valDesc) {
        this.valDesc = valDesc == null ? null : valDesc.trim();
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

    public String getExtA() {
        return extA;
    }

    public void setExtA(String extA) {
        this.extA = extA == null ? null : extA.trim();
    }

    public String getExtB() {
        return extB;
    }

    public void setExtB(String extB) {
        this.extB = extB == null ? null : extB.trim();
    }

    public String getExtC() {
        return extC;
    }

    public void setExtC(String extC) {
        this.extC = extC == null ? null : extC.trim();
    }
}