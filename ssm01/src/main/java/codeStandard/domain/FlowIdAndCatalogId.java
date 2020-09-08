package codeStandard.domain;

/**
 * @Classname flowIdAndCatalogId
 * @Description
 * @Date 2020/8/27 17:58
 * @Created by 17976
 */
public class FlowIdAndCatalogId {
    //myCodeStandar的flowId
    private String flowId;
    //myCodeStandar的catalogId
    private String catalogId;

    public FlowIdAndCatalogId(String flowId, String catalogId) {
        this.flowId = flowId;
        this.catalogId = catalogId;
    }

    public FlowIdAndCatalogId() {
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }
}
