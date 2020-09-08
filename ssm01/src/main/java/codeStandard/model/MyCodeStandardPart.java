package codeStandard.model;

public class MyCodeStandardPart {

    //自增编号
    private Integer codeStandardPartId;

    //codeStandard的flowId
    private String parentId;

    //类型PartEnum.code
    private String partType;

    //名字PartEnum.name
    private String partName;

    // 长度,除partType=Constant外，其他四种类型都有值
    private int partLength;

    //只有partType=SerialNumCode时有值
    private int segmentChar;

    //只有partType=Constant时有值
    private String constant;

    //partType=LetterNumCode时,为FlagNum中code的组合
    private String letterNumCombine;

    //partType=UpperCaseCode、LowerCaseCode时，为起始值
    private String startValue;

    //只有partType=UpperCaseCode、LowerCaseCode时有值
    private String endValue;

    public MyCodeStandardPart(int codeStandardPartId, String parentId, String partType, String partName, int partLength, int segmentChar, String constant, String letterNumCombine, String startValue, String endValue) {
        this.codeStandardPartId = codeStandardPartId;
        this.parentId = parentId;
        this.partType = partType;
        this.partName = partName;
        this.partLength = partLength;
        this.segmentChar = segmentChar;
        this.constant = constant;
        this.letterNumCombine = letterNumCombine;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public MyCodeStandardPart() {
    }

    public int getCodeStandardPartId() {
        return codeStandardPartId;
    }

    public void setCodeStandardPartId(int codeStandardPartId) {
        this.codeStandardPartId = codeStandardPartId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getPartLength() {
        return partLength;
    }

    public void setPartLength(int partLength) {
        this.partLength = partLength;
    }

    public int getSegmentChar() {
        return segmentChar;
    }

    public void setSegmentChar(int segmentChar) {
        this.segmentChar = segmentChar;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public String getLetterNumCombine() {
        return letterNumCombine;
    }

    public void setLetterNumCombine(String letterNumCombine) {
        this.letterNumCombine = letterNumCombine;
    }

    public String getStartValue() {
        return startValue;
    }

    public void setStartValue(String startValue) {
        this.startValue = startValue;
    }

    public String getEndValue() {
        return endValue;
    }

    public void setEndValue(String endValue) {
        this.endValue = endValue;
    }
}
