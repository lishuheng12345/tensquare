package com.tensquare.base.controller;

import com.tensquare.base.entity.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

/**
 * @ClassName LabelController
 * @Author lish
 * @Date 2019/4/11 16:21
 * @description 标签
 */
@RestController
@RequestMapping("/label")
@CrossOrigin  //跨域
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * @Description //查询所有标签
     * @Date 18:15
     * @Param
     * @return Result
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }

    /**
     * @Description //根据ID查询
     * @Date 18:16 
     * @Param 
     * @return 
     */
    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String labelId){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK,"增加成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"修改成功");
    }


    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK,"删除成功");
    }










}
