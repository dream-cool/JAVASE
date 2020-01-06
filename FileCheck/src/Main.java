import java.io.File;

public class Main {

    public static void main(String[] args) {
//        FileCheck.fileCheck("C:/Users/Mrchen/Desktop/文档");
        File file = new File("F:\\文档\\数据挖掘实训");
//        int index=0;
//        for (File f:file.listFiles()){
//            System.out.println(index++);
//            FileCheck.fileCheck(f);
//        }
//        System.out.println(file.listFiles().length);
        FileCheck.fileCheck(file);

//        FileCheck.fileCount(file);
//        System.out.println(FileCheck.len);
    }
}
