# 常用类
## 关于java JDK中内置的一个类：java.lang.String
### String字符串的存储原理
1. String表示字符串类型，属于引用数据类型，不属于基本数据类型。
2. 在java中随便使用双引号括起来的都是String对象。例如："abc","def","hello world"这是3个String对象。
3. java规定，双引号括起来的字符串，是不可变的，也就是说"abc"自出生到最终死亡，不可变，不能变成"abcd"
4. 在JDK当中双引号括起来的字符串，例如："abc"、"def"都是直接存储在"方法区"的"字符串常量池"当中的。为什么SUN公司把字符串存储在一个"字符串常量池"当中呢。因为字符串在实际开发中使用太频繁。为了执行效率，所以把字符串放到了方法区的字符串常量池当中。
5. 凡是双引号括起来的都在字符串常量池中有一份，new对象的时候一定在堆内存当中开辟空间。
6. String s = new String("xy");字符串常量池和堆内存均开辟了空间。
<pre>
public class StringTest02{
    public static void main(String[] args){
        String s1 = "hello";
        // "hello"是存储在方法区的字符串常量池当中
        // 所以这个"hello"不会新建。(因为这个对象已经存在了)
        String s2 = "hello";
        // 分析结果是true还是false？
        // == 双等号比较的是变量中保存的内存地址
        System.out.println(s1 == s2); //true

        String x = new String("xyz");
        String y = new String("xyz");
        // 分析结果是true还是false？
        System.out.println(x == y); //false

        // 字符串对象之间的比较不能使用"=="
        // "=="不保险。应该调用String类的equals方法。
        // String类已经重写了equals方法，以下的equals方法调用的是String重写之后的equals方法。
        System.out.println(x.equals(y)); //true

        String k = new String("testString");
        // "testString"是一个String字符串对象，只要是对象都能调用方法。

        System.out.println("testString".equals(k));
        // 建议使用这种方式，因为这个可以避免空指针异常。

        System.out.println(k.equals("testString"));
        // 存在空指针异常的风险，不建议这样写。

    }
}
</pre>
### 面试题：以下程序一共创建了几个对象
<pre>
public class StringTest{
    String s1 = new String("hello");
    String s2 = new String("hello");
    // 一共三个对象：
    // 方法区字符串常量池有1个："hello"
    // 堆内存当中有两个String对象
}
</pre>
### String类的构造方法

<pre>
    // 创建字符串对象最常用的一种方式
    String s1 = "hello world!";
    // s1这个变量中保存的是一个内存地址。
    System.out.println(s1); // hello world!
    // 按说应该输出一个地址，实际上输出一个字符串，说明String类已经重写了toString()方法。
    System.out.println(s1.toString());

    // 常用的构造方法
    byte[] bytes = {97, 98 ,99};// 97是a，98是b，99是c
    String s2 = new String(bytes);

    // 输出一个引用的时候，会自动调用toString()方法，默认Object的话，会自动输出对象的内存地址
    // 通过输出结果得出结论：String类已经重写了toString()方法。
    // 输出字符串对象的话，输出的不是对象的内存地址，而是字符串本身。
    System.out.println(s2.toString()); // abc
    System.out.println(s2); // abc

    // String(字节数组，数组元素下标的起始位置，长度)
    // 将byte数组中的一部分转换成字符串。
    String s3 = new String(bytes, 1, 2);
    System.out.println(s3); // bc

    // 将char数组全部转换成字符串
    char[] chars = {'a','b','c','d','e'};
    String s4 = new String(chars);
    System.out.println(s4);
    // 将char数组的一部分转换成字符串
    String s5 = new String(chars, 2, 3);
    System.out.println(s5); 
