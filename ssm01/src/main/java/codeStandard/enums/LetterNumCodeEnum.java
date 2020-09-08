package codeStandard.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 表征LetterNumCode中每个数字表示的含义
 */
public enum LetterNumCodeEnum {

    DIGITAL("1", "数字"),
    UPPERCASELETTER("2", "大写字母"),
    LOWERCASELETTERS("3","小写字母");

    private String code;
    private String name;

    LetterNumCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static List<LetterNumCodeEnum> getAll() {
        ArrayList<LetterNumCodeEnum> enums = new ArrayList<>();
        enums.add(DIGITAL);
        enums.add(UPPERCASELETTER);
        enums.add(LOWERCASELETTERS);
        return enums;
    }
}
