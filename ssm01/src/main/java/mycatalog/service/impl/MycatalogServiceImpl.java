package mycatalog.service.impl;

import mycatalog.domain.MyCatalogNode;
import mycatalog.mapper.MyCatalogMapper;
import mycatalog.model.MyCatalog;
import mycatalog.service.MycatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MycatalogServiceImpl implements MycatalogService {

    @Autowired
    MyCatalogMapper myCatalogMapper;

    /**
     * 查询相同code的MyCatalog集合
     * @param myCatalog
     * @return
     */
    @Override
    public List<MyCatalog> selectByCode(MyCatalog myCatalog) {
        List list1 = myCatalogMapper.selectByCode(myCatalog);
        return list1;
    }

    /**
     * 判断同级的myCatalog是否有重名的
     * @param myCatalog
     * @return
     */
    @Override
    public boolean selectByParentIdAndName(MyCatalog myCatalog) {
//        return (!myCatalogMapper.selectByParentId(myCatalog.getParentId()).isEmpty())
//                &&(!myCatalogMapper.selectByParentIdAndName(myCatalog).isEmpty());
        //判断除自己外是否有同级的
        List list1 = myCatalogMapper.selectByParentIdAndFlowId(myCatalog);
        if (!list1.isEmpty()){
            //判断除自己外的同级的是否有重复的
            List list2 = myCatalogMapper.selectByParentIdAndName(myCatalog);
            if (!list2.isEmpty()){
                return true;
            }
        }
        return false;
    }

    /**
     * 更新或插入myCatalog
     * @param myCatalog
     */
    @Override
    public void createOrUpdate(MyCatalog myCatalog) {
        if (myCatalog.getFlowId()==null||myCatalog.getFlowId().length()==0){
            if (myCatalog.getParentId()==null||myCatalog.getParentId().length()==0){
                myCatalog.setParentId("root");
            }
            myCatalog.setFlowId(UUID.randomUUID().toString().replaceAll("-", ""));
            myCatalogMapper.create(myCatalog);
        }else {
            myCatalogMapper.update(myCatalog);
        }
    }


    @Override
    public MyCatalogNode show(MyCatalogNode root) {
        List<MyCatalogNode> childNodes = myCatalogMapper.selectByParentId(root.getFlowId());
        if (childNodes != null && childNodes.size() > 0) {
            for (MyCatalogNode node : childNodes) {
                // 将子节点作为根，查找子节点的子节点
                MyCatalogNode childRoot = show(node);
                root.getChildrens().add(childRoot);
            }
        }
        return root;
    }

    @Override
    public MyCatalog selectByflowId(String flowId) {
        return myCatalogMapper.selectByflowId(flowId);
    }

    @Override
    public void delete(String flowId) {
        myCatalogMapper.deleteByflowId(flowId);
        List<MyCatalogNode> childNodes = myCatalogMapper.selectByParentId(flowId);
        if (childNodes != null && childNodes.size() > 0) {
            for (MyCatalogNode node : childNodes) {
                delete(node.getFlowId());
            }
        }
    }

}
