package codeStandard.controller;

import codeStandard.domain.FlowIdAndCatalogId;
import codeStandard.domain.MyCodeStandardPage;
import codeStandard.enums.CodeStandardPartTypeEnum;
import codeStandard.enums.LetterNumCodeEnum;
import codeStandard.model.MyCodeStandard;
import codeStandard.service.MyCodeStandardService;
import commen.resultmodel.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/standard/myCodeStandard")
public class MyCodeStandardController {
    @Autowired
    private MyCodeStandardService myCodeStandardService;

    @RequestMapping("/getLetterNumCode")
    public BaseJson getLetterNumCode(){
        BaseJson result = new BaseJson(true);
        try {
            result.setData(LetterNumCodeEnum.getAll());
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }

    @RequestMapping("/getCodeStandardPartType")
    public BaseJson getCodeStandardPartType(){
        BaseJson result = new BaseJson(true);
        try {
            result.setData(CodeStandardPartTypeEnum.getAll());
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }


    @RequestMapping(value = "/add")
    public BaseJson addOrModify(MyCodeStandard codeStandard){
        try {
            // 接口前置校验数据 校验失败手动抛出异常
            //校验codename不重复
            if (!myCodeStandardService.validCodeName(codeStandard)) {
                return new BaseJson(false, "codename重复");
            }
        } catch (Exception e) {
            return new BaseJson(false, e.getMessage());
        }

        BaseJson result = new BaseJson(true);
        try {
            // 执行逻辑业务
            myCodeStandardService.createOrUpdate(codeStandard);
            result.setData("操作成功");
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }

    @RequestMapping(value = "/delete")
    public BaseJson delete(List<FlowIdAndCatalogId> flowIdsAndCatalogIds){

        BaseJson result = new BaseJson(true);
        try {
            // 执行逻辑业务
            myCodeStandardService.delete(flowIdsAndCatalogIds);
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }

    @RequestMapping(value = "/filter")
    public BaseJson filter(MyCodeStandardPage myCodeStandardPage){

        BaseJson result = new BaseJson(true);
        try {
            // 执行逻辑业务
            List<MyCodeStandard> myCodeStandards = myCodeStandardService.showOnePage(myCodeStandardPage);
            result.setData(myCodeStandards);
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }

    @RequestMapping(value = "/edit")
    public BaseJson filter(String flowId){
        BaseJson result = new BaseJson(true);
        try {
            // 执行逻辑业务
            MyCodeStandard parts = myCodeStandardService.detail(flowId);
            result.setData(parts);
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }
}
