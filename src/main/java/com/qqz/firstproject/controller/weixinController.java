package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-06-08  21:41
*/

import com.qqz.firstproject.Utils.GsonUtil;
import com.qqz.firstproject.bean.Record;
import com.qqz.firstproject.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
public class weixinController {
    @Autowired
    private OrderMapper orderMapper;
    private String url = "xxxxxxxxxxxxxxxx";
    private static final String APP_ID = "xxxxxxxxxxxxxxxxx";
    private static final String APP_SECRET = "xxxxxxxxxxxxxxxxx";

    @GetMapping("/wx/getLogin/{code}")
    public String WXGetLogin(@PathVariable("code") String code){
        String session = sendPostRequest(url,"appid="+APP_ID+"&secret="+APP_SECRET+"&js_code="+code+"&grant_type=authorization_code");
        Map<String, Object> sessionMap = GsonUtil.fromJson(session, Map.class);
        String openId = (String) sessionMap.get("openid");
        return openId;
    }
    @GetMapping("/wx/getRecord/{openid}")
    public List<Record> WXGetRecord(@PathVariable("openid")String open_id){
        List<Record> recordList=orderMapper.selectByOpenId(open_id);
        for(int i=0;i<recordList.size();i++){
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
            recordList.get(i).setCreate_time_str(sdf.format(recordList.get(i).getCreate_time()));
        }
        return recordList;
    }
    public static String sendPostRequest(String url,String param){
        DataOutputStream dataOutputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder ();
        try {
            if(url != null && param!=null){
                URL postUrl = new URL ( url );
                HttpURLConnection httpURLConnection = (HttpURLConnection) postUrl.openConnection ();
                httpURLConnection.setRequestMethod ( "GET" );
                httpURLConnection.setUseCaches ( false );
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes(param);
                dataOutputStream.flush();
                bufferedReader =
                        new BufferedReader(new InputStreamReader (httpURLConnection.getInputStream(), "utf-8"));
                String line;
                while (null != (line = bufferedReader.readLine())) {
                    stringBuilder.append(line);
                }
                httpURLConnection.disconnect();
                return stringBuilder.toString();
            }
        }catch (Exception e){
            e.printStackTrace ();
        }finally {
            try {
                if (null != dataOutputStream) {
                    dataOutputStream.close();
                }
                if (null != bufferedReader) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
            }
        }
        return null;
    }

}
