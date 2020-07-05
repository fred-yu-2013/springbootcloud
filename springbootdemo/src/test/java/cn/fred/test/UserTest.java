package cn.fred.test;

import cn.fred.App;
import cn.fred.dao.User2Mapper;
import cn.fred.model.User2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes={App.class})
@RunWith(SpringRunner.class)
public class UserTest {

    @Resource
    private User2Mapper user2Mapper;

    @Test
    public void testAdd() {
        User2 user = new User2();
        user.setUsername("zhangsan");
        user.setPassword("password");
        user2Mapper.insertSelective(user);
    }

    @Test
    public void testFindUser() {
        User2 user = user2Mapper.findByUsernameAndPasswd("zhangsan", "password");
        System.out.println(user);
    }

}
