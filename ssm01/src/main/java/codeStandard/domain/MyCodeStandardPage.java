package codeStandard.domain;

/**
 * @Classname MyCodeStandardPage
 * @Description TODO
 * @Date 2020/8/27 20:03
 * @Created by 17976
 */
public class MyCodeStandardPage {
    //搜索框中的关键词，用于对编码集名和中文简称进行模糊查询
    private String keyWord;

    //选中的catalog的flowId
    private String catalogId;

    //有效状态
    private String effectiveState;

    //审批状态
    private String approvalStatus;

    //起始条数=(curPage-1)*pageSize
    private int start;

    //每页条数
    private int pageSize;

    //当前页
    private int curPage;

    public MyCodeStandardPage(String keyword, String catalogId, String effectiveState, String approvalStatus, int start, int pageSize, int curPage) {
        this.keyWord = keyword;
        this.catalogId = catalogId;
        this.effectiveState = effectiveState;
        this.approvalStatus = approvalStatus;
        this.start = start;
        this.pageSize = pageSize;
        this.curPage = curPage;
    }

    public MyCodeStandardPage() {
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
}
