package com.example.wyyproject.util;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Http {
    //    原生获取json数据
    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    //    获取新闻json数据
    @NotNull
    public static String get(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
//
//    @NotNull
//    public static String get2() throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("http://10.0.2.2:3000/top/mv?limit=30")
//                .build();
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }

//   https://route.showapi.com/138-46?prov=%E5%8C%97%E4%BA%AC&showapi_appid=113669&showapi_timestamp=20191113155733&showapi_sign=54943f7e45836ca5a054675105d96e4e
//    http://apis.juhe.cn/simpleWeather/query?city=%E8%8B%8F%E5%B7%9E&key=4ae97f05f3c019e3af3d1b4289842b1e

    //    获取城市数据
    @NotNull
    public static String getCityWeather(String cityname) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://apis.juhe.cn/simpleWeather/query?city="+cityname+"&key=4ae97f05f3c019e3af3d1b4289842b1e")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    //    获取城市油价数据
    @NotNull
    public static String getOil(String cityname) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://route.showapi.com/138-46?prov="+cityname+"&showapi_appid=113669&showapi_timestamp=20191113155733&showapi_sign=4ebb6d06b2e348d19e77b6c44b5659eb")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    //    获取种类新闻
    @NotNull
    public static String getType(String type) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://v.juhe.cn/toutiao/index?type="+type+"&key=aeed60af1d88866d68868bb5c973a77b")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }



    public static OkHttpClient getInstance() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                //支持HTTPS请求，跳过证书验证
                .sslSocketFactory(getSSLSocketFactory(), (X509TrustManager) getTrustManager()[0])
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .build();
    }


    //获取这个SSLSocketFactory
    public static SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, getTrustManager(), new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //获取TrustManager
    public static TrustManager[] getTrustManager() {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                }
        };
        return trustAllCerts;
    }


    // 实现HostnameVerifier接口(信任所有的 https 证书)
    public static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
