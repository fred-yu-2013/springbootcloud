package cn.fred.dao;

import cn.fred.model.User;
import cn.fred.model.User2;
import org.apache.ibatis.annotations.Param;

public interface User2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User2 record);

    int insertSelective(User2 record);

    User2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User2 record);

    int updateByPrimaryKey(User2 record);

    User2 findByUsernameAndPasswd(@Param("username") String username, @Param("password") String password);
}