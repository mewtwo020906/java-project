package IOstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest05 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("tempfile");
            System.out.println("总字节数量：" + fis.available());
            // 读1个字节
            // int readByte = fis.read();
            // 还剩下可以读的字节数量是：5
            // System.out.println("剩下多少个字节没有读：" + fis.available());
            // 这个方法有什么用？
            byte[] bytes = new byte[fis.available()]; // 这种方式不太适合太大的文件，因为byte[]数组不能太大。
            // 不需要循环了
            // 直接读一次就行了。
            int readCount = fis.read(bytes); // 6
            System.out.println(new String(bytes)); // abcdef

            // skip跳过几个字节不读取，这个方法也可能以后会用
            fis = new FileInputStream("IOstream/tempfile");
            fis.skip(3);
            System.out.println(fis.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
