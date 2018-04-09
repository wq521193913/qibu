package com.broker.util;

/**
 * @author: Administrator
 * @description: 文件上传下载
 * @date: 2018/4/9 0009 16:18
 * @modified:
 */
public class FastDFSUtils {
    private static Integer lock = 0;
    public static FastDFSUtils fastDFSUtils = null;

    private FastDFSUtils(){}

    public static FastDFSUtils getInstance(){
        if(null == fastDFSUtils){
            synchronized (lock){
                if(null == fastDFSUtils){
                    fastDFSUtils = new FastDFSUtils();
                }
            }
        }
        return fastDFSUtils;
    }


}
