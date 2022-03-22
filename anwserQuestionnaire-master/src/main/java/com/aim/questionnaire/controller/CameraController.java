package com.aim.questionnaire.controller;

import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.common.Constans;
import com.aim.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class CameraController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/aiLogin", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity aiLogin(@RequestBody Map<String,Object> map) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        String result1 = (String) map.get("imgData");
        String []base64 = result1.split(",");
        float catchScore = getFaceMatch(base64[1]);
        if(catchScore > 80) {
            map.put("username","admin");
            map.put("password","1");
            map.put("id","8ceeee2995f3459ba1955f85245dc7a5");
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
            httpResponseEntity.setMessage("识别成功");
        }else{
            httpResponseEntity.setCode(Constans.LOGIN_PASSWORD_MESSAGE);
            httpResponseEntity.setMessage("识别失败");
        }
        return httpResponseEntity;
    }

    public static String getToken(String clientId,String clientSecret) {
        //获得token
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + clientId
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + clientSecret;
        //String access_token = "";
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map1 = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map1.keySet()) {
                System.err.println(key + "--->" + map1.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

public static float getFaceMatch(String img){
        //请求
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            String filePath = "E:/faceMatch/face.jpg";
            byte[] imgData1 = com.baidu.ai.aip.utils.FileUtil.readFileByBytes(filePath);
            String imgParam1 = com.baidu.ai.aip.utils.Base64Util.encode(imgData1);
            Map<String,String> map1 = new HashMap<>();
            map1.put("image",imgParam1);
            map1.put("image_type","BASE64");
            List<Map<String,String>> list = new ArrayList<>();
            list.add(map1);
            Map<String,String> map2 = new HashMap<>();
            map2.put("image",img);
            map2.put("image_type","BASE64");
            list.add(map2);
            String param = com.baidu.ai.aip.utils.GsonUtils.toJson(list);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "[调用鉴权接口获取的token]";
//            String clientId = "BO4fyMYv7nkTUlsGFmHTHex6";
//            String clientSecret = "lus2ssjrL2XqRFKaHkp1qmC4tR6b1XNt";
            String access_token = getToken("BO4fyMYv7nkTUlsGFmHTHex6","lus2ssjrL2XqRFKaHkp1qmC4tR6b1XNt");
            String result = com.baidu.ai.aip.utils.HttpUtil.post(url, access_token, "application/json", param);
            JSONObject jsonObject = new JSONObject(result);
            JSONObject jsob = new JSONObject(jsonObject.get("result").toString());
            float catchScore = Float.parseFloat(jsob.get("score").toString());
            System.out.println(catchScore);//获取匹配值
            return catchScore;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (float) 1;
    }
}