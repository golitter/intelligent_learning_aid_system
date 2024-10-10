package com.intelligent_learning_aid_system.controller;


import com.intelligent_learning_aid_system.pojo.Dept;
import com.intelligent_learning_aid_system.pojo.Result;
import com.intelligent_learning_aid_system.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts", method = RequestMethod.GET) // 指定请求参数为 GET
    @GetMapping("") // 等同于上面的写法
    public Result list() {
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");

        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        log.info("根据id - {}删除部门数据", id);
        // 调用service删除部门
        return deptService.deleteById(id);
    }

    /**
     * 新增部门
     */
    @PostMapping("")
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门数据 - {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 按id查询部门
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable("id") Integer id) {
        log.info("根据id - {}查询部门数据", id);
        // 调用service查询部门数据
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     */
    @PutMapping("")
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门数据 - {}", dept);
        // 调用service修改部门
        deptService.update(dept);
        return Result.success();
    }
}
