package entity;

import Tools.ChineseCharToEnUtil;

public class Sence {
    private Long senceId;

    private Long tenantId;

    private Long baseId;

    private Long catalogId;

    private String senceCode;

    private String senceName;

    private String senceDesc;

    private Short priority;

    private String notes;

    private String state;

    private String remarks;

    public Long getSenceId() {
        return senceId;
    }

    public void setSenceId(Long senceId) {
        this.senceId = senceId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getSenceCode() {
        return senceCode;
    }

    public void setSenceCode(String senceCode) {
        this.senceCode = senceCode == null ? null : senceCode.trim();
    }

    public String getSenceName() {
        return senceName;
    }

    public void setSenceName(String senceName) {
        this.senceName = senceName == null ? null : senceName.trim();
    }

    public String getSenceDesc() {
        return senceDesc;
    }

    public void setSenceDesc(String senceDesc) {
        this.senceDesc = senceDesc == null ? null : senceDesc.trim();
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Sence() {
    }

    public Sence(Sence sence,String senceName) {
        super();
        this.senceId = sence.getSenceId()+1L;
        this.tenantId = sence.getTenantId();
        this.baseId = sence.getBaseId();
        this.catalogId = sence.getCatalogId();
        this.senceCode = "JT_"+ ChineseCharToEnUtil.getFirstSpell(senceName).toUpperCase() +"-CSHJY";
        this.senceName = "集团_"+senceName+"-初始化校验";
//        this.senceCode = "JT_"+ ChineseCharToEnUtil.getFirstSpell(senceName).toUpperCase() +"-TJSJY";
//        this.senceName = "集团_"+senceName+"-提交时校验";
        this.senceDesc = this.senceName;
        this.priority = null;
        this.notes = null;
        this.state = "1";
        this.remarks = sence.getRemarks();
    }

    @Override
    public String toString() {
        return "Sence [senceId=" + senceId + ", tenantId=" + tenantId + ", baseId=" + baseId + ", catalogId="
                + catalogId + ", senceCode=" + senceCode + ", senceName=" + senceName + ", senceDesc=" + senceDesc
                + ", priority=" + priority + ", notes=" + notes + ", state=" + state + ", remarks=" + remarks + "]";
    }
}