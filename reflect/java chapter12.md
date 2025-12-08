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
**详见ReflectTest01**

## 通过反射实例化对象
**详见ReflectTest02以及User**
