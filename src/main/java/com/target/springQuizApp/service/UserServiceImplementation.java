package com.target.springQuizApp.service;

import com.target.springQuizApp.model.UserEntity;
import com.target.springQuizApp.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserDataRepository userDataRepository;

    public UserEntity getUserData() {
        return userDataRepository.findAll().get(0);
    }
}
