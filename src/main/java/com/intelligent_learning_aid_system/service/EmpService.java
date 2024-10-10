package com.intelligent_learning_aid_system.service;

import com.intelligent_learning_aid_system.pojo.PageBean;
import com.intelligent_learning_aid_system.pojo.Result;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    /**
     * @param page
     * @param pageSize
     * @return
     */
//    PageBean page(Integer page, Integer pageSize);
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     */
    void delete(List<Integer> ids);
}

