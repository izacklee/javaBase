package com.m.service.impl;

import com.m.dao.DeptDao;
import com.m.entity.Dept;
import com.m.service.DeptService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Scope("prototype")
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao dao;

    private static Logger logger = Logger.getLogger(DeptServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Dept> selectDept(Dept dept) {
        return this.dao.selectDept(dept);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int insertDept(Dept dept) {
        return this.dao.insertDept(dept);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int insertDepts(List<Dept> depts) {

        // 加了事务管理以后，这个方法内所有的异常，都会导致该方法的数据回滚
        int i = 0;

        for (Dept dept : depts) {
            i += this.insertDept(dept);
            if (i == 3) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    logger.error("error：{}",e);
                }
            }
        }

        return i;
    }
}
