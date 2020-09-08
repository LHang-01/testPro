package mycatalog.domain;

import java.util.ArrayList;
import java.util.List;

public class MyCatalogNode{

    //编号
    private int id;

    //流水号84dfc1e689fc415daa15f50785afbc45
    private String flowId;

    //分类名称
    private String name;

    //分类编号
    private String code;

    //上级分类的flowId
    private String parentId;

    //标准类型，CODESTD表示编码标准
    private String usePattern;

    //关联的数据条数
    private Integer num;

    //子类
    private List<MyCatalogNode> Childrens;

    public MyCatalogNode(int id, String flowId, String name, String code, String parentId, String usePattern, Integer num, List<MyCatalogNode> childrens) {
        this.id = id;
        this.flowId = flowId;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
        this.usePattern = usePattern;
        this.num = num;
        Childrens = childrens;
    }

    public MyCatalogNode() {
        this.Childrens = new ArrayList<MyCatalogNode>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUsePattern() {
        return usePattern;
    }

    public void setUsePattern(String usePattern) {
        this.usePattern = usePattern;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<MyCatalogNode> getChildrens() {
        return Childrens;
    }

    public void setChildrens(List<MyCatalogNode> childrens) {
        Childrens = childrens;
    }
}
