package com.intelligent_learning_aid_system.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.intelligent_learning_aid_system.mapper.EmpMapper;
import com.intelligent_learning_aid_system.pojo.Emp;
import com.intelligent_learning_aid_system.pojo.PageBean;
import com.intelligent_learning_aid_system.pojo.Result;
import com.intelligent_learning_aid_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * @param page
     * @param pageSize
     * @return
     */
//    public PageBean page(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long total = empMapper.count();
//        // 获取分页查询结果列表
////        System.out.println((page - 1) * pageSize);
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.page(start, pageSize);
//        // 封装pageBean对象
//        PageBean pageBean = new PageBean();
//        pageBean.setTotal(total);
//        pageBean.setRows(rows);
//        return pageBean;
//    }
    // pageHelper 插件
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行查询
        List<Emp> rows = empMapper.page(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) rows;
        // 封装PageBean对象
        PageBean pageBean = new PageBean();
        pageBean.setTotal(p.getTotal());
        pageBean.setRows(p.getResult());
        return pageBean;
    }
    /**
     * 批量删除员工
     */
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }
}
