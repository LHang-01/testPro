package codeStandard.service;

import codeStandard.domain.FlowIdAndCatalogId;
import codeStandard.domain.MyCodeStandardPage;
import codeStandard.model.MyCodeStandard;

import java.util.List;

public interface MyCodeStandardService {
    void createOrUpdate(MyCodeStandard codeStandard);

    boolean validCodeName(MyCodeStandard codeStandard);

    void delete(List<FlowIdAndCatalogId> flowIdsAndCatalogIds);

    List<MyCodeStandard> showOnePage(MyCodeStandardPage myCodeStandardPage);

    MyCodeStandard detail(String flowId);
}
