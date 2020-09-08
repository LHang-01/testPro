package mycatalog.mapper;

import mycatalog.domain.MyCatalogNode;
import mycatalog.model.MyCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyCatalogMapper{

    void create(MyCatalog myCatalog);

    void update(MyCatalog myCatalog);

    List<MyCatalog> selectByCode(MyCatalog myCatalog);

    List<MyCatalogNode> selectByParentId(@Param("parentId") String parentId);

    List<MyCatalog> selectByParentIdAndName(MyCatalog myCatalog);

    MyCatalog selectByflowId(String flowId);

    void deleteByflowId(String flowId);

    List<MyCatalog> selectByParentIdAndFlowId(MyCatalog myCatalog);

    void increaseNumByFlowId(String catalogId);

    void reduceNumByFlowId(String catalogId);
}
