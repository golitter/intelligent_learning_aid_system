package com.intelligent_learning_aid_system.service.impl;


import com.intelligent_learning_aid_system.mapper.DeptMapper;
import com.intelligent_learning_aid_system.pojo.Dept;
import com.intelligent_learning_aid_system.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
