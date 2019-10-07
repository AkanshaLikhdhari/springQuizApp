package com.target.springQuizApp.repositories;

import com.target.springQuizApp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserDataRepository extends JpaRepository<UserEntity,Long> {
    }


