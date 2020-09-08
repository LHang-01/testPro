import book.mapper.QuestionMapper;
import org.apache.log4j.Logger;
import util.MybatisUtils;

public class QuestionTest {
    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(SingleMybatisTest.class);
    static QuestionMapper userMapper = MybatisUtils.getSession().getMapper(QuestionMapper.class);

}
