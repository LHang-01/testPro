package codeStandard.enums;

public enum ApprovalStatusEnum {
    PENDING("pending", "待送审"),
    UNDERREVIEW("underReview", "审核中"),
    PASSED("passed", "审核通过"),
    NOTPASS("notpass", "审核不通过");

    private String code;
    private String name;

    ApprovalStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
