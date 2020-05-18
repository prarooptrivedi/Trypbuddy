package com.example.trypbuddy.Services;



import org.json.JSONArray;
import org.json.JSONObject;


public class WebService {
    private static final String Url_Base = "http://uat.zepth.com/api/";

/*    public static ProjectList login(String user_id,String token) {
        try {
            String res = null;
            String C_URL = Url_Base+"projects/";
            String[] key = {"user_id","token"};
            String[] values = {user_id.toString(),token.toString()};
            String response= FCHttpUtil.okhttpPost(C_URL,key,values);
           *//* JSONObject jsonObj = new JSONObject(
                    UtilClassForValidations
                            .convertStringFromInputStream(FCHttpUtil.httpPost(
                                    C_URL, values, key)));*//*
            ProjectList u = new ProjectList();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                String Status=jsonObject.getString("status");
                if (Status.equalsIgnoreCase("success")){
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    u.setJsonArray(jsonArray);
                    u.setStatus(Status);
                }
                else {
                    u.setStatus(Status);
                }
            } catch (Exception e) {
                e.printStackTrace();
                u = null;
            }
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
