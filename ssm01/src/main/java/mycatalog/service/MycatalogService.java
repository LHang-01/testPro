package mycatalog.service;

import mycatalog.domain.MyCatalogNode;
import mycatalog.model.MyCatalog;

import java.util.List;

public interface MycatalogService{
    List<MyCatalog> selectByCode(MyCatalog myCatalog);

    boolean selectByParentIdAndName(MyCatalog myCatalog);

    void createOrUpdate(MyCatalog myCatalog);

    MyCatalogNode show(MyCatalogNode id);

    MyCatalog selectByflowId(String flowId);

    void delete(String flowId);
}
