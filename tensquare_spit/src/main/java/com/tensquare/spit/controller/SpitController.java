package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: SpitController
 * @Author: lish
 * @Date: 2019/4/23 14:15
 * @Description: ${description}
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(method=RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",spitService.findAll());
    }

    @RequestMapping(value ="/{spitId}" ,method=RequestMethod.GET)
    public Result findById(@PathVariable String spitId){
        return new Result(true,StatusCode.OK,"查询成功",spitService.findById(spitId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit){
        spitService.save(spit);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.POST)
    public Result update(@RequestBody Spit spit,@PathVariable String  spitId){
        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = {"/spitId"},method = RequestMethod.DELETE)
    public Result delete(@PathVariable String  spitId){
        spitService.delete(spitId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "comment/{parentid}/{page}/{size}")
    public Result findByParentid(@PathVariable String parentid,@PathVariable int page,@PathVariable int siez){
        Page<Spit> spitPage = spitService.findByParentid(parentid, page, siez);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Spit>(spitPage.getTotalElements(),spitPage.getContent()));
    }


    @RequestMapping(value = "/thumbup/{spitId}",method = RequestMethod.GET)
    public Result updateThumbup(@PathVariable String  spitId){
        String userid="1111";
        if(redisTemplate.opsForValue().get("thumbup_"+userid+"_"+spitId)!=null){
            return new Result(false,StatusCode.REPERROR,"不能重复点赞");
        }
        spitService.updateThumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_"+userid+"_"+spitId,"1");
        return new Result(true,StatusCode.OK,"点赞成功");
    }








}
