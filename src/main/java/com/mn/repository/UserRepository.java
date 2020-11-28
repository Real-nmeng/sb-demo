package com.mn.repository;

import com.mn.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mengna
 * @date 2020/11/26 11:46
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    UserEntity getUserEntityById(Integer id);


}
