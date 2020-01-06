package com.http.httptest;

/**
 * @author ：clt
 * @Date ：Created in 21:14 2019/10/10
 */
public class RemoteIndexRequestThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            String str = HttpRequestMethod.sendGet(constant.REMOTE_INDEX_URL);
        }
    }
}
