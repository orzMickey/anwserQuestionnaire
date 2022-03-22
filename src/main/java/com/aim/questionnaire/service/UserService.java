package com.aim.questionnaire.service;

import com.aim.questionnaire.dao.UserEntityMapper;
import com.aim.questionnaire.dao.entity.ProjectEntity;
import com.aim.questionnaire.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;
    public UserEntity selectAllByName(String username) {
        UserEntity hasUser = userEntityMapper.selectAllByName(username);
        return  hasUser;
    }

    public void insert(UserEntity userEntity){
        userEntityMapper.insert(userEntity);
    }


    public List<Object> queryUserList(String username) {
        List<Object> resultList = new ArrayList<Object>();
        List<Map<String,Object>> userResult = userEntityMapper.queryUserList(username);
        for(Map<String,Object> userObj : userResult) {
            resultList.add(userObj);
        }
        return resultList;
    }
    public List<Object> queryFuzzySearch(String username,int start,int end) {
        List<Object> resultList = new ArrayList<Object>();
        List<Map<String,Object>> userResult = userEntityMapper.queryFuzzySearch(username,start,end);
        for(Map<String,Object> userObj : userResult) {
            resultList.add(userObj);
        }
        return resultList;
    }
}
