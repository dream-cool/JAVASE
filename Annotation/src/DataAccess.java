
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DataAccess {
    public static void main(String[] args) {
        Data data=new Data();
        Connection con=data.getConnection();
    }

}
class Data{
    private static String driver="com.mysql.jdbc.Driver";//����һ������
    private static String url="jdbc:mysql://localhost:3306/course_design?useunicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
    //��Ҫ���ʵ����ݿ�����λ�ø�ʽ����Ϣ��������ı���url
    private static String user="root";//��mysql���ݿ����Ƹ���user
    private static String pwd="123616";//�����ݿ����븳������ı���pwd
    public static Connection getConnection() {//���徲̬���ݿ����ӷ���
        Connection con=null;//����con����
        try {
            Class.forName(driver);//ע����������
            con=DriverManager.getConnection(url,user,pwd);//���������ݿ���Ҫ����Ϣ��Ϊ��������÷��������������ݿ������
        }catch(Exception e) {
            e.printStackTrace();
        }
        return con;//���ڸþ�̬�������صĽ��Ϊcon����
    }
}
