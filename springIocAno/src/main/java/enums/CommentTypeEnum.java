package enums;

public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    //属性：类型
    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static boolean isExist(Integer type){
        for (CommentTypeEnum cte:CommentTypeEnum.values()){
            if (type==cte.getType()){
                return true;
            }
        }
        return false;
    }
}
