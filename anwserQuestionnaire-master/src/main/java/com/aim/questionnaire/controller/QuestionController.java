package com.aim.questionnaire.controller;


import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.common.Constans;
import com.aim.questionnaire.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    @RestController
    @RequestMapping("/admin")
    public class QuestionController {
        @Autowired
        private UserService userService;
        @RequestMapping(value = "/aiQuestion", method = RequestMethod.POST, headers = "Accept=application/json")
        public HttpResponseEntity aiLogin(@RequestBody Map<String, Object> map) {
            HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
            String answer = matchAnswer((String) map.get("UserInput"));
            System.out.println(answer);
            if(!answer.equals("?")){
                httpResponseEntity.setCode(Constans.SUCCESS_CODE);
                httpResponseEntity.setData(answer);
                return httpResponseEntity;
            }
            else {
                httpResponseEntity.setCode(Constans.MODEL_NO_PATH);
                return httpResponseEntity;
            }

        }

        public String matchAnswer(String question){
            String answer = "";
            float score = 0;
            try{
                String access_token  = CameraController.getToken("Y6Y8Nw1YTkM6tMIWTcQGpAaP","edjEtQEbY0nmSZITHmSWNuM61gCZUKz3");
                String url ="https://aip.baidubce.com/rpc/2.0/nlp/v2/simnet";
                List<Object> result1 = userService.answer2Question("");
                Integer total = result1.size();//获取数据库问题的总数
                //System.out.println(result1);
                //System.out.println(result1.get(0));
                for (int i = 0; i < total; i++) {
                    Map<String,String> map1 = (Map<String, String>) result1.get(i);
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("text_1",question);//问题
                    jsonObject1.put("text_2",map1.get("question_entity"));
                    String result = com.baidu.ai.aip.utils.HttpUtil.post(url, access_token, "application/json", String.valueOf(jsonObject1));
                    Thread.sleep(300);
                    JSONObject jsonObject = new JSONObject(result);
                    float catchScore = Float.parseFloat(jsonObject.get("score").toString());
                    System.out.println(catchScore);//获取匹配值
                    if( score < catchScore){
                        answer = map1.get("question_answer");
                        score = catchScore;
                        if(score==1){return answer;}
                    }
                }
                return answer;
            }catch (Exception e) {
                e.printStackTrace();
            }
            return "?";
        }

    }

