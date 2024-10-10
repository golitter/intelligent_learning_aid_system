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
}