</pre>
<pre>
第一个：String s = new String("");
第二个：String s = "";  最常用
第三个：String s = new String(char数组);
第四个：String s = new String(char数组，起始下标，长度);
第五个：String s = new String(byte数组);
第六个：String s = new String(byte数组，起始下标，长度);
</pre>
### String类的常用方法
<pre>
    // 1. (掌握) char charAt(int index)
    char c = "中国人".charAt(1);    
    System.out.println(c);  // 国

    // 2. (了解) int compareTo(String anotherString)
    // 字符串之间比较大小不能直接使用> <,需要使用compareTo方法。
    int result = "abc".compareTo("abc");
    System.out.println(result); //0(等于0)  10 - 10 =0

    int result2 = "abcd".compareTo("abc3");
    System.out.println(result2); //-1(小于0)    8 - 9 = -1

    int result3 = "abce".compareTo("abcd");
    System.out.println(result3); //1(大于0)  9 - 8 = 1

    // 拿着字符串第一个字母和后面字符串的第一个字母比较。能分胜负就不再比较了。
    System.out.println("xyz".compareTo("yxz")); // -1

    // 3.(掌握)boolean contains(CharSequence s)
    // 判断前面的字符串中是否包含后面的子字符串。
    System.out.println("HelloWorld.java".contains(".java"));    //true
    System.out.println("http://www.baidu.com".contains("https://"));    //false

    // 4.(掌握)boolean endsWith(String suffix)
    // 判断当前字符串是否以某个字符串结尾。
    System.out.println("test.txt".endsWith(".java"));   //false
    System.out.println("test.txt".endsWith(".txt"));    //true
    
    // 5.(掌握)boolean equals(Object anObject)
    // 比较两个字符串必须使用equals方法，不能使用"=="
    // equals只能看出相等不相等，compareTo方法可以看出是否相等，并且同时还可以看出谁大谁小

    // 6.(掌握)boolean equalsIgnoreCase(String anotherString)
    // 判断两个字符串是否相等，并且同时忽略大小写。
    System.out.println("ABc".equalsIgnoreCase("abC"));

    // 7.(掌握)byte[] getBytes()
    // 将字符串对象转换成字节数组
    byte[] bytes = "abcdef".getBytes();
    for(int i = 0; i < bytes.length; i++){
        System.out.println(bytes[i]);       //97    98  99  100 101 102
    }

    // 8.(掌握)int indexOf(String str)
    // 判断某个子字符串在当前字符串中第一次出现处的索引(下标)
    System.out.println("oraclejavac++".indexOf("java"));    //6

    // 9.(掌握)boolean isEmpty()
    // 判断某个字符串是否为"空字符串"。底层源代码调用的应该是字符串的length()方法。
    // String s = ""; //true
    
    // 10.(掌握)int length()
    // 面试题：判断数组长度和判断字符串长度不一样
    // 判断数组长度是length属性，判断字符串长度是length()方法。
    System.out.println("abc".length()); //3

    // 11.(掌握)int lastIndexOf(String str)
    // 判断某个子字符串在当前字符串中最后一次出现的索引(下标)
    System.out.println("oraclejavac++javac#phpjavapython".lastIndexOf("java"));
    //结果是22

    // 12.(掌握)String replace(CharSequence target, CharSequence replacement)
    // String的父接口就是：CharSequence
    String newString = "http://www.baidu.com".replace("http://","https://");
    System.out.println(newString);

    // 13.(掌握)String[] split(String regex)
    // 拆分字符串
    String[] ymd = "1980-10-11".split("-"); //"1980-10-11"以"-"分隔符进行拆分
    for(int i = 0; i < ymd.length; i++){
        System.out.println(ymd[i]);
    }

    // 14.(掌握)boolean startswith(String prefix)
    // 判断某个字符串是否以某个字符串开始。
    System.out.println("http://www.baidu.com".startsWith("http")); // true
    System.out.println("http://www.baidu.com".startsWith("https")); // false

    // 15.(掌握)String substring(int beginIndex) 参数是起始下标。
    // 截取字符串
    System.out.println("http://www.baidu.com".substring(7)); // www.baidu.com

    // 16.(掌握)String substring(int beginIndex, int endIndex)   左闭右开
    // beginIndex起始位置(包括)
    // endIndex结束位置(不包括)
    System.out.println("http://www.baidu.com".substring(7,10)); // www

    // 17.(掌握)char[] toCharArray()
    // 将字符串转换成char数组
    char[] chars = "我是中国人".toCharArray();
    for(int i = 0; i < chars.length; i++){
        System.out.println(chars[i]); 
    }

    // 18.(掌握)String toLowerCase()
    // 转换为小写
    System.out.println("ABCDefKXyz".toLowerCase());

    // 19.(掌握)String toUpperCase()
    // 转换为大写
    System.out.println("ABCDefKXyz".toUpperCase());

    // 20.(掌握)String trim()
    // 去除字符串前后空白
    System.out.println("      hello     world     ".trim());//结果:hello     world

    // 21.(掌握)String中只有一个方法是静态的，不需要new对象
    // 这个方法叫做valueOf
    // 作用：将"非字符串"转换成"字符串"
    String s1 = String.valueOf(true);

    // 这个静态的valueOf()方法，参数是一个对象的时候，会自动调用该对象的toString()方法吗？
    String s1 = String.valueOf(new Customer());
    System.out.println(s1); //没有重写toString()方法之前是对象内存地址

    // 研究一下println()方法的源代码
    // 通过源代码可以看出：为什么输出一个引用的时候，会调用toString()方法
    // 本质上System.out.println()这个方法在输出任何数据的时候都是先转换成字符串，再输出。

