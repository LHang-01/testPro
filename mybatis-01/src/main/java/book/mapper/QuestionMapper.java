package book.mapper;

import dto.QuestionQueryDTO;
import model.Question;
import java.util.List;
import java.util.Map;

public interface QuestionMapper {

    //插入数据
    void insert(Question question);

    //根据主键查找数据
    Question selectByPrimaryKey(Long id);

    //根据ID更新数据的创建时间、修改时间、标题、描述、标签
    int update(Question updateQuestion);

    //根据tag查询相关的问题
    List<Question> selectRelated(Question question);

    //增加浏览次数
    void incView(Question question);

    //增加评论次数
    void incCommentCount(Question question);

    //查找与title类似的问题数量
    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    //取出与title类似的问题集合,按照创建时间降序排列，用于分页
    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);

    //查询同一个创建者创建的问题个数
    Integer countByExample(Question questionExample);

    //取出同一个创建者创建的所有问题集合，并按照时间降序排列，用于分页查询
    List<Question> selectByUserIdWithRowbounds(Map param);
}
