package com.example.revivetry.service.impl;

import com.example.revivetry.dao.GirlFriendDao;
import com.example.revivetry.entity.GirlFriend;
import com.example.revivetry.service.GirlFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rwr
 */
@Service
public class GirlFriendServiceImpl implements GirlFriendService {

    @Autowired
    private GirlFriendDao girlFriendDao;

    @Override
    public GirlFriend getById(Integer id) {
        return girlFriendDao.getById(id);
    }

}
