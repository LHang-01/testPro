import book.mapper.CommentMapper;
import org.apache.log4j.Logger;
import util.MybatisUtils;

public class CommentTest {
    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(CommentTest.class);
    static CommentMapper userMapper = MybatisUtils.getSession().getMapper(CommentMapper.class);

}
