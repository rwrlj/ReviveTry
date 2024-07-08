package com.example.revivetry.dao.impl;

import com.example.revivetry.dao.GirlFriendDao;
import com.example.revivetry.entity.GirlFriend;
import com.example.revivetry.mapper.GirlFriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author rwr
 */
@Repository
public class GirlFriendDaoImpl implements GirlFriendDao {

    @Autowired
    private GirlFriendMapper girlFriendMapper;

    @Override
    public GirlFriend getById(Integer id) {
        return girlFriendMapper.selectByPrimaryKey(id);
    }

}
