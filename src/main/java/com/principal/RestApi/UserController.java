package com.principal.RestApi;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.HashMap;

@RestController
public class UserController {

    public static HashMap<Integer,User> userinfo = new HashMap<>();

    @GetMapping("/get_user")
    public User getUser(@RequestParam(value = "userId",required = false,defaultValue = "3") int id)
    {
        return userinfo.get(id);
    }

    @PostMapping("/insert_user")
    public void insertUser(@RequestBody User myUser)
    {
        if(userinfo.containsKey(myUser.getUserid()))
        {
            return;
        }
        userinfo.put(myUser.getUserid(),myUser);
    }

    @GetMapping("/get_allUsers")       //API to get all users present in MAP
    public Map<Integer,User> GetAllUsers()
    {
        return userinfo;
    }


    @DeleteMapping("/delete_user/{uid}")
    public void deleteUser(@PathVariable("uid") int id)
    {
        userinfo.remove(id);
    }

    @DeleteMapping("/delete_user1/{uid}/{name}")    //Delete API -Variation 2
    public void deleteUser1(@PathVariable("uid") int id, @PathVariable("name") String name)
    {
        userinfo.remove(id);
    }


    @PutMapping("/change_userInfo")    //Method-1, when client is sending the entire User Object
    public void modifyDetails(@RequestParam(value="userId")int id,@RequestBody User user)
    {
        userinfo.put(id,user);
    }


    @PutMapping("/change_userInfo1")  //When client is sending only the values the need to change
    public User modifyDetails1(@RequestParam(value="userId")int id,@RequestBody User user)
    {
        User prevUser = userinfo.get(id);
        if(user.getAge() != 0)
        {
            prevUser.setAge(user.getAge());
        }

        if(user.getName() != null)
        {
            prevUser.setName(user.getName());
        }

        if(user.getCountry() != null)
        {
            prevUser.setCountry(user.getCountry());
        }

        userinfo.put(id,prevUser);
        return prevUser;
    }//curl -XPUT "127.0.0.1:8088/change_userInfo1?userId=3" -H "Content-Type:application/json" -d"{\"name\":\"Aman\",\"age\":65,\"country\":\"Norway\"}" -v

}
