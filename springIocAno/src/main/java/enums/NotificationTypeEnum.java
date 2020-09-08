package enums;

public enum NotificationTypeEnum {
    REPLY_QUESTIONS(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论");

    private int type;
    private String description;

    NotificationTypeEnum(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static String descriptionOfType(int type) {
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if (notificationTypeEnum.getType() == type) {
                return notificationTypeEnum.getDescription();
            }
        }
        return "";
    }

}
