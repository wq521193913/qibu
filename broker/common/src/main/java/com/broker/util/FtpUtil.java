package com.broker.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanqing on 2016/10/21 0021.
 */
public class FtpUtil {

    private String host;
    private String port;
    private String userName;
    private String passWord;
    private String imgServerPath;
    private String imgLocalPath;
    private static FTPClient ftpClient = null;


    public FtpUtil(){
        this.host = PropertiesUtil.getProperties("ftpHost");
        this.port = PropertiesUtil.getProperties("ftpPort");
        this.userName = PropertiesUtil.getProperties("ftpUser");
        this.passWord = PropertiesUtil.getProperties("ftpPassWord");
        this.imgServerPath = PropertiesUtil.getProperties("imgServerPath");
    }

    private boolean connect(String host, String port, String userName, String passWord){
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(host);
            ftpClient.login(userName,passWord);
            int reply = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(reply)){
                ftpClient.disconnect();
            }
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.enterLocalPassiveMode();
//        ftpClient.enterLocalActiveMode();    //主动模式
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    public static String upload(File file) throws Exception{
        if(file.isDirectory()){
            ftpClient.makeDirectory(file.getName());
            ftpClient.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath()+"\\"+files[i] );
                if(file1.isDirectory()){
                    upload(file1);
                    ftpClient.changeToParentDirectory();
                }else{
                    File file2 = new File(file.getPath()+"\\"+files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftpClient.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        }else{
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftpClient.storeFile(file2.getName(), input);
            input.close();
        }
        return "";
    }

    /**
     * 上传图片
     * @param fileName
     * @param inputStream
     * @return
     * @author wanqing
     * @date 2016/10/24 0024 13:01
    */
    public static String uploadImg(String fileName,InputStream inputStream) throws Exception{
        FtpUtil ftpUtil = FtpUtil.initialize();
        String dirName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if(!ftpUtil.connect(ftpUtil.host,ftpUtil.port,ftpUtil.userName,ftpUtil.passWord)) throw new Exception("connect FTPServer failed");
        try {
            boolean ok = ftpClient.changeWorkingDirectory("/"+dirName);
//            if(!ok) throw new CustomException("无法切换ftp目录");
            if(!ok){
                ftpClient.makeDirectory(dirName);
                ftpClient.changeWorkingDirectory("/"+dirName);
            }
        }catch (FTPConnectionClosedException e){
            throw e;
        }
        String saveFileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
        if(StringUtils.isNotEmpty(fileName)){
            saveFileName = saveFileName + fileName.substring(fileName.lastIndexOf("."));
        }else {
            saveFileName = saveFileName+".png";
        }
        boolean store = ftpClient.storeFile(saveFileName,inputStream);
        inputStream.close();
        if(!store) throw new CustomException("无法上传文件");
        if(ftpClient.isConnected()){
            ftpClient.disconnect();
        }
        String path = dirName +"/" +saveFileName;
        return path;
    }
    /**
     * 同步材料图片
     * @param fileName
     * @param inputStream
     * @return
     * @author wanqing
     * @date 2016/10/24 0024 13:01
     */
    public static String uploadMaterialsImg(String fileName,InputStream inputStream) throws Exception{
        FtpUtil ftpUtil = FtpUtil.initialize();
        String dirName = "materialsImg/"+new SimpleDateFormat("yyyyMM").format(new Date());
        if(!ftpUtil.connect(ftpUtil.host,ftpUtil.port,ftpUtil.userName,ftpUtil.passWord)) throw new Exception("connect FTPServer failed");
        try {
            boolean ok = ftpClient.changeWorkingDirectory("/"+dirName);
            if(!ok){
                ftpClient.makeDirectory(dirName);
                ftpClient.changeWorkingDirectory("/"+dirName);
            }
        }catch (FTPConnectionClosedException e){
            throw e;
        }
        String saveFileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
        if(StringUtils.isNotEmpty(fileName)){
            saveFileName = saveFileName + fileName.substring(fileName.lastIndexOf("."));
        }else {
            saveFileName = saveFileName+".png";
        }
        boolean store = ftpClient.storeFile(saveFileName,inputStream);
        inputStream.close();
        if(!store) throw new CustomException("无法上传文件");
        if(ftpClient.isConnected()){
            ftpClient.disconnect();
        }
        String path = dirName +"/" +saveFileName;
        return path;

    }
    /**
     * 上传图片 权限图标
     * @param fileName
     * @param inputStream
     * @return
     * @author wanqing
     * @date 2016/10/24 0024 13:01
     */
    public static String uploadMenuImg(String fileName,InputStream inputStream) throws Exception{
        FtpUtil ftpUtil = FtpUtil.initialize();
        String dirName = "menuImg";
        if(!ftpUtil.connect(ftpUtil.host,ftpUtil.port,ftpUtil.userName,ftpUtil.passWord)) throw new Exception("connect FTPServer failed");
        try {
            if(!ftpClient.changeWorkingDirectory(dirName)){
                ftpClient.makeDirectory(dirName);
            }
        }catch (FTPConnectionClosedException e){
            ftpClient.makeDirectory(dirName);
        }

        ftpClient.changeWorkingDirectory(dirName);
        String saveFileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
        saveFileName = saveFileName + fileName.substring(fileName.lastIndexOf("."));
        ftpClient.storeFile(saveFileName,inputStream);
        if(ftpClient.isConnected()){
            ftpClient.disconnect();
        }
        String path = dirName +"/" +saveFileName;
        return path;
    }
    /**
     * 上传图片 材料
     * @param fileName
     * @param inputStream
     * @return
     * @author wanqing
     * @date 2016/10/24 0024 13:01
     */
    public static String uploadGoodsImg(String fileName,InputStream inputStream) throws Exception{
        FtpUtil ftpUtil = FtpUtil.initialize();
        String dirName = "goodsImg";
        if(!ftpUtil.connect(ftpUtil.host,ftpUtil.port,ftpUtil.userName,ftpUtil.passWord)) throw new Exception("connect FTPServer failed");
        try {
            if(!ftpClient.changeWorkingDirectory(dirName)){
                ftpClient.makeDirectory(dirName);
            }
        }catch (FTPConnectionClosedException e){
            ftpClient.makeDirectory(dirName);
        }

        ftpClient.changeWorkingDirectory(dirName);
        String saveFileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
        saveFileName = saveFileName + fileName.substring(fileName.lastIndexOf("."));
        ftpClient.storeFile(saveFileName,inputStream);
        if(ftpClient.isConnected()){
            ftpClient.disconnect();
        }
        String path = dirName +"/" +saveFileName;
        return path;
    }

    /**
     *http get获取图片流
     * @param url_path
     * @return
     */
    public static InputStream getInputStream(String url_path){
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(url_path);//创建的URL
            if (url!=null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();//打开链接
                httpURLConnection.setConnectTimeout(3000);//设置网络链接超时时间，3秒，链接失败后重新链接
                httpURLConnection.setDoInput(true);//打开输入流
                httpURLConnection.setRequestMethod("GET");//表示本次Http请求是GET方式
                int responseCode = httpURLConnection.getResponseCode();//获取返回码
                if (responseCode == 200) {//成功为200
                    //从服务器获得一个输入流
                    inputStream = httpURLConnection.getInputStream();
                }
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return inputStream;

    }

    public static FtpUtil initialize(){
        FtpUtil ftpUtil = new FtpUtil();
        return ftpUtil;
    }

    public static String getImgServerPath(){
        String imgServerPath = PropertiesUtil.getProperties("imgServerPath");
        return imgServerPath;
    }

    public static String getImgLocalPath(){
        String imgLocalPath = PropertiesUtil.getProperties("imgLocalPath");
        return imgLocalPath;
    }
}
