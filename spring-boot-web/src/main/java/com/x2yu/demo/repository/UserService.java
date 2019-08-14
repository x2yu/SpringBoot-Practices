package com.x2yu.demo.repository;

import com.x2yu.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: x2yu
 * @Date: 2019/8/9 9:22
 */

@Repository
public interface UserService extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
