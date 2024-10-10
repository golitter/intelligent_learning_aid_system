package com.intelligent_learning_aid_system.service.impl;


import com.intelligent_learning_aid_system.mapper.DeptMapper;
import com.intelligent_learning_aid_system.pojo.Dept;
import com.intelligent_learning_aid_system.pojo.Result;
import com.intelligent_learning_aid_system.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询全部部门
     */
    public List<Dept> list() {
        return deptMapper.list();
    }

    /**
     * 删除部门
     */
    public Result deleteById(Integer id) {
        deptMapper.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    /**
     * 按id查询部门
     * @return
             */
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
         return dept;
    }
    /**
     * 修改部门
     * @param dept
     */
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
