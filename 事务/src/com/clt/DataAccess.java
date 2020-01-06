package com.clt;
import java.sql.Connection;
import java.sql.DriverManager;



public class DataAccess {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/course_design?useunicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";

    private static String user="root";
    private static String pwd="123616";
    public static Connection getConnection() {
        Connection con=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,pwd);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
