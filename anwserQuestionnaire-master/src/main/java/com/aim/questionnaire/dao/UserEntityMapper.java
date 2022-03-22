package com.aim.questionnaire.dao;

import com.aim.questionnaire.dao.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface UserEntityMapper {
    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    UserEntity selectAllByName(String username);
    List<Map<String,Object>> queryUserList(String username);
    void insert(UserEntity userEntity);
    List<Map<String,Object>> queryFuzzySearch(String username,int start,int end);
    List<Map<String,Object>> answer2Question(String question);
}