</pre>
### StringBuffer与StringBuilder
- 我们在实际开发中，如果需要进行字符串的频繁拼接，会有什么问题？
  - 因为java中的字符串是不可变的，每一次拼接都会产生新字符串。
  - 这样会占用大量的方法区内存，造成内存空间的浪费。
<pre>
    String s = "abc";
    s += "hello";
    // 以上两行代码，导致在方法区字符串常量池当中创建了3个对象：
    // "abc"    "hello"     "abchello"
</pre>
1. StringBuffer底层实际上是一个byte[]数组。
2. 往StringBuffer中放字符串，实际上是放到byte数组当中了。
3. StringBuffer的初始化容量是16.
4. 以后需要进行大量字符串的拼接操作，建议使用JDK中自带的：
   - java.lang.StringBuffer
   - java.lang.StringBuilder
5. 如何优化StringBuffer的性能？
   - 在创建StringBuffer的时候尽可能给定一个初始化容量。
   - 最好减少底层数组的扩容次数。预估计一下，给一个大一些初始化容量。
   - 关键点：给一个合适的初始化容量。可以提高程序的执行效率。
<pre>
        // 创建一个初始化容量为16个byte[]数组。(字符串缓冲区对象)
        StringBuffer stringBuffer = new StringBuffer();

        // 拼接字符串，以后拼接字符串统一调用append()方法。
        // append是追加的意思。
        stringBuffer.append("hello");
        stringBuffer.append("world");
        stringBuffer.append(100L);
        // append方法底层在进行追加的时候，如果byte数组满了，会自动扩容。
        System.out.println(stringBuffer);

        // 指定初始化容量的StringBuffer对象(字符串缓冲区对象)
        StringBuffer stringBuffer1 = new StringBuffer(100);
</pre>
**以上步骤使用StringBuilder也是可以完成字符串的拼接**
- StringBuffer和StringBuilder的区别？
  - StringBuffer中的方法都有：synchronized关键字修饰。表示StringBuffer在多线程环境下运行是安全的。
  - StringBuffer中的方法都没有：synchronized关键字修饰。表示StringBuilder在多线程环境下运行是不安全的。
  - StringBuffer是线程安全的。
  - StringBuilder是非线程安全的。
