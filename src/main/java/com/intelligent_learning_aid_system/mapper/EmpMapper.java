package com.intelligent_learning_aid_system.mapper;

import com.intelligent_learning_aid_system.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;


/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

//    /**
//     * 查询总记录数
//     */
//    @Select("select count(*) from emp")
//    public Long count();
//
//    /**
//     * 分页查询，获取列表数据
//     */
//    @Select("select * from emp limit #{page}, #{size}")
//    public List<Emp> page(Integer page, Integer size);
//获取当前页的结果列表
//    @Select("select * from emp")
    public List<Emp> page(@Param("name") String name,@Param("gender") Short gender,@Param("begin") LocalDate begin,@Param("end") LocalDate end);

    void delete(@Param("ids") List<Integer> ids);

    /**
     * 新增员工
     */
    @Insert("insert emp(username, name, gender,image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void save(Emp emp);

    /**
     * 按员工id查询员工信息
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 修改员工信息
     * @param emp
     */
    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
