package com.turing.sp5.service;

import com.turing.sp5.entity.User;
import com.turing.sp5.entity.UserExample;
import com.turing.sp5.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        UserExample example=new UserExample();
        example.createCriteria().andNameEqualTo(user.getName())
                .andPasswordEqualTo(user.getPassword());
        if (userMapper.selectByExample(example).size()==0){
            return  null;
        }else{
            return userMapper.selectByExample(example).get(0);
        }
        
    }
}
