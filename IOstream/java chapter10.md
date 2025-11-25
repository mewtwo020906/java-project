# I/O流
## 什么是I/O
1. I：Input
2. O：Output
3. 通过IO可以完成硬盘文件的读和写

## I/O流的分类
1. 一种方式是按照流的方向进行分类：
   - 以内存作为参照物
     - 往内存中去，叫做输入(Input)。或者叫做读(Read)。
     - 从内存中出来，叫做输出(Output)。或者叫做写(Write)。
2. 另一种方式是按照读取数据方式不同进行分类：
   - 有的流是按照字节的方式读取数据，一次读取一个字节byte，等同于一次读取8个二进制。这种流是万能的，什么类型的文件都可以读取。包括：文本文件，图片，声音文件，视频文件等...
     - 假设文件file1.txt，采用字节流的话是这样读的：
       - a中国bc张三fe
       - 第一次读：一个字节，正好读到'a'
       - 第二次读：一个字节，正好读到'中'字符的一半
       - 第三次读：一个字节，正好读到'中'字符的另外一半
**char在java中是2个字节。**
   - 有的流是按照字符的方式读取数据的，一次读取一个字符，这种流是为了方便读取普通文本文件而存在的，这种流不能读取：图书、声音、视频等文件。只能读取纯文本文件，连word文件都无法读取。
     - 假设文件file1.txt，采用字符流的话是这样读的：
       - a中国bc张三fe
       - 第一次读：'a'字符('a'字符在windows系统中占用1个字节。)
       - 第二次读：'中'字符('中'字符在windows系统中占用2个字节。)
3. 综上所诉：流的分类
- 输入流、输出流
- 字节流、字符流

## java IO流这块有四大家族：
- 四大家族的首领：
  1. java.io.InputStream      字节输入流
  2. java.io.OutputStream     字节输出流
  3. java.io.Reader           字符输入流
  4. java.io.Writer           字符输出流
**四大家族的首领都是抽象类。(abstract class)**

- 所有的流都实现了：
  - java.io.Closeable接口，都是可关闭的，都有close()方法。
  - 流毕竟是一个管道，这个是内存和硬盘之间的通道，用完之后一定要关闭，
  - 不然会耗费(占用)很多资源。养成好习惯，用完流一定要关闭。
- 所有的输出流都实现了：
  - java.io.Flushable接口，都是可刷新的，都有flush()方法。
  - 输出流在最终输出之后，一定要记得flush()
  - 刷新以下，这个刷新表示将通道/管道当中剩余未输出的数据强行输出完(清空管道！)
  - 刷新的作用就是清空管道。
  - 如果没有flush()可能会导致丢失数据。

**注意：在java中只要“类名”以Stream结尾的都是字节流，以“Reader/Writer”结尾的都是字符流**

## java.io包下需要掌握的流有16个
1. 文件专属：
- java.io.FileInputStream
- java.io.FileOutputStream
- java.io.FileReader
- java.io.FileWriter
2. 转换流：(将字节流转换成字符流)
- java.io.InputStreamReader
- java.io.OutputStreamWriter
3. 缓冲流专属
- java.io.BufferedReader
- java.io.BufferedWriter
- java.io.BufferedInputStream
- java.io.BufferedOutputStream
4. 数据流专属
- java.io.DataInputStream
- java.io.DataOutputStream
5. 标准输出流
- java.io.PrintWriter
- java.io.PrintStream
6. 对象专属流
- java.io.ObjectInputStream
- java.io.ObjectOutputStream