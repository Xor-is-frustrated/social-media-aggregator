package com.personal.aggregator.repository;

import com.personal.aggregator.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
