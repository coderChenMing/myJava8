# java8使用
## lambda表达式
### 无参数表达式
### 一个参数表达式
### 多个参数表达式
### 函数式接口
### java8 定义接口使用
* Consumer 有参数无返回值
* Supplier 无参数有返回值
* Function 有参数有返回值
* Predicate 有参数,返回boolean
## 方法引用
如果lambda中的内容有方法已经实现了,则可以使用方法引用
是lambda表达式的另外一中表达形式

### 三种形式
对象::实例方法名

注意:接口的方法签名(参数列表,返回值,方法名)中的参数列表和返回值 要与实例方法的参数列表和返回值保持一致才可以

    Supplier<Integer> supplier2=emp::getAge;
    System.out.println(supplier2.get());
    
类::静态方法名

注意:接口的方法签名(参数列表,返回值,方法名)中的参数列表和返回值 要与静态方法的参数列表和返回值保持一致才可以

     Comparator<Integer> comparator1 = Integer::compare;
     System.out.println(comparator1.compare(200,100));


类::实例方法名
    
注意:接口方法的第一个参数和调用实例方法的对象类型要一致,接口方法的第二个参数要和被调用的实例方法的参数保持一致

     BiPredicate<String, String> biPredicate1 = String::equals;
     System.out.println(biPredicate1.test("zhangsan", "lisi"));

## 构造器引用

注意：需要调用的构造器的参数列表与函数式接口的参数列表保持一致

格式: ClassName::new

    BiFunction<String,Integer,Employee> biFunction=Employee::new;
    System.out.println(biFunction.apply("张三",59));

## 数组引用

    Function<Integer, String[]> function1 = String[]::new;
    System.out.println(function1.apply(10).length);

## 强大的Stream

集合讲的是数据,流讲的是计算

注意:
* Stream不会存储元素
* Stream不会改变原数据。会返回一个持有结果的新Stream
* Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行

stream操作步骤
* 创建Stream 

    从一个数据源(集合,数组)获取一个流
    
    
    // 使用Collection实现类创建Stream
    List<String> list = new ArrayList<>();
    Stream<String> stream = list.stream();
    // 使用Arrays.stream()
    int[] intArray = new int[10];
    IntStream stream1 = Arrays.stream(intArray);
    // 使用Stream的静态方法
    Stream<String> stringStream = Stream.of("aa", "bb", "cc");
    // 创建无限流
    Stream<Integer> iterate = Stream.iterate(0, s -> s + 2);
    iterate.forEach(System.out::println);
    
* 中间操作

    一个中间操作链,对数据源数据进行处理
    
* 中止操作

    一个终止操作,执行中间操作连,并产生结果
    
* 筛选与切片
    * filter(Predicate<? super T> predicate):接收lambda,排除掉符合条件的元素
    * limit(long size):截断流,使元素数量不超过size
    * skip(long n):调过n个元素,返回扔掉了n个元素的流,若元素不足n个,则返回一个空流
    * distinct:筛选,通过流所生成元素的hashCode()和equals()去除重复元素
    
* 映射
   * map:接收lambda表达式,将元素转换成其他形式或提取信息。接收一个函数作为参数,改函数会被应用到每个元素上,并将其映射成一个新元素
   * flatMap:

* 查找与匹配
    * allMatch:检查是否匹配所有元素
    * anyMatch:检查是否至少匹配一个元素
    * noneMatch:检查是否没有元素匹配
    * findFirst:返回第一个元素
    * findAny:返回流中满足条件的任意一个元素
    * count:统计流中元素总数
    * max:返回流中最大值
    * min:返回流中最小值
    
 * 规约
    reduce(T iden,BinaryOperator b) 将流中元素反复结合起来,得到一个值,返回T
    reduce(BinaryOperator b) 可以将流中元素反复结合起来,得到一个值,返回Optional<T>
    
    
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Integer sum = list.stream().reduce(0, (x,y)->x+y);
    // 规约执行流程:x第一次取起始值,如上x第一次取0,y第一次取stream第一个元素1,执行x+y
    // x第二次取(x+y)的第一次的结果,y取stream流中第二个元素
    // ....
    System.out.println(sum);

    // 计算所有学生分数之和
    Double sumScore = students.stream().map(Student::getScore).reduce(0.0, Double::sum);
    System.out.println("所有学生分数之和: "+sumScore);
    // reduce不设置起始值 计算所有员工工资之和
    Optional<Double> salarySum = employees.stream().map(Employee::getSalary).reduce(Double::sum);
    System.out.println("所有员工工资之和: "+salarySum.get());
    
 * 收集器
   
   
## 接口的默认方法和静态方法
  
  若一个接口中定义了一个默认方法，而另外一个类或者接口中又定义了一个同名方法时
  
  * 选择父类中的方法。如果一个父类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略.
  * 接口方法冲突. 如果一个父接口提供一个默认方法，而另一个接口也提供了一个具有相同方法签名(方法名，参数列表，返回值)的方法，不论方法是否默认方法
    那么必须覆盖该方法来解决冲突(两个接口的默认方法只能二选一)
    