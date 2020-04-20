package edu.xjtuse.stu.seckill.mapper;

import edu.xjtuse.stu.seckill.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 失了秩
 * @date 2020/4/17 17:43
 * @description
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") long id);
}
