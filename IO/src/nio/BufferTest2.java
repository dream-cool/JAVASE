package nio;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:44 2019/7/18
 */
public class BufferTest2 {
    public static void main(String[] args) throws IOException {
        ByteBuffer buff = ByteBuffer.allocate(1024);
        buff.limit(100);
        FileChannel channel = new FileInputStream("b.txt").getChannel();
        channel.read(buff);
        buff.flip();
        byte[] bytes = new byte[1024];
        buff.get(bytes,0,buff.limit());
        System.out.println(new String(bytes));
    }
}
