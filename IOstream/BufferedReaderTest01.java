package IOstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*
BufferedReader:
    带有缓冲区的字符输入流
    使用这个流的时候不需要自定义char数组，或者说不需要自定义byte数组。自带缓冲。
 */
public class BufferedReaderTest01 {
    public static void main(String[] args) {

        FileReader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader("D:\\java-project\\IOstream\\Copy02.java");

            // 当一个流的构造方法中需要一个流的时候，这个被传进来的流叫做：节点流。
            // 外部负责包装的这个流，叫做：包装流，还有一个名字叫作：处理流。
            // 像当前这个程序来说：FileReader就是一个节点流。BufferedReader就是包装流/处理流。
            br = new BufferedReader(reader);

            // 读一行
            /* String firstline = br.readLine();
            System.out.println(firstline);

            String secondline = br.readLine();
            System.out.println(secondline);

            String thirdline = br.readLine();
            System.out.println(thirdline);*/

            String s = null;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    // 关闭流
                    // 对于包装流来说，只需要关闭最外层流就行，里面的节点流会自动关闭。
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
