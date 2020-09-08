package book.mapper;

import model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    //增
    @Insert("insert into user (account_id, name,token,gmt_create,gmt_modified,avatar_url)values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    //改
    @Update("update user set name = #{name}, token=#{token}, gmt_modified=#{gmtModified}, avatar_url=#{avatarUrl} where id=#{id}")
    void update(User user);

    //根据一个id查一个用户
    @Select("select * from user where id = #{id}")
    User selectByPrimaryKey(@Param("id") Long id);

    //根据ID集合查多个用户
    @Select("<script>" +"select * from user where id in " +
            "<foreach collection=\"ids\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">#{item}</foreach>"
            +"</script>" )
    List<User> selectByPrimaryKeys(@Param("ids") List<Long> ids);

    //根据token查找用户
    @Select("select * from user where token = #{token}")
    List<User> findByToken(@Param("token") String token);

    //根据用户id查找用户
    @Select("select * from user where account_id = #{accountId}")
    List<User> findByAccountId(@Param("accountId") String accountId);

}
