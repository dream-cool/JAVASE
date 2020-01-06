package ording;

import util.DataAccess;
import util.RandomUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：clt
 * @Date ：Created in 20:21 2019/8/28
 */
public class InsertUserInfo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(500);
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 1; i++) {
            pool.execute(new insertThread(latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("##################"+(System.currentTimeMillis() - start));
    }
}

class insertThread implements Runnable{

    private CountDownLatch latch;

    public insertThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        String pre = "insert into ording.user (user_name,pass_word,tel,email,address,money,sex,state ,isVIP,role,reg_time, last_login_time ) values";
        String preData = null;
        StringBuilder sufData = null;
        int count = 0;
        Random random = new Random();
        Date createTime = null;
        Date updateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DataAccess.getConnection();
        StringBuilder sb = null;
        String[] roles = {"admin","employee","user"};
        for (int i = 0; i <= 10000; i++) {
            if (i % 1000 == 0){
                sb = new StringBuilder();
                sb.append(pre);
            }
            String userName = RandomUtil.getChineseFamilyName() + RandomUtil.getRandomName();
            String passWord = RandomUtil.getRandomTel();
            String tel = RandomUtil.getRandomTel();
            String address = RandomUtil.getRandomAddressCity();
            String money = "" + new Random().nextInt(1000);
            String sex = "" + (new Random().nextInt(2));
            String state = "" + (new Random().nextInt(2));
            String isVIP = "" + (new Random().nextInt(2));
            String email = RandomUtil.getRandomEmail();
            createTime = RandomUtil.getRandomDate("2013-5-6", "2019-3-4");
            updateTime = RandomUtil.getRandomDate(sdf.format(createTime), sdf.format(new Date()));
            String create = sdf.format(createTime);
            String update = sdf.format(updateTime);
            String role = roles[new Random().nextInt(3)];
            sb.append("('" + userName + "'," + passWord + "," + tel + ",'" + email + "','" + address + "'," + money + "," + sex + "," + state + "," + isVIP + ",'"+ role+"','" + create + "','" + update + "'),");
            count++;
            if (i  % 999 == 0 && i > 0){
                try {
                    sb.deleteCharAt(sb.length()-1);
//                    System.out.println(sb);
                    pst = con.prepareStatement(sb.toString());
                    pst.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        latch.countDown();
    }
}
