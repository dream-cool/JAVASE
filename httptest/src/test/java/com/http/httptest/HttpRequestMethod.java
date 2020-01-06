package com.http.httptest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.plugin2.os.windows.Windows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;



@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpRequestMethod {

    public static String sendPost(String url, String param) {
        StringBuilder result = new StringBuilder(70);
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接  耗时 50ms
            URLConnection connection = realUrl.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 获取URLConnection对象对应的输出流  耗时 200ms左右
            out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "gb2312"));
            out.print(param);
            out.flush();
            // 定义 BufferedReader输入流来读取URL的响应  耗时 200ms左右
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gb2312"));
            String line;
//            只需读取一行 即第一个div中的内容
            if ((line = in.readLine()) != null) {
                result.append(line);
            }
            System.out.println("发已送请求" + new SimpleDateFormat().format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
            sendPost(url,param);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }


    public static String sendGet(String url) {
        StringBuilder result = new StringBuilder(500);
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 获取所有响应头字段
//            Map<String, List<String>> map1 = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map1.keySet()) {
//                System.out.println(key + "--->" + map1.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gb2312"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            Thread.sleep(500);
//            System.out.println("发已送请求" + new SimpleDateFormat().format(new Date()));
        } catch (Exception e) {
              e.printStackTrace();
            sendGet(url);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    public static String getRandomIp(){
        //ip范围
        int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
                {1038614528,1039007743},//61.232.0.0-61.237.255.255
                {1783627776,1784676351},//106.80.0.0-106.95.255.255
                {2035023872,2035154943},//121.76.0.0-121.77.255.255
                {2078801920,2079064063},//123.232.0.0-123.235.255.255
                {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
                {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
                {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
                {-770113536,-768606209},//210.25.0.0-210.47.255.255
                {-569376768,-564133889}, //222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0]+new Random().nextInt(range[index][1]-range[index][0]));
        return ip;
    }

    public static String num2ip(int ip) {
        int [] b=new int[4] ;
        String x = "";

        b[0] = (int)((ip >> 24) & 0xff);
        b[1] = (int)((ip >> 16) & 0xff);
        b[2] = (int)((ip >> 8) & 0xff);
        b[3] = (int)(ip & 0xff);
        x=Integer.toString(b[0])+"."+Integer.toString(b[1])+"."+Integer.toString(b[2])+"."+Integer.toString(b[3]);

        return x;
    }



}
