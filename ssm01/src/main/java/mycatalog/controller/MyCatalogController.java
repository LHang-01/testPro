package mycatalog.controller;

import commen.resultmodel.BaseJson;
import mycatalog.domain.MyCatalogNode;
import mycatalog.model.MyCatalog;
import mycatalog.service.MycatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/standard/mycatalog")
public class MyCatalogController{

    @Autowired
    MycatalogService mycatalogService;

    @ResponseBody
    @RequestMapping("/add")
    public BaseJson addOrModifyCatalog(MyCatalog myCatalog){
        try {
            // 接口前置校验数据 校验失败手动抛出异常
            if (!mycatalogService.selectByCode(myCatalog).isEmpty()){
                return new BaseJson(false, "分类编号已存在，请检查重新输入");
            }
            if (mycatalogService.selectByParentIdAndName(myCatalog)){
                return new BaseJson(false, "同级分类名称已存在，请检查重新输入");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new BaseJson(false, e.getMessage());
        }

        BaseJson result = new BaseJson(true);
        try {
            // 执行逻辑业务
            mycatalogService.createOrUpdate(myCatalog);
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/tree")
    public BaseJson showCatalog(@RequestParam String usePattern){
        BaseJson result = new BaseJson(true);
        try {
            // 执行逻辑业务
            MyCatalogNode root = new MyCatalogNode();
            root.setFlowId("root");
            MyCatalogNode tree = mycatalogService.show(root);
            result.setData(tree.getChildrens());
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public BaseJson deleteCatalog(@RequestParam("usePattern") String usePattern, @RequestParam("flowIds") List<String> flowIds){
        try {
            //校验数据
            if (usePattern.equals("CODESTD")) {
                if (mycatalogService.selectByflowId(flowIds.get(0)) == null) {
                    return new BaseJson(false, "你要删除的数据不存在");
                } else if (mycatalogService.selectByflowId(flowIds.get(0)).getNum()!=0) {
                    return new BaseJson(false, "你要删除的编码标准已关联编码规则");
                }
            } else {
                return new BaseJson(false, "你要删除的数据不是编码标准");
            }
        }catch (Exception e) {
            return new BaseJson(false, e.getMessage());
        }

        BaseJson result = new BaseJson(true);
        try {
            // 执行逻辑业务
            mycatalogService.delete(flowIds.get(0));
            result.setMessage("操作成功");
        } catch (Exception e) {
//            LoggerUtil.error(LoggerUtil.CORE_MNG_LOGGER_INSTANCE, e, "错误信息:" + e.getMessage());
            result.setStatus(false);
            result.setMessage(String.format("操作失败! 信息:%s", e.getMessage()));
        }
        return result;
    }
}
