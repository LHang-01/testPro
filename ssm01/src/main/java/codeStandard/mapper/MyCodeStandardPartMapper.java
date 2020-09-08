package codeStandard.mapper;

import codeStandard.model.MyCodeStandardPart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname CodeStandardPartMapper
 * @Description TODO
 * @Date 2020/8/27 14:28
 * @Created by 17976
 */
@Repository
public interface MyCodeStandardPartMapper {

    void create(@Param("parentId") String flowId, @Param("myCodeStandardPart") List<MyCodeStandardPart> parts);

    void deleteByParentId(@Param("parentId") String flowId);

    List<MyCodeStandardPart> selectByParentId(String parentId);
}
