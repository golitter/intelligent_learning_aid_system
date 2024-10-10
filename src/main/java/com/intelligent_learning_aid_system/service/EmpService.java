package com.intelligent_learning_aid_system.service;

import com.intelligent_learning_aid_system.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    /**
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
}
