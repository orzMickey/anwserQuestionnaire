package com.aim.questionnaire.controller;

import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.common.Constans;
import com.aim.questionnaire.common.utils.UUIDUtil;
import com.aim.questionnaire.dao.entity.ProjectEntity;
import com.aim.questionnaire.dao.entity.UserEntity;
import com.aim.questionnaire.service.UserService;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity userLogin(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity =new HttpResponseEntity();
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        UserEntity hasUser = userService.selectAllByName(username);
        if(password.equals(hasUser.getPassword())){
            httpResponseEntity.setData(hasUser);
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
            httpResponseEntity.setMessage("登录成功");
        }else{
            httpResponseEntity.setData(hasUser);
            httpResponseEntity.setCode(Constans.LOGIN_PASSWORD_MESSAGE);
            httpResponseEntity.setMessage("密码错误");
        }
        return httpResponseEntity;
    }
    @RequestMapping(value = "/addUserInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity userCreate(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        UserEntity userEntity = new UserEntity();
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        Date startTime = new Date(Long.parseLong(map.get("startTime").toString())) ;
        Date stopTime  = new Date(Long.parseLong(map.get("stopTime").toString()));
        //userEntity.setId(String.valueOf(userEntity.hashCode()));
        userEntity.setId(UUIDUtil.getOneUUID());
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setStartTime(startTime);
        userEntity.setStopTime(stopTime);
        userEntity.setStatus("1");
        userService.insert(userEntity);

        httpResponseEntity.setData(userEntity);
        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        httpResponseEntity.setMessage("创建成功");
        return httpResponseEntity;
    }

    @RequestMapping(value = "/queryUserList",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity fuzzySearch(@RequestBody(required = false) Map<String,Object> map){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        String username = map.get("userName").toString();

        List<Object> result = userService.queryUserList(username);
        Map<String,Object> map1=new HashMap<>();
        Integer total = result.size();//查询总数

        List<Object> result_search;
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        if(pageNum*pageSize<Integer.parseInt(String.valueOf(total))){
            result_search = userService.queryFuzzySearch(username,(pageNum-1)*pageSize,pageSize);
        } else {
            result_search = userService.queryFuzzySearch(username,(pageNum-1)*pageSize,total % pageSize);
        }
        map1.put("total",total);
        map1.put("pageNum",pageNum);
        map1.put("list",result_search);
        //map1.put("list",result);
        //System.out.println(result);
        //System.out.println(result_search);
        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        httpResponseEntity.setMessage("查询成功");
        httpResponseEntity.setData(map1);
        return httpResponseEntity;
    }

    @RequestMapping(value = "/addUserInfoList",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addUserInfoList(@RequestBody(required = false) Map<String,List<Object>> map){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        List<Object> result = map.get("list");
        for (int i = 0; i < result.size(); i++) {
            UserEntity userEntity = new UserEntity();
            JSONObject json = (JSONObject) JSONObject.toJSON(result.get(i));
            userEntity.setId((String) json.get("id"));
            userEntity.setUsername((String) json.get("username"));
            try{
                userEntity.setPassword((String) json.get("password"));
            }catch (ClassCastException e){
                userEntity.setPassword(Integer.toString((Integer) json.get("password")));
            }
            double time1 = (double) json.get("start_time");
            time1 = (time1 - 70*365-19)*86400-8*3600;
            long l1 = new Double(time1*1000).longValue();
            Date startTime = new Date(l1);
            double time2 = (double) json.get("stop_time");
            time2 = (time2 - 70*365-19)*86400-8*3600;
            long l2 = new Double(time2*1000).longValue();
            Date stopTime = new Date(l2);
            userEntity.setStartTime(startTime);
            userEntity.setStopTime(stopTime);
            userEntity.setStatus(Integer.toString((Integer) json.get("status")));
            //System.out.println(json.get("status").getClass().getName());
            userService.insert(userEntity);
        }

        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        httpResponseEntity.setMessage("导入成功");
        return httpResponseEntity;
    }

    @RequestMapping(value = "/selectUserListToExcel",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity selectUserListToExcel(@RequestBody(required = false) Map<String,List<Object>> map){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        httpResponseEntity.setMessage("导出成功");
        return httpResponseEntity;
    }

}
