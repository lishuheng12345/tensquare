package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
    //获取最新的6个职位
	public List<Recruit> findTop6ByStateAndOrderByCreatetimeDesc(String state);

	//获取不是state的最新6个职位 where state not in order by creatertime  limit 6
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
