package entity;

import java.util.Map;

public class SenceDetail {
    private Long detailId;

    private Long senceId;

    private Long fetureId;

    private String op;

    private String value1;

    private String value1Desc;

    private String value2;

    private String value2Desc;

    private String value3;

    private String value3Desc;

    private String notes;

    private String state;

    private String remarks;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getSenceId() {
        return senceId;
    }

    public void setSenceId(Long senceId) {
        this.senceId = senceId;
    }

    public Long getFetureId() {
        return fetureId;
    }

    public void setFetureId(Long fetureId) {
        this.fetureId = fetureId;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op == null ? null : op.trim();
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1 == null ? null : value1.trim();
    }

    public String getValue1Desc() {
        return value1Desc;
    }

    public void setValue1Desc(String value1Desc) {
        this.value1Desc = value1Desc == null ? null : value1Desc.trim();
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2 == null ? null : value2.trim();
    }

    public String getValue2Desc() {
        return value2Desc;
    }

    public void setValue2Desc(String value2Desc) {
        this.value2Desc = value2Desc == null ? null : value2Desc.trim();
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3 == null ? null : value3.trim();
    }

    public String getValue3Desc() {
        return value3Desc;
    }

    public void setValue3Desc(String value3Desc) {
        this.value3Desc = value3Desc == null ? null : value3Desc.trim();
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

    public SenceDetail() {
    }

    public SenceDetail(long senceId , SenceDetail senceDetail,long  detailId ,String fetureId,String value ) {
        super();
        this.detailId = detailId;
        this.senceId = senceId;
        this.fetureId = Long.parseLong(fetureId);
        this.op = "equals";
        this.value1 = value;
        this.value1Desc = null;
        this.value2 = null;
        this.value2Desc = null;
        this.value3 = null;
        this.value3Desc = null;
        this.notes = null;
        this.state = "1";
        this.remarks = senceDetail.getRemarks();
    }

    @Override
    public String toString() {
        return "SenceDetail [detailId=" + detailId + ", senceId=" + senceId + ", fetureId=" + fetureId + ", op=" + op
                + ", value1=" + value1 + ", value1Desc=" + value1Desc + ", value2=" + value2 + ", value2Desc="
                + value2Desc + ", value3=" + value3 + ", value3Desc=" + value3Desc + ", notes=" + notes + ", state="
                + state + ", remarks=" + remarks + "]";
    }
}