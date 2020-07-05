package cn.fred.service.impl;

import cn.fred.dao.User2Mapper;
import cn.fred.model.User2;
import cn.fred.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private User2Mapper user2Mapper;

    @Override
    public boolean login(String username, String passwd) {
        User2 user = user2Mapper.findByUsernameAndPasswd(username, passwd);
        return user != null;
    }

    @Override
    public boolean register(String username, String passwd) {
        User2 user = new User2();
        user.setUsername(username);
        user.setPassword(passwd);
        int cnt = user2Mapper.insertSelective(user);
        return cnt > 0;
    }

    @Override
    @Transactional
    public void batchAdd(String username, String passwd) {
        User2 users = new User2();
        users.setUsername(username);
        users.setPassword(passwd);
        user2Mapper.insertSelective(users);
        int i = 10 / 0;
        users = new User2();
        users.setUsername(username+"2");
        users.setPassword(passwd);
        user2Mapper.insertSelective(users);
    }
}
