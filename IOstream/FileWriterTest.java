package IOstream;

import java.io.FileWriter;
import java.io.IOException;

/*
FileWriter：
    文件字符输出流，写
    只能输出普通文本
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter out = null;
        try {
            out = new FileWriter("file");

            // 开始写。
            char[] chars = {'阿','莫','西','多','多','哈','一','粒'};
            out.write(chars);
            out.write(chars,5,3);

            out.write("你干嘛哈哈哟");
            // 写出一个换行符。
            out.write("\n");
            out.write("amagi");
            // 刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
