- [反射机制](#反射机制)
  - [反射机制有什么用？](#反射机制有什么用)
  - [反射机制的相关类在哪个包下？](#反射机制的相关类在哪个包下)
  - [反射机制相关的重要的类有哪些？](#反射机制相关的重要的类有哪些)
  - [获取class的三种方式](#获取class的三种方式)
  - [通过反射实例化对象](#通过反射实例化对象)
  - [验证反射机制的灵活性](#验证反射机制的灵活性)
  - [Class.forName()发生了什么](#classforname发生了什么)
  - [类加载器](#类加载器)
    - [什么是类加载器？](#什么是类加载器)
    - [JDK中自带了3个类加载器](#jdk中自带了3个类加载器)
    - [探究String s = "abc";执行过程](#探究string-s--abc执行过程)

# 反射机制
## 反射机制有什么用？
- 通过java语言中的反射机制可以操作字节码文件。
- 有的类似于黑客。(可以读和修改字节码文件。)
- 通过反射机制可以操作代码片段。(class文件。)

## 反射机制的相关类在哪个包下？
- java.lang.reflect.*

## 反射机制相关的重要的类有哪些？
1. java.lang.Class:代表整个字节码，代表一个类型，代表整个类。
2. java.lang.reflect.Method:代表字节码中的方法字节码。代表类中的方法。
3. java.lang.reflect.Constructor:代表字节码中的构造方法字节码。代表类中的构造方法
4. java.lang.reflect.Field:代表字节码中的属性字节码。代表类中的成员变量(静态变量、实例变量)
<pre>
java.lang.Class:
    public class User{
        // Field
        int no;

        // Constructoe
        public User(){

        }
        public User(int no){
            this.no = no;
        }

        // Method
        public void setNo(int no){
            this.no = no;
        }
        public int getNo(){
            return no;
        }
    }
</pre>

## 获取class的三种方式
1. Class c = Class.forName("完整类名");
2. Class c = 对象.getClass();
3. Class c = int.class; Class c = String.class;

**详见ReflectTest01**

## 通过反射实例化对象
- 获取了Class之后，可以调用无参数构造方法来实例化对象
- Class c = Class.forName("java.util.Date");
- Object obj = c.newInstance();
- newInstance()底层调用的是该类型的无参数构造方法
- 如果没有这个无参数构造方法会出现异常。

**详见ReflectTest02以及User**

## 验证反射机制的灵活性
**详见ReflectTest03以及classinfo.properties**

## Class.forName()发生了什么
- 如果只想让一个类的“静态代码块”执行的话
- Class.forName("该类的类名");
- 这样类就加载，类加载的时候，静态代码块执行！

**详见ReflectTest04**

## 类加载器
### 什么是类加载器？
   - 专门负责加载类的命令/工具：ClassLoader

### JDK中自带了3个类加载器
   - 启动类加载器:rt.jar
   - 扩展类加载器:ext/*.jar
   - 应用类加载器:classpath

### 探究String s = "abc";执行过程
1. 代码在开始执行之前，会将所需要类全部加载到JVM当中
2. 通过类加载器加载，看到以上代码类加载器会找String.class文件，找到就加载
3. 如何进行加载的？
  - 首先通过“启动类加载器”加载。
    - rt.jar中都是JDK最核心的类库
  - 如果通过“启动类加载器”加载不到的时候，会通过“扩展类加载器”加载
    - 扩展类加载器专门加载ext下的类库
  - 如果“扩展类加载器”没有加载到，那么会通过“应用类加载器”加载
    - 应用类加载器专门加载：classpath中的类
4. java中为了保证类加载的安全，使用了双亲委派机制。优先从启动类加载器中加载，这个称为“父”。“父”无法加载到，再从扩展类加载器中加载，这个称为“母”。双亲委派。如果都加载不到，才会考虑从应用类加载器中加载。知道加载到为止。