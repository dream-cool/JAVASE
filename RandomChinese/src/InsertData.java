import util.DataAccess;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:58 2019/6/22
 */
public class InsertData {
    public static void main(String[] args) {
        category.main(args);
        category();
    }
    public static void category() {
        Connection con = DataAccess.getConnection();
        File file = new File("C:/Users/Mrchen/Desktop/category1.txt");
        int count = 0;
        Reader reader = null;
        String sql = "";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            reader =new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=((BufferedReader) reader).readLine())!=null){
                pst = con.prepareStatement(line);
                pst.execute();
                count++;
                if ((count & 499) == 0){
                    System.out.println(count);
                }
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void product() {
        Connection con = DataAccess.getConnection();
        File file = new File("C:/Users/Mrchen/Desktop/product.txt");
        Reader reader = null;
        int count = 0;
        String sql = "";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            reader =new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=((BufferedReader) reader).readLine())!=null){
                count++;
                pst = con.prepareStatement(line);
                pst.execute();
                if ((count & 499) == 0){
                    System.out.println(count);
                }
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
