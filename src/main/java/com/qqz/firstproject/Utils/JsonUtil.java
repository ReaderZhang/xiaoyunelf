package com.qqz.firstproject.Utils;/*
@Author qqz
@create 2020-05-31  11:11
*/

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {
    public static void main(String[] args) {
        JsonParser jp = new JsonParser ();
        String resultStr = "{\"status\": 0,\"message\": \"query ok\","+
                "\"result\": {\"address\": \"北京市海淀区镜桥\","+
                "\"address_component\": {\"nation\": \"中国\",\"province\": \"北京市\","+
                "\"city\": \"北京市\",\"district\": \"海淀区\","+
                "\"street\": \"镜桥\",\"street_number\": \"镜桥\"}}}";
        JsonObject jo = jp.parse ( resultStr ).getAsJsonObject ();
        String message = jo.get("message").getAsString ();
        System.out.println ("message" + message);

        String address = jo.get ( "result" ).getAsJsonObject ().get ( "address" ).getAsString ();
        System.out.println ("address" + address);
        String nation = jo.get("result").getAsJsonObject ().get ( "address_component" ).getAsJsonObject ().get ( "nation" ).getAsString ();
        System.out.println ("nation"+nation);
    }
}
