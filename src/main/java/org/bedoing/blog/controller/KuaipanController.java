package org.bedoing.blog.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSONObject;

//@Controller
//@RequestMapping("kuaipanController")
public class KuaipanController {
    
   /* org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(LoginController.class);
    
    @Autowired
    private CloudInfoDao cloudInfoDao;
    String oauth_consumer_key = "创建应用时的consumer_key";//第1步的 consumer_key
    String oauth_signature_method = "HMAC-SHA1";//签名方法
    String oauth_signature = "";//本次请求的签名
    String consumer_secret = "创建应用时的consumer_secret";
    String oauth_timestamp = "";
    String oauth_version = "1.0";//版本
    String oauth_nonce = "";//[ 0-9A-Za-z_ ]随机字符串,长度小于32字节。每次请求请使用不同的nonce
    String oauth_request_method = "GET";
    String requst_token_url = "https://openapi.kuaipan.cn/open/requestToken";
    String accessToken_url = "https://openapi.kuaipan.cn/open/accessToken";
    //必须外网能访问
    String oauth_callback = "http://roboming.com/ming/kuaipanController/callback.do";  //回调函数，用户授权后返回的地址
    
    @RequestMapping(value = "/OAuth.do", method = RequestMethod.GET)
    public void oauth(HttpServletRequest request, HttpServletResponse response) throws 
        ServletException,IOException {
        oauth_timestamp = set_timestamp();
        oauth_nonce = set_nonce();
        String set_basestring;
        HttpSession session = request.getSession();
        MemInfo mem = (MemInfo)session.getAttribute("memInfo");
        try {
            set_basestring = set_basestring();
            oauth_signature = hmacsha1(set_basestring, consumer_secret+"&");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(KuaipanController.class.getName()).log(Level.WARN, null, ex);
        }
        StringBuffer url = new StringBuffer("https://openapi.kuaipan.cn/open/requestToken?");
            url.append("oauth_signature=" + oauth_signature + "&");
            url.append("oauth_callback=" + oauth_callback + "&");
            url.append("oauth_consumer_key=" + oauth_consumer_key + "&");
            url.append("oauth_nonce=" + oauth_nonce + "&");
            url.append("oauth_signature_method=" + oauth_signature_method + "&");
            url.append("oauth_timestamp=" + oauth_timestamp + "&");
            url.append("oauth_version=" + oauth_version +"");
            //第一步（获取未授权的临时 token）
            String message = retrieveHttpResponse(url.toString());
            JSONObject obj = new JSONObject(message);
            log4j.debug("第一步执行成功返回的json："+obj);
            log4j.debug("json："+obj.get("oauth_token_secret"));
            CloudInfo cloudInfo = new CloudInfo();
            cloudInfo.setCloudsecret((String)obj.get("oauth_token_secret"));
            cloudInfo.setToken((String)obj.get("oauth_token"));
            cloudInfo.setMemInfo(mem);
            cloudInfoDao.saveCloudInfo(cloudInfo);
            //第二步（用户登陆并授权你的应用）
            String url1 = "https://www.kuaipan.cn/api.php?ac=open&op=authorise&oauth_token="+obj.get("oauth_token");
            response.sendRedirect(url1);   
    }
    
    *//**
     * 金山快盘回调地址
     * @param request
     * @param response
     * @param oauth_token 临时token
     * @param oauth_verifier 验证码
     * @return
     * @throws IOException 
     *//*
    @RequestMapping(value = "/callback.do", method = RequestMethod.GET)
    public String Callback(HttpServletRequest request, HttpServletResponse response,
            @RequestParam String oauth_token, @RequestParam String oauth_verifier) 
            throws IOException {
        oauth_timestamp = set_timestamp();
        oauth_nonce = set_nonce();
        CloudInfo cloud = cloudInfoDao.findCloudInByToken(oauth_token);
      
        String signature;
        try {
            signature = set_signature(oauth_token);
            oauth_signature = hmacsha1(signature, consumer_secret+"&"+cloud.getCloudsecret());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }

        String url = "https://openapi.kuaipan.cn/open/accessToken?"
                + "&oauth_signature=" + oauth_signature
                + "&oauth_consumer_key=" + oauth_consumer_key
                + "&oauth_nonce=" + oauth_nonce
                + "&oauth_signature_method=" + oauth_signature_method
                + "&oauth_timestamp=" + oauth_timestamp
                + "&oauth_token=" + oauth_token
                + "&oauth_version=" + oauth_version;
            //第三步（获取 access_token）
            String message = retrieveHttpResponse(url);
            JSONObject obj = new JSONObject(message);
            log4j.debug("返回的json："+obj);
            cloud.setCloudkey(oauth_consumer_key);
            cloud.setToken((String)obj.get("oauth_token"));
            cloud.setType("金山快盘");
            cloud.setMemInfo(cloud.getMemInfo());
            cloudInfoDao.saveCloudInfo(cloud);
     
            return "redirect:/memController/toMessage.do";
    }
    
    
    public String set_basestring() throws UnsupportedEncodingException {
        String bss;
        bss = oauth_request_method + "&" + URLEncoder.encode(requst_token_url, "utf-8") + "&";
        oauth_callback = URLEncoder.encode(oauth_callback,"utf-8");
        String bsss = "oauth_callback=" + oauth_callback
                + "&oauth_consumer_key=" + oauth_consumer_key
                + "&oauth_nonce=" + oauth_nonce
                + "&oauth_signature_method=" + oauth_signature_method
                + "&oauth_timestamp=" + oauth_timestamp
                + "&oauth_version=" + oauth_version;
        bsss = URLEncoder.encode(bsss, "utf-8");
        return bss + bsss;
    }
    
    public String set_signature(String oauth_token) throws UnsupportedEncodingException {
        String bss;
        bss = oauth_request_method + "&" + URLEncoder.encode(accessToken_url, "utf-8") + "&";
            String bsss = "oauth_consumer_key=" + oauth_consumer_key
                + "&oauth_nonce=" + oauth_nonce
                + "&oauth_signature_method=" + oauth_signature_method
                + "&oauth_timestamp=" + oauth_timestamp
                + "&oauth_token=" + oauth_token
                + "&oauth_version=" + oauth_version;
        bsss = URLEncoder.encode(bsss, "utf-8");
        String bs = bss+ bsss;
        return bs;
    }
    
    *//**
     * 本次请求的签名
     * @param data
     * @param key
     * @return 
     *//*
    public String hmacsha1(String data, String key) {
        byte[] byteHMAC = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA1");  
            SecretKeySpec spec = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            mac.init(spec);
            byteHMAC = mac.doFinal(data.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ignore) {
        }
        String oauth = new BASE64Encoder().encode(byteHMAC);
        String signatureEncode = "";
        try {
            signatureEncode = URLEncoder.encode(oauth, "utf-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(KuaipanController.class.getName()).log(Level.WARN, null, ex);
        }
        oauth = signatureEncode;
        return oauth;
    }

    *//**
     * [ 0-9A-Za-z_ ]随机字符串,长度小于32字节。每次请求请使用不同的nonce
     * @return 
     *//*
    public String set_nonce() {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789"; 
        Random random = new Random();
        StringBuffer sb = new StringBuffer(); 
        for (int i = 0; i < 32; i++) { 
        int number = random.nextInt(base.length()); 
        sb.append(base.charAt(number));
        }
        return sb.toString(); 
    }
   
    *//**
     * 时间戳，正整数，和标准时间不超过5分钟
     * @return 
     *//*
    public String set_timestamp() {
        Date date = new Date();
        long time = date.getTime();
        return (time + "").substring(0, 10);
    }
    
    public String retrieveHttpResponse(String url) throws IOException {
        URL urlGet = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlGet.openConnection();
        conn.setRequestMethod("GET"); // 必须是get方式请求
        conn.setDoOutput(false);
        conn.setDoInput(true);
        conn.setConnectTimeout(30000);
        conn.setReadTimeout(30000);
        conn.connect();
        InputStream is = conn.getInputStream();
        int size = is.available();
        byte[] jsonBytes = new byte[size];
        is.read(jsonBytes);
        conn.disconnect();
        String message = new String(jsonBytes, "UTF-8");
        return message;
    }
    */
 
}

