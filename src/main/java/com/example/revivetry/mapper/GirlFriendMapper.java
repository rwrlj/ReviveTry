package com.example.revivetry.mapper;

import com.example.revivetry.entity.GirlFriend;
import org.springframework.stereotype.Repository;

@Repository
public interface GirlFriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GirlFriend record);

    int insertSelective(GirlFriend record);

    GirlFriend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GirlFriend record);

    int updateByPrimaryKey(GirlFriend record);
}