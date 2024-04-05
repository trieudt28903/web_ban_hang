package com.spring.admin.service.user;

import com.spring.admin.entity.User;
import com.spring.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Override
    public User findByUserName(String userName) {

        return repository.findByUserName(userName);
    }
}
