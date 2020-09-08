package codeStandard.service.impl;

import codeStandard.domain.FlowIdAndCatalogId;
import codeStandard.domain.MyCodeStandardPage;
import codeStandard.mapper.MyCodeStandardMapper;
import codeStandard.mapper.MyCodeStandardPartMapper;
import codeStandard.model.MyCodeStandard;
import codeStandard.model.MyCodeStandardPart;
import codeStandard.service.MyCodeStandardService;
import mycatalog.mapper.MyCatalogMapper;
import mycatalog.model.MyCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class MyCodeStandardServiceImpl implements MyCodeStandardService {

    @Autowired
    MyCodeStandardMapper myCodeStandardMapper;

    @Autowired
    MyCodeStandardPartMapper myCodeStandardPartMapper;

    @Autowired
    MyCatalogMapper myCatalogMapper;

    @Override
    public boolean validCodeName(MyCodeStandard codeStandard) {
        return myCodeStandardMapper.selectByFlowIdAndCodeName(codeStandard).isEmpty();
    }

    @Override
    public MyCodeStandard detail(String flowId) {
        MyCodeStandard myCodeStandard = myCodeStandardMapper.selectByFlowId(flowId);
        List<MyCodeStandardPart> parts = myCodeStandardPartMapper.selectByParentId(flowId);
        myCodeStandard.setParts(parts);
        return myCodeStandard;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<FlowIdAndCatalogId> flowIdsAndCatalogIds) {
        //边删除codeStandard、myCodeStandardPart，边更新myCatalog节点以及父节点num的值
        for (FlowIdAndCatalogId flowIdAndCatalogId:flowIdsAndCatalogIds) {
            myCodeStandardMapper.deleteByFlowId(flowIdAndCatalogId.getFlowId());
            myCodeStandardPartMapper.deleteByParentId(flowIdAndCatalogId.getFlowId());
            reduceCatalogNum(flowIdAndCatalogId.getCatalogId());
        }
    }

    private void reduceCatalogNum(String flowId) {
        MyCatalog myCatalog = myCatalogMapper.selectByflowId(flowId);
        while (myCatalog!=null){
            myCatalogMapper.reduceNumByFlowId(myCatalog.getFlowId());
            myCatalog=myCatalogMapper.selectByflowId(myCatalog.getParentId());
        }
    }

    private void increaseCatalogNum(String flowId) {
        MyCatalog myCatalog = myCatalogMapper.selectByflowId(flowId);
        while (myCatalog!=null){
            myCatalogMapper.increaseNumByFlowId(myCatalog.getFlowId());
            myCatalog=myCatalogMapper.selectByflowId(myCatalog.getParentId());
        }
    }



    @Override
    public List<MyCodeStandard> showOnePage(MyCodeStandardPage myCodeStandardPage) {
        myCodeStandardPage.setStart((myCodeStandardPage.getCurPage() - 1) * myCodeStandardPage.getPageSize());
        return myCodeStandardMapper.showOnePage(myCodeStandardPage);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrUpdate(MyCodeStandard codeStandard) {
        if (codeStandard.getFlowId() != null && codeStandard.getFlowId().length() != 0) {
            //沒有FlowId，就新增
            codeStandard.setFlowId(UUID.randomUUID().toString().replaceAll("-", ""));
            myCodeStandardMapper.create(codeStandard);
            myCodeStandardPartMapper.create(codeStandard.getFlowId(), codeStandard.getParts());
            //并改变关联的catalog节点以及父节点:num+1
            increaseCatalogNum(codeStandard.getCatalogId());
        } else {
            //有FlowId，就更新
            myCodeStandardMapper.update(codeStandard);
            //刪除原來的parts，插入新parts
            myCodeStandardPartMapper.deleteByParentId(codeStandard.getFlowId());
            myCodeStandardPartMapper.create(codeStandard.getFlowId(), codeStandard.getParts());
            //判断CatalogId是否改变
            MyCodeStandard codeStandard1 = myCodeStandardMapper.selectByFlowId(codeStandard.getFlowId());
            if (!codeStandard1.getCatalogId().equals(codeStandard.getCatalogId())){
                //若改变，则需要修改catalog节点以及父节点的num
                increaseCatalogNum(codeStandard.getCatalogId());
                reduceCatalogNum(codeStandard1.getCatalogId());
            }
        }
    }


}
