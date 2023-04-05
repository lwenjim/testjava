package com.example.www;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class MyX509TrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
        // TODO Auto-generated method stub

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        // TODO Auto-generated method stub
        return null;
    }

    // 处理http请求 requestUrl为请求地址 requestMethod请求方式，值为"GET"或"POST"
    public static String httpRequest(String requestUrl, String requestMethod,
                                     String outputStr) {

        StringBuffer buffer = null;
        try {
            URL url = new URL(requestUrl);// 请求地址
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();// 创建连接对象
            conn.setDoOutput(true);// 是否输出
            conn.setDoInput(true);// 是否输入
            conn.setRequestMethod(requestMethod);// post Or get
            conn.setRequestProperty("Charset", "utf-8");
            HttpURLConnection.setFollowRedirects(false);
            conn.setInstanceFollowRedirects(false);
            //cookie
            conn.setRequestProperty("cookie","cookie");

            conn.connect();// 发起连接
            // 往服务器端写内容 也就是发起http请求需要带的参数
            if (null != outputStr) {
                OutputStream os = conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            // 读取服务器端返回的内容
            // PrintWriter out = new PrintWriter(new
            // OutputStreamWriter(conn.getOutputStream(),"utf-8"));
            // out.println(obj);

            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /*
     * 处理https GET/POST请求 请求地址、请求方法、参数
     */
    public static String httpsRequest(String requestUrl, String requestMethod,
                                      String outputStr) {
        StringBuffer buffer = null;
        try {
            // 创建SSLContext
            SSLContext sslContext = SSLContext.getInstance("SSL");
            TrustManager[] tm = { new MyX509TrustManager() };
            // 初始化
            sslContext.init(null, tm, new java.security.SecureRandom());
            ;
            // 获取SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("Token", "sdBq40n6yaEObDwHI6tM5yt2GlTjbf8LFncpTgTk2n22lvUwHZ");
            // 设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            // 往服务器端写内容
            if (null != outputStr) {
                OutputStream os = conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }
            // 读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
//            InputStreamReader isr = new InputStreamReader(is, "gbk");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        //测试
        //https
        String testHttpsUrl = "https://sports.dawnbyte.com/soccer/api/team?time_stamp=" + (System.currentTimeMillis()/1000);
        String https = httpsRequest(testHttpsUrl, "GET", null);
        System.out.println(https);
        //http
        String testHttpUrl = "https://sports.dawnbyte.com";
        String http = httpRequest(testHttpUrl, "GET", null);
        System.out.println(http);
        JSONObject jsonObject = JSONObject.parseObject(http);
        String pageIndex = jsonObject.getString("pageIndex");
        JSONArray jsonArray = jsonObject.getJSONArray("postList");
        JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);
        String title = jsonObject1.getString("title");
        System.out.println(pageIndex);
        System.out.println(title);
    }
}