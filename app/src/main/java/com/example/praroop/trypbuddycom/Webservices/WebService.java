package com.example.praroop.trypbuddycom.Webservices;



import com.example.praroop.trypbuddycom.Models.CombineDataSetNew;
import com.example.praroop.trypbuddycom.Utils.FCHttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;


public class WebService {
   // private static final String Url_Base = "http://rvsclasses.in/coupouns/api";
   // http://sampledocs.org/trypbuddy/core/api/tripcategory/listtripcategory.php
    private static final String Url_Base = "http://sampledocs.org/trypbuddy/core/api";



    public static CombineDataSetNew offercoupon() {
        try {
            String res = null;
            String C_URL = Url_Base+"/tripcategory/listtripcategory.php";
            String[] key = {};
            String[] values = {};
            String response=FCHttpUtil.okhttpPost(C_URL,key,values);
           /* JSONObject jsonObj = new JSONObject(
                    UtilClassForValidations
                            .convertStringFromInputStream(FCHttpUtil.httpPost(
                                    C_URL, values, key)));*/
            CombineDataSetNew u = new CombineDataSetNew();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("records");
                if (jsonArray.length() >0) {
                    u.setJsonArray(jsonArray);
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
    }
    public static CombineDataSetNew LoadList(String catId) {
        try {
            String res = null;
            String C_URL = Url_Base+"/trip/listtrip.php";
            String[] key = {"category_id"};
            String[] values = {catId.toString()};
            String response=FCHttpUtil.okhttpPost(C_URL,key,values);
            CombineDataSetNew u = new CombineDataSetNew();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("records");
                if (jsonArray.length() >0) {
                    u.setJsonArray(jsonArray);
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
    }
    public static CombineDataSetNew Loaddetails(String catId) {
        try {
            String res = null;
            String C_URL = Url_Base+"/trip/listtripAll.php";
            String[] key = {"id"};
            String[] values = {catId.toString()};
            String response=FCHttpUtil.okhttpPost(C_URL,key,values);
            CombineDataSetNew u = new CombineDataSetNew();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("details");
                if (jsonArray.length() >0) {
                    u.setJsonArray(jsonArray);
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
    }
    public static CombineDataSetNew aboutusload() {
        try {
            String res = null;
            String C_URL = Url_Base+"/aboutus/listaboutus.php";
            String[] key = {};
            String[] values = {};
            String response=FCHttpUtil.okhttpPost(C_URL,key,values);
            CombineDataSetNew u = new CombineDataSetNew();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("records");
                if (jsonArray.length() >0) {
                    u.setJsonArray(jsonArray);
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
    }
    public static CombineDataSetNew faqLoad() {
        try {
            String res = null;
            String C_URL = Url_Base+"/faq/listfaq.php";
            String[] key = {};
            String[] values = {};
            String response=FCHttpUtil.okhttpPost(C_URL,key,values);
            CombineDataSetNew u = new CombineDataSetNew();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("records");
                if (jsonArray.length() >0) {
                    u.setJsonArray(jsonArray);
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
    }
    public static CombineDataSetNew termsandconditionLoad() {
        try {
            String res = null;
            String C_URL = Url_Base+"/terms/listterms.php";
            String[] key = {};
            String[] values = {};
            String response=FCHttpUtil.okhttpPost(C_URL,key,values);
            CombineDataSetNew u = new CombineDataSetNew();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("records");
                if (jsonArray.length() >0) {
                    u.setJsonArray(jsonArray);
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
    }
    public static CombineDataSetNew privacypolicyLoad() {
        try {
            String res = null;
            String C_URL = Url_Base+"/privacy/listprivacy.php";
            String[] key = {};
            String[] values = {};
            String response=FCHttpUtil.okhttpPost(C_URL,key,values);
            CombineDataSetNew u = new CombineDataSetNew();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("records");
                if (jsonArray.length() >0) {
                    u.setJsonArray(jsonArray);
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
    }
    public static CombineDataSetNew submitcallback(String userid,String devicetype,String deviceid,String countrycode,String mobilenumber) {
        try {
            String res = null;
            String C_URL = Url_Base+"/requestcallback/create.php";
            String[] key = {"userid","devicetype","deviceid","countrycode","mobilenumber"};
            String[] values = {userid.toString(),devicetype.toString(),deviceid.toString(),countrycode.toString(),mobilenumber.toString()};
            String response=FCHttpUtil.okhttpPost(C_URL,key,values);
           /* JSONObject jsonObj = new JSONObject(
                    UtilClassForValidations
                            .convertStringFromInputStream(FCHttpUtil.httpPost(
                                    C_URL, values, key)));*/
            CombineDataSetNew u = new CombineDataSetNew();
            String resss;
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("records");
                if (jsonArray.length() >0) {
                    u.setJsonArray(jsonArray);
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
    }

}
