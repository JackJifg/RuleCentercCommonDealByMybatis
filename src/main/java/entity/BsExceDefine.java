package entity;

import java.util.Date;

public class BsExceDefine {
    private String exceCode;

    private Long moduleId;

    private String exceClassCode;

    private String exceName;

    private String exceReason;

    private Long schemeId;

    private String state;

    private Long doneCode;

    private Date doneDate;

    private Long opId;

    private Long orgId;

    private String remarks;

    public String getExceCode() {
        return exceCode;
    }

    public void setExceCode(String exceCode) {
        this.exceCode = exceCode == null ? null : exceCode.trim();
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getExceClassCode() {
        return exceClassCode;
    }

    public void setExceClassCode(String exceClassCode) {
        this.exceClassCode = exceClassCode == null ? null : exceClassCode.trim();
    }

    public String getExceName() {
        return exceName;
    }

    public void setExceName(String exceName) {
        this.exceName = exceName == null ? null : exceName.trim();
    }

    public String getExceReason() {
        return exceReason;
    }

    public void setExceReason(String exceReason) {
        this.exceReason = exceReason == null ? null : exceReason.trim();
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getDoneCode() {
        return doneCode;
    }

    public void setDoneCode(Long doneCode) {
        this.doneCode = doneCode;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public Long getOpId() {
        return opId;
    }

    public void setOpId(Long opId) {
        this.opId = opId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}