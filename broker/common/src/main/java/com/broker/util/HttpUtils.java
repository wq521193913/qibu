package com.broker.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

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

            HttpPost httpPost = new HttpPost(urlStr.toString());
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if(null != httpEntity){
                return EntityUtils.toString(httpEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