### 需要关注的点
1. 面试题：String为什么是不可变？
<pre>
源代码中，String类中有一个byte[]数组，这个byte[]数组采用了final修饰，因为数组一旦创建长度不可变。并且被final修饰的引用一旦指向某个对象之后，不可再指向其它对象，所以String是不可变的！
    "abc"无法变成"abcd"
</pre>
2. StringBuilder/StringBuffer为什么是可变的呢？
<pre>
源代码中，StringBuffer/StringBuilder内部实际上是一个byte[]数组，这个byte[]数组没有被final修饰，StringBuffer/StringBuilder的初始化容量应该是16，当存满之后会进行扩容，底层调用了数组拷贝的方法System.arraycopy()...是这样扩容的。所以StringBuffer/StringBuilder适合于使用字符串的频繁拼接操作。
</pre>
3. 字符串不可变是什么意思？
- 是说双引号里面的字符串对象一旦创建不可变。

## 包装类
### 装箱与拆箱
1. java中为8种基本数据类型又对应准备了8种包装类型。8种包装类属于引用数据类型，
2. 思考：为什么要再提供8种包装类呢？
   - 因为8种基本数据类型不够用，所以SUN又提供对应的8种包装类型。
   - 8种基本数据类型对应的8种包装类，SUN公司已经写好了，我们直接用。
<pre>
    基本数据类型                包装类型
    ------------------------------------------------
    byte                    java.lang.Byte(父类Number)
    short                   java.lang.Short(父类Number)
    int                     java.lang.Integer(父类Number)
    long                    java.lang.Long(父类Number)
    float                   java.lang.Float(父类Number)
    double                  java.lang.Double(父类Number)
    boolean                 java.lang.Boolean(父类Object)
    char                    java.lang.Character(父类Object)

</pre>
3. 八种包装类中其中6个都是数字对应的包装类，他们的父类都是Number，可以先研究一下Number中公共方法
   - Number是一个抽象类，无法实例化对象。
   - Number类中有这样的方法:
     - byte byteValue() 以 byte 形式返回指定的数值。
     - abstract double doubleValue() 以 double 形式返回指定的数值。
     - abstract float floatValue() 以 float 形式返回指定的数值。
     - abstract int intValue() 以 int 形式返回指定的数值。
     - abstract long longValue() 以 long 形式返回指定的数值。
     - short shortValue() 以 short 形式返回指定的数值。
   - 这些方法其实所有的数字包装类的子类都有，这些方法是负责拆箱的。
<pre>
        // 123这个基本数据类型，进行构造方法的包装达到了：基本数据类型向引用数据类型的转换。
        // 基本数据类型 --(转换为)--> 引用数据类型(装箱)
        Integer i = new Integer(123);

        // 将引用数据类型--(转换为)--> 基本数据类型
        float f = i.floatValue();
        System.out.println(f); // 123.0

        // 将引用数据类型--(转换为)--> 基本数据类型(拆箱)
        int retValue = i.intValue();
        System.out.println(retValue); // 123
</pre>
### Integer类的构造方法
1. Integer(int)
2. Integer(String)
<pre>
        // 将数字100转换成Integer包装类型(int --> Integer)
        Integer x = new Integer(100);
        System.out.println(x);

        // 将String类型的数字，转换成Integer包装类型(String --> Integer)
        Integer y = new Integer("123");
        System.out.println(y);

        // double --> Double
        Double d = new Double("123");
        System.out.println(d);

        //String --> Double
        Double d2 = new Double("123");
        System.out.println(d2);
</pre>
### 获取最大值和最小值
<pre>
        // 通过访问包装类的常量，来获取最大值和最小值
        System.out.println("int的最大值：" + Integer.MAX_VALUE);
        System.out.println("int的最大值：" + Integer.MIN_VALUE);
        System.out.println("byte的最大值：" + Byte.MAX_VALUE);
        System.out.println("byte的最大值：" + Byte.MAX_VALUE);
</pre>

