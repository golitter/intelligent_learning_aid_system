package com.intelligent_learning_aid_system.controller;


import com.intelligent_learning_aid_system.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
public class DeptController {

    //    @RequestMapping(value = "/depts", method = RequestMethod.GET) // 指定请求参数为 GET
    @GetMapping("/depts") // 等同于上面的写法
    public Result list() {
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        return Result.success();
    }



}
