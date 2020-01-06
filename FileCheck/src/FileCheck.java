import java.io.*;

public class FileCheck {
    static long len;


    public static void fileCheck(File src){

        FileCheck.fileCount(src);

        if (len>1024*1024*3){
            if (src.isFile()){
                System.out.println(src.getAbsolutePath()+"->"+len/(1024*1024)+"M");
            }
        }
        len=0;
        if (src.listFiles()!=null){
            for (File s: src.listFiles()){
                fileCheck(s);
            }
        } else {
            return;
        }
    }

    public static void fileCount(File src){
        if (null!=src&&src.exists()&&!("".equals(src))){
            if (src.isFile()){
                len+=src.length();
            } else {
                for (File file : src.listFiles()){
                    fileCount(file);
                }
            }
        }
    }


    public static void flieLengthTest(String path){
        File file = new File(path);
        System.out.println(file.length());
    }



}
