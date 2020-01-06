package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:09 2019/7/18
 */
public class BufferTest {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        try {
            FileChannel channel = new FileOutputStream("data.txt").getChannel();
            channel.write(ByteBuffer.wrap("Some Text".getBytes()));
            channel.close();
            channel = new RandomAccessFile("data.txt", "rw").getChannel();
            channel.position(channel.size());
            channel.write(ByteBuffer.wrap("Some More".getBytes()));
            channel.close();
            channel = new FileInputStream("data.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            channel.read(buff);
            buff.flip();
            while (buff.hasRemaining()){
                System.out.print(((char) buff.get()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