### 自动装箱和自动拆箱
1. 自动装箱：基本数据类型自动转换成包装类。
2. 自动拆箱：包装类自动转换成基本数据类型。
3. 有了自动拆箱之后，Number类中的方法就用不着了。
4. 自动装箱和自动拆箱的好处：方便编程。
<pre>
        // 900是基本数据类型
        // x是包装类型
        // 基本数据类型 --(自动转换)--> 包装类型:自动装箱
        Integer x = 900;
        System.out.println(x);

        // x是包装类型
        // y是基本数据类型
        // 包装类型 --(自动转换)--> 基本数据类型:自动拆箱
        int y = x;
        System.out.println(y);

        // z是一个引用，z是一个变量，z还是保存了一个对象的内存地址。
        Integer z = 1000;
        // 没有报错
        // +两边要求是基本数据类型的数字，z是包装类，不属于基本数据类型。这里会进行自动拆箱。将z转换成基本数据类型
        System.out.println(z + 1);

        Integer a = 1000; // Integer a = new Integer(1000); a是个引用，保存内存地址指向对象
        Integer b = 1000; // Integer b = new Integer(1000); b是个引用，保存内存地址指向对象
        // == 比较的是对象的内存地址，a和b两个引用中保存的对象内存地址不同。
        // == 这个运算符不会触发自动拆箱机制。(只有+ - * /等运算的时候才会)
        System.out.println(a == b);
</pre>
**面试题**
<pre>
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b); //false

        /*
        java中为了提高程序的执行效率，将[-128到127]之间所有的包装对象提前创建好，
        放到了一个方法区的"整数型常量池"当中了，目的是只要用这个区间的数据不需要再
        new了。直接从整数型常量池当中取出来。

        原理：x变量中保存的对象的内存地址和y变量中保存的对象的内存地址是一样的。
         */
        
        Integer c = 127;
        Integer d = 127;
        // == 永远判断的都是两个对象的内存地址是否相同。
        System.out.println(c == d); //true
</pre>

### Integer常用方法
<pre>
        // 1.intValue:以 int 类型返回该 Integer 的值
        // 手动装箱
        Integer x = new Integer(1000);

        // 手动拆箱
        int y = x.intValue();
        System.out.println(y);

        Integer a = new Integer("123");

        // 编译的时候没问题，一切符合java语法，运行时会不会出问题？
        // 不是一个"数字"可以包装成Integer吗？不能。运行时出现异常。
        // java.lang.NumberFormatException
        // Integer a = new Integer("中文");

        // 重点方法：2.parseInt：将字符串参数作为有符号的十进制整数进行解析
        // static int parseInt(String s)
        // 静态方法，传参String，返回int
        // 网页上文本框中输入的100实际上是“100”字符串。
        // 后台数据库中要求存储100数字，此时java程序需要将"100"转换成100数字
        int reValue = Integer.parseInt("123"); // String --转换-->int
        System.out.println(retValue + 100);
        
        // 同理
        double retValue2 = Double.parseDouble("3.14");
        System.out.println(retValue2 + 1); // 4.140000000000001(精度问题)

        float retValue3 = Float.parseFloat("1.0");
        System.out.println(retValue3 + 1); // 2.0

        //-------------了解以下内容-----------------
        // static String toBinaryString(int i)
        // 静态的：将十进制转换成二进制字符串。
        String binaryString = Integer.toBinaryString(3);
        System.out.println(binaryString); // "11" 二进制字符串

        // static String toHexString(int i )
        // 静态的：将十进制转换成十六进制字符串。
        String hexString = Integer.toHexString(16);
        System.out.println(hexString); // "10"

        hexString = Integer.toHexString(17);
        System.out.println(hexString); // "11"

        // static String toOctalString(int i)
        // 静态的:将十进制转换成八进制字符串。
        String octalString = Integer.toOctalString(8);
        System.out.println(octalString); // "10"

        System.out.println(new Object()); //默认调用的toString方法用的是toHexString()

        // valueOf方法作为了解
        // static Integer valueOf(int i)
        // 静态的：int -->Integer
        Integer i1 = Integer.valueOf(100);
        System.out.println(i1);

        // static Integer valueOf(String s)
        // 静态的：String-->Integer
        Integer i2 = Integer.valueOf("100");
        System.out.println(i2);

