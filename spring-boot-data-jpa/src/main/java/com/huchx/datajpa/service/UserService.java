package com.huchx.datajpa.service;

import com.huchx.datajpa.entity.MUserEntity;
import com.huchx.datajpa.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    /**
     * Data JPA Repository定义的接口
     * @return
     */
    public List<MUserEntity> findAll() {
        return userDao.findAll();
    }

    /**
     * 通过字段定义方法名
     * @param status
     * @return
     */
    public List<MUserEntity> findAllByStatus(int status) {
        return userDao.findAllByStatus(status);
    }

    /**
     * 通过@Query方法查询
     * @return
     */
    public List<MUserEntity> finAllByQuery() {
        return userDao.findAllByQuery();
    }
}
