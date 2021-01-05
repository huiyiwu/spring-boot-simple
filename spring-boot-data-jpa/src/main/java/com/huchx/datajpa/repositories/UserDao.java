package com.huchx.datajpa.repositories;

import com.huchx.datajpa.entity.MUserEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserDao extends MyJpaRepository<MUserEntity, Integer> {

    List<MUserEntity> findAllByStatus(int status);

    @Query(value = "select * from m_data_jpa",nativeQuery = true)
    List<MUserEntity> findAllByQuery();
}
