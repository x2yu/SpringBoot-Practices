package com.x2yu.demo;

import com.x2yu.demo.model.User;
import com.x2yu.demo.repository.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userService.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
//        userService.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

        Assert.assertEquals(3,userService.findAll().size());
        //Assert.assertEquals("bb",userService.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        userService.delete(userService.findByUserName("aa1"));

    }

}
