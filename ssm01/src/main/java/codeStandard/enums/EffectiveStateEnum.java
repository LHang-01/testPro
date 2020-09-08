package codeStandard.enums;

public enum EffectiveStateEnum {
    DRAFT("draft", "草稿"),
    CHANGING("changing", "变更中"),
    ACTIVATED("activated", "已启用"),
    ACTIVE("active", "启用中"),
    TERMINATED("terminated", "已停用");

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    EffectiveStateEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
