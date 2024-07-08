package com.example.revivetry.controller;


import com.example.revivetry.entity.GirlFriend;
import com.example.revivetry.service.GirlFriendService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rwr
 */
@RestController
public class GirlFriendController {

    @Autowired
    private GirlFriendService girlFriendService;

    @RequestMapping("/getgirlfriend")
    public GirlFriend getGirlFriendById(@Param("id") String id){
        System.out.println("this is my debug test");
        System.out.println("second step");
        return girlFriendService.getById(Integer.valueOf(id));
    }


}
