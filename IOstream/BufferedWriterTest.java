package IOstream;

import java.io.*;

/*
BufferedWriter：带有缓冲的字符输出流。
OutputStreamWriter：转换流
 */
public class BufferedWriterTest {
    public static void main(String[] args) {

        BufferedWriter out = null;
        try {
            // 带有缓冲区的字符输出流
            // out = new BufferedWriter(new FileWriter("copy"));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy")));
            // 开始写
            out.write("你干嘛哈哈哟");
            out.write("\n");
            out.write("哦呀啊哈哈amagi");
            // 刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                // 关闭最外层
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
