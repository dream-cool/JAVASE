package com.http.httptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.Proxy.Type;


/**
 * @author ：clt
 * @Date ：Created in 20:45 2019/10/13
 */
public class HttpAndHttpsProxy {

    /**
     * **/
    public static String HttpProxy(String url, String param, String proxy,
                                   int port) {
        HttpURLConnection httpConn = null;
        PrintWriter out = null;
        OutputStreamWriter out1 = null;
        BufferedReader in = null;
        String result = "";
        BufferedReader reader = null;
        try {
            URL urlClient = new URL(url);
            System.out.println("请求的URL========：" + urlClient);
            // 创建代理
            Proxy proxy1 = new Proxy(Type.HTTP, new InetSocketAddress(proxy,
                    port));
            // 设置代理
            httpConn = (HttpURLConnection) urlClient.openConnection(proxy1);
            // 设置通用的请求属性
            httpConn.setRequestProperty("accept", "*/*");
            httpConn.setRequestProperty("connection", "Keep-Alive");
            httpConn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            // 获取URLConnection对象对应的输出流


            //使请求报文不中文乱码
            out1 = new OutputStreamWriter(httpConn.getOutputStream(), "utf-8");

//            out1.write(param);

            // 发送请求参数
             out.print(param);
            // flush输出流的缓冲
            out1.flush();
            // 定义BufferedReader输入流来读取URL的响应
            // in = new BufferedReader(
            // new InputStreamReader(httpConn.getInputStream()));

            //使返回的报文不中文乱码
            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));

            String line;


            while ((line = in.readLine()) != null) {
                result += line;
            }
            // 断开连接
            httpConn.disconnect();
            System.out.println("====result====" + result);
            System.out.println("返回结果：" + httpConn.getResponseMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (out1 != null) {
                    out1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 示例
        HttpProxy("http:localhost:8080", "user=1213&pass=qq123456", "172.18.117.49", 22);
    }
}