</pre>

### 总结学过的几个经典异常
1. 空指针异常：NullPointerException
2. 类型转换异常：ClassCastException
3. 数组下标越界异常：ArrayIndexOfBoundsException
4. 数字格式化异常：NumberFormatException

### String int Integer之间互相转换
<pre>
        //String --> int
        String s1 = "100";
        int i1 = Integer.parseInt(s1);
        System.out.println(i1 + 1); // 101

        // int --> String
        String s2 = i1 + "";
        System.out.println(s2 + 1); // 1001

        // int --> Integer
        // 自动装箱
        Integer x = 1000;

        // Integer --> int
        // 自动拆箱
        int y = x;

        // String --> Integer
        Integer k = Integer.valueOf("123");

        // Integer --> String
        String e = String.valueOf(y);
</pre>

## java对日期的处理

1. 怎么获取系统当前时间
2. String ---> Date
3. Date ---> String
<pre>
// 获取系统当前时间(精确到毫秒的系统当前时间)
        // 直接调用无参构造方法就行
        Date nowTime = new Date();

        // java.util.Date类的toString()方法已经被重写了。
        // 输出的应该不是一个对象的内存地址，应该是一个日期字符串。
        System.out.println(nowTime); // Tue Nov 11 11:38:23 CST 2025

        // 日期可以格式化吗？
        // 将日期类型Date，按照指定的格式进行转换：Date --转换成具有一定格式的日期字符串-->String
        // SimpleDateFormat是java.text包下的。专门负责日期格式化的。
        /*
        yyyy 年
        MM 月
        dd 日
        HH 时
        mm 分
        ss 秒
        SSS 毫秒
        注意：在日期格式中，除了y M d H m s S这些字符不能随便写之外，剩下的符号格式自己随意组织
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTimeStr = sdf.format(nowTime);
        System.out.println(nowTimeStr);

        // 假设现在有一个日期字符串String，怎么转换成Date类型？
        // String --> Date
        String time = "2008-08-08 08:08:08 888";
        // SimpleDateFormat sdf2 = new SimpleDateFormat("格式不能随便写，要和日期字符串格式相同");
        // 注意：字符串的日期格式和SimpleDateFormat对象指定的日期格式要一致。不然会出现异常：java.text.ParseException
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date dateTime = sdf2.parse(time);
        System.out.println(dateTime); // Fri Aug 08 08:08:08 CST 2008
</pre>

- 统计一个方法耗费时间

<pre>
        // 获取自1970年1月1日 00:00:00 000到当前系统时间的总毫秒数。
        long nowTimeMillis = System.currentTimeMillis();
        System.out.println("nowTimeMillis=" + nowTimeMillis);

        // 统计一个方法耗时
        // 在调用目标方法之前记录一个毫秒数
        long begin = System.currentTimeMillis();
        print();
        // 在执行完目标方法之后记录一个毫秒数
        long end = System.currentTimeMillis();
        System.out.println("耗费时长" + (end - begin) + "毫秒");

    }

    // 需求：统计一个方法执行所耗费的时长
    public static void print() {
        for (int i = 0; i < 10;i++) {
            System.out.println("i = " + i);
        }
    }
</pre>

## 简单总结以下System类的相关属性和方法
1. System.out   [out是System类的静态变量。]
2. System.out.println() [println()方法不是System类的，是PrintStream类的方法]
3. System.gc()  建议启动垃圾回收器
4. System.currentTimeMillis()   获取自1970年1月1日到系统当前时间的总毫秒数。
5. System.exit(0) 退出JVM。