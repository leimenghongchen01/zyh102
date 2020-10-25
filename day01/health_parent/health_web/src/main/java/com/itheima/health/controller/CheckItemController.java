package com.itheima.health.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.container.page.Page;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    /**
     * 查询列表
     */
    @Reference
    private CheckItemService checkItemService;
    @GetMapping("/findAll")
    public Result findAll(){
        //调用服务查询
        List<CheckItem>list=checkItemService.findAll();
        //封装到result再返回
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,list);
    }
    /**
     * 添加检查项
     * CheckItem checkItem用实体类来接收
     */

    @PostMapping("/add")
    //
    public Result add(@RequestBody CheckItem checkItem) {
        //调用服务添加
        checkItemService.add(checkItem);
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        /**
         * 分页查询
         *
         */
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @PostMapping("/findPage")
    public Result findPage (@RequestBody QueryPageBean queryPageBean){
        //调用服务分页查询
        PageResult<CheckItem>pageResult=checkItemService.findPage(queryPageBean);
        //返回到页面

        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS);

    }
}
