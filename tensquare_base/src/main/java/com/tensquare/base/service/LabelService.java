package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.entity.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName LabelService
 * @Author lish
 * @Date 2019/4/11 18:31
 * @description TODO
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        Optional<Label> labelOptional = labelDao.findById(id);
        if(labelOptional.isPresent()){
            return labelOptional.get();
        }
        return null;
    }

    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }



    public void deleteById(String id){
        labelDao.deleteById(id);
    }


}
