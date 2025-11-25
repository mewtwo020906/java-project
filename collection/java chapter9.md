# 集合
## 泛型
1. jdk5.0之后推出的新特性：泛型
2. 泛型这种语法机制，只在程序编译阶段起作用，只是给编译器参考的。(运行阶段泛型没用)
3. 使用了泛型好处是什么？
   - 第一：集合中存储的元素类型统一了。
   - 第二：从集合中取出的元素类型是泛型指定的类型，不需要进行大量的“向下转型”！
4. 泛型的缺点是什么？
   - 导致集合中存储的元素缺乏多样性！
   - 大多数业务中，集合中元素的类型还是统一的。所以这种泛型特性被大家所认可。
**详细请见GenericTest01**

### 自动类型推断机制
1. jdk8.0之后引入了：自动类型推断机制。(又称为钻石表达式)
**详细请见GenericTest02**

### 自定义泛型
**详细请见GenericTest03**

## foreach
<pre>
   // 数组使用foreach

   // int类型数组
   int[] arr = {132,365,1234,567,678,12};

   // 遍历数组(普遍for循环)
   for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
   }

   // 增强for(foreach)
   // 以下是语法
   /* for(元素类型 变量名 : 数组或集合){
      System.out.println(变量名);
   }
   */

   System.out.println("-------------------");
   // foreach有一个缺点：没有下标。在需要使用下标的循环中，不建议使用增强for循环
   for(int data : arr){
      // data就是数组中的元素(数组中的每一个元素。)
      System.out.println(data);
   }
</pre>
<pre>
   // 创建List集合
   List<String> strList = new ArrayList<>();

   // 添加元素
   strList.add("hello");
   strList.add("world!");
   strList.add("kitty!");

   // 遍历，使用迭代器方式
   Iterator<String> it = strList.iteratoe();
   while(it.hasNext()){
      String s = it.next();
      Sytem.out.println(s);
   }

   // 使用下标方式(只针对有下标的集合)
   for(int i = 0; i < strList.size(); i++){
      System.out.println(strList.get(i));
   }

   // 使用foreach
   for(String s: strList){ //因为泛型使用的是String类型，所以是：String s;
      System.out.println(s);
   }

   List<Integer> list = new ArrayList<>();
   list.add(100);
   list.add(200);
   list.add(300);
   for(Integer i :list){ // i代表集合中的元素
      System.out.println(i);
   }
</pre>
