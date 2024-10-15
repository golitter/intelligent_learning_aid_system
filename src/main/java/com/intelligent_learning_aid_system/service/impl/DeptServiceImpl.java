package com.intelligent_learning_aid_system.service.impl;


import com.intelligent_learning_aid_system.mapper.DeptMapper;
import com.intelligent_learning_aid_system.mapper.EmpMapper;
import com.intelligent_learning_aid_system.pojo.Dept;
import com.intelligent_learning_aid_system.pojo.Result;
import com.intelligent_learning_aid_system.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;
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

    //根据部门id，删除部门信息及部门下的所有员工
    @Transactional(rollbackFor=Exception.class)
    // 默认1为异常回滚
    // propagation = Propagation.REQUIRED 默认
    // 事务传播行为
    // REQUIRED：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中
    // REQUIRES_NEW：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，挂起当前事务，创建一个新的事务
    // SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行
    // MANDATORY：使用当前的事务，如果当前没有事务，就抛出异常
    // NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
    // NEVER：以非事务方式执行，如果当前存在事务，则抛出异常
    // NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作

    public void delete(Integer id){
        //根据部门id删除部门信息
        deptMapper.deleteById(id);

        //删除部门下的所有员工信息
        empMapper.deleteByDeptId(id);
    }
}
