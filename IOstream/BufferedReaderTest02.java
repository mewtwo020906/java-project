package IOstream;

import java.io.*;

/*
    转换流：InputStreamReader
 */
public class BufferedReaderTest02 {
    public static void main(String[] args){
        // 先初始化，防止是局部变量
        FileInputStream in = null;
        BufferedReader br = null;

        try {
            /* // 字节流
            in = new FileInputStream("D:\\java-project\\IOstream\\Copy02.java");

            // 通过转换流转换(InputStreamReader将字节流转换成字符流。)
            // in是节点流。reader是包装流
            InputStreamReader reader = new InputStreamReader(in);

            // 这个构造方法只能传一个字符流。不能传字节流。
            // reader是节点流。br是包装流。
            br = new BufferedReader(reader); */

            // 合并
            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\java-project\\IOstream\\Copy02.java")));

            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
