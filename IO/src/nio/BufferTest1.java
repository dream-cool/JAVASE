package nio;


import java.nio.ByteBuffer;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:44 2019/7/18
 */
public class BufferTest1 {
    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(1024);
        buff.limit(100);
        System.out.println(buff.position()+"--"+buff.limit()+"--"+buff.capacity());
        buff.put("hello world".getBytes());
        System.out.println(buff.position()+"--"+buff.limit()+"--"+buff.capacity());
        buff.flip();
        byte[] bytes = new byte[1024];
        buff.get(bytes,0,buff.limit());
        System.out.println(new String(bytes));
    }
}
