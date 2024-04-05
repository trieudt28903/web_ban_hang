package com.spring.admin.service.user;

import com.spring.admin.entity.User;

public interface UserService {
    User findByUserName(String userName);
}
