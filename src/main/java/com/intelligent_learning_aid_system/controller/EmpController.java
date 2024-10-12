package com.intelligent_learning_aid_system.controller;


import com.intelligent_learning_aid_system.pojo.Emp;
import com.intelligent_learning_aid_system.pojo.PageBean;
import com.intelligent_learning_aid_system.pojo.Result;
import com.intelligent_learning_aid_system.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")

public class EmpController {
    @Autowired
    private EmpService empService;

//    @GetMapping("")
//    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
//        log.info("分页查询员工数据 - 第{}页，每页{}条", page, pageSize);
//        PageBean pageBean = empService.page(page, pageSize);
//        return Result.success(pageBean);
//    }
    @GetMapping("")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize, String name, Short gender,
                       @DateTimeFormat(pattern = "yyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyy-MM-dd") LocalDate end) {

        log.info("分页查询员工数据 - 第{}页，每页{}条", page, pageSize);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     *  批量删除员工
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除员工 - id:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 新增员工
     */
    @PostMapping("")
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工 - {}", emp);
        empService.save(emp);
        return Result.success();

    }

    /**
     * 按id查询员工信息
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("带查询的员工id： {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 修改员工信息
     */
    @PutMapping("")
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工信息： {}", emp);
        empService.update(emp);
        return Result.success();
    }

}
