package codeStandard.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * PartType的5种取值取值
 */
public enum CodeStandardPartTypeEnum {
    UPPERCASECODE("UpperCaseCode","大写字母"),
    LOWERCASECODE("LowerCaseCode","小写字母"),
    LETTERNUMCODE("LetterNumCode","字母数字组合"),
    SERIALNUMCODE("SerialNumCode", "流水号"),
    CONSTANT("Constant","常量");

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    CodeStandardPartTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static List<CodeStandardPartTypeEnum> getAll(){
        ArrayList<CodeStandardPartTypeEnum> enums = new ArrayList<>();
        enums.add(UPPERCASECODE);
        enums.add(LOWERCASECODE);
        enums.add(LETTERNUMCODE);
        enums.add(SERIALNUMCODE);
        enums.add(CONSTANT);
        return enums;
    }
}
