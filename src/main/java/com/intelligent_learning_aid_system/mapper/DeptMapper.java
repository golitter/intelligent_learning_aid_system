package com.intelligent_learning_aid_system.mapper;

import com.intelligent_learning_aid_system.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    /**
     * 查询全部部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
//    @Delete("delete from dept where id = #{id}")
//    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    /**
     * 按id查询部门
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);

    /**
     * 根据id删除部门信息
     * @param id   部门id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
