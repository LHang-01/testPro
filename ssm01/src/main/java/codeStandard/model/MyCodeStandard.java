package codeStandard.model;

import java.util.List;

public class MyCodeStandard {

    //自增编号
    private Integer codeStandardId;

    //UUID编号
    private String flowId;
    //中文简称
    private String cnName;
    //编码集名
    private String codeName;
    //编码规则
    private String codeRule;
    //使用位数
    private String useCount;
    //说明
    private String description;

    //编码集分类，catalog的flow_id
    private String catalogId;
    //段数
    private int partCount;

    //有效状态，初次插入默认draft
    private String effectiveState;
    //审批状态，初次插入默认pending
    private String approvalStatus;

//    //创建者
//    private int creator;
//    //修改者
//    private int editor;
//    //创建时间
//    private Long gmtCreate;
//    //修改时间
//    private Long gmtModified;

    //各段编码规则
    private List<MyCodeStandardPart> parts;

    public MyCodeStandard(Integer codeStandardId, String flowId, String cnName, String codeName, String codeRule, String useCount, String description, String catalogId, int partCount, String effectiveState, String approvalStatus, List<MyCodeStandardPart> parts) {
        this.codeStandardId = codeStandardId;
        this.flowId = flowId;
        this.cnName = cnName;
        this.codeName = codeName;
        this.codeRule = codeRule;
        this.useCount = useCount;
        this.description = description;
        this.catalogId = catalogId;
        this.partCount = partCount;
        this.effectiveState = effectiveState;
        this.approvalStatus = approvalStatus;
        this.parts = parts;
    }

    public MyCodeStandard() {
    }

    public Integer getCodeStandardId() {
        return codeStandardId;
    }

    public void setCodeStandardId(Integer codeStandardId) {
        this.codeStandardId = codeStandardId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeRule() {
        return codeRule;
    }

    public void setCodeRule(String codeRule) {
        this.codeRule = codeRule;
    }

    public String getUseCount() {
        return useCount;
    }

    public void setUseCount(String useCount) {
        this.useCount = useCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public int getPartCount() {
        return partCount;
    }

    public void setPartCount(int partCount) {
        this.partCount = partCount;
    }

    public String getEffectiveState() {
        return effectiveState;
    }

    public void setEffectiveState(String effectiveState) {
        this.effectiveState = effectiveState;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public List<MyCodeStandardPart> getParts() {
        return parts;
    }

    public void setParts(List<MyCodeStandardPart> parts) {
        this.parts = parts;
    }
}
