package com.tensquare.base.dao;

import com.tensquare.base.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName LabelDao
 * @Author lish
 * @Date 2019/4/11 18:25
 * @description TODO
 */

//JpaRepository提供了基本的增删改查
//JpaSpecificationExecutor用于做复杂的条件查询
public interface LabelDao extends JpaRepository<Label,String> ,JpaSpecificationExecutor<Label>{


}
