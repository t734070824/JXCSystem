package com.friday.inter;

import com.friday.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String uId);

    int insert(User record);

    int insertSelective(User record);

    /**
     * 根据uid获取用户信息
     * @param uId 用户id
     * @return
     */
    User selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}