package com.qibu.wxapi.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.util.Map;

/**
 * @author: wq
 * @description: httpUtils
 * @date: Create in 2018/3/15 0015 下午 8:59
 * @modified:
 */
public class HttpUtils {

    private static Integer lock = 0;
    public static HttpUtils httpUtils = null;

    private final Logger logger = Logger.getLogger(HttpUtils.class);

    private HttpUtils(){
    }

    public static HttpUtils getInstance(){
        if(null == httpUtils){
            synchronized (lock){
                if(null == httpUtils){
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    /**
     * @author: wq
     * @description: http get method
     * @param url
     * @return: string
     * @date: Create in 2018/3/15 0015 下午 9:52
     * @modified:
     */
    public String requestGet(String url){
        try {
           return this.requestGet(url, null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author: wq
     * @description: http get method
     * @param url
     * @param params
     * @return: string
     * @date: Create in 2018/3/15 0015 下午 9:53
     * @modified:
     */
    public String requestGet(String url, Map<String, Object> params){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            StringBuilder urlStr = new StringBuilder(url);
            if(urlStr.indexOf("?") <= 0){
                urlStr.append("?random="+System.nanoTime());
            }

            if(null != params){
                for (String key : params.keySet()){
                    urlStr.append(String.format("&%s=%s",key,params.get(key)));
                }
            }

            HttpGet httpGet = new HttpGet(urlStr.toString());
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            if(null != httpEntity){
                return EntityUtils.toString(httpEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author: wq
     * @description: http get method
     * @param url
     * @param params
     * @return: string
     * @date: Create in 2018/3/15 0015 下午 9:53
     * @modified:
     */
    public String requestPost(String url, Map<String, Object> params){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            StringEntity se = new StringEntity(JSONObject.fromObject(params).toString());
            se.setContentType("text/json");
            se.setContentEncoding(new BasicHeader("Content-Type", "application/json"));
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);

            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,"UTF-8");
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public String requestPost(String url, String params){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            StringEntity se = new StringEntity(params, "UTF-8");
            se.setContentType("application/json");
            se.setContentEncoding("UTF-8");
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);

            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,"UTF-8");
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 微信退款双向证书请求
     * @param url
     * @param certFilePath
     * @param mch_id
     * @param xmlParams
     * @return
     * @throws Exception
     */
    public String certRequestPost(String url, String certFilePath, String mch_id, String xmlParams) throws Exception{
        logger.debug(String.format("微信退款请求 url:%s; mch_id:%s; xmlParams:%s",url,mch_id,xmlParams));
        String result = "";
        //商户id
        //指定读取证书格式为PKCS12
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        //读取本机存放的PKCS12证书文件

        File file = new File(certFilePath);
        if(!file.exists()){
            logger.debug("无法找到微信退款请求证书. path:" + certFilePath);
            throw new ValidatorException("无法找到微信退款证书");
        }
        FileInputStream instream = new FileInputStream(file);
        try {
            //指定PKCS12的密码(商户ID)
            keyStore.load(instream, mch_id.toCharArray());
        } finally {
            instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mch_id.toCharArray()).build();
        //指定TLS版本
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        //设置httpclient的SSLSocketFactory
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {
            HttpPost httppost = new HttpPost(url);
            StringEntity reqEntity = new StringEntity(xmlParams, "UTF-8");
            httppost.setEntity(reqEntity);

            logger.debug("Executing request: " + httppost.getRequestLine());
            CloseableHttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
                result = EntityUtils.toString(response.getEntity(),"UTF-8");
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
