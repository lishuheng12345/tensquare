package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @ClassName: SpitDao
 * @Author: lish
 * @Date: 2019/4/23 11:25
 * @Description: ${description}
 */
public interface SpitDao extends MongoRepository<Spit, String> {
    public Page<Spit> findByParentid (String parentId, Pageable pageable);
}
