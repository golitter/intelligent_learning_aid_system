package com.intelligent_learning_aid_system.service;


import com.intelligent_learning_aid_system.pojo.Dept;
import com.intelligent_learning_aid_system.pojo.Result;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    /**
     * 查询全部部门
     * @return
     */
    List<Dept> list();
    /**
     * 删除部门
     */
    Result deleteById(Integer id);

    /**
     * 新增部门
     */
    void add(Dept dept);

    /**
     * 按id查询部门
     * @return
     */
    Dept getById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);

    //根据部门id，删除部门信息及部门下的所有员工
    public void delete(Integer id);
}
