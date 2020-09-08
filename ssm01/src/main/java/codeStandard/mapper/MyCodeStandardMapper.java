package codeStandard.mapper;

import codeStandard.domain.MyCodeStandardPage;
import codeStandard.model.MyCodeStandard;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MyCodeStandardMapper {

    void create(MyCodeStandard codeStandard);

    void update(MyCodeStandard codeStandard);

    List<MyCodeStandard> selectByFlowIdAndCodeName(MyCodeStandard codeStandard);

    void deleteByFlowId(String flowId);

    MyCodeStandard selectByFlowId(String flowId);

    List<MyCodeStandard> showOnePage(MyCodeStandardPage myCodeStandardPage);
}
