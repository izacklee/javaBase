#### 1 创建型设计模式
   1）创建型其他模式
    1）单例模式
      a 饿汉式单列：不管需不需要用都直接加载初始化（当这个类很重时，就会造成极大的性能影响，启动久）
      b 懒汉式单例：需要用时才加载初始化（推荐）
        b1 Dcl（Double Check Lock，双重检查锁定）实现，可传参
        b2 静态内部类实现，不可传参 
#### 2 结构型设计模式
   1）适配器（Adapter）：为它所适配的对象提供了一个不同的接口。
    用途：将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的类可以一起工作。
    场景：
        a、你想使用一个已经存在的类，而它的接口不符合你的需求。
        b、你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。此时可以适配它的父类接口。
    已知应用：JDK中InputStreamReader：StreamDecoder实现了InputStream到Reader的适配；
        OutputStreamWriter：StreamEncoder实现了OutputStream到Writer的适配
   2）桥接（Bridge）:使得抽象接口和实现部分可以独立进行改变。
    用途：将抽象部分和它的实现部分分离，使它们可以独立地变化。
    场景：
        a、程序运行时可以选择接口的实现部分。
        b、类的抽象和实现都应该通过生成子类的方式加以扩充。
    已知应用：JDBC操作数据库
        a、定义上层数据库操作接口Connection
        b、定义数据库驱动接口Driver
        c、通过DriverManager桥接Connection和Driver，具体流程：
        （1）厂商注册驱动到DriverManager
        （2）应用程序通过DriverManager获取连接
   3）装饰（Decorator）：为对象添加一个或多个功能。
    用途：动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式比生成子类更加灵活。
    场景：
        a、在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
        b、处理那些可以撤销的职责。
        c、当不能采用生成子类的方式进行扩充时。如：会产生大量的子类造成类膨胀；类定义不能用于生成子类。
    已知应用：JDK中的FilterInputStream作为InputStream（如：FileInputStream）的装饰；
        BufferedInputStream类（继承FilterInputStream）会提供一个内部的字节数组作为输入缓存；
        通过DataInputStream类（继承FilterInputStream），可以用与机器无关的方式从底层数据流中读取基本Java数据类型。
   4）外观（Facade）:隐藏那些与平台相关的类，只允许Client使用Facade定义的接口。
    用途：为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
    场景：
        a、为一个复杂子系统提供简单接口。这些简单接口满足大部分需求，当需要定制时越过Facade进行定制。
        b、客户程序与抽象类的实现部分之间存在很大的依赖性。引入Facade将这个子系统与客户以及其他的子系统分离，
            可以提高子系统的独立性和可移植性。
        c、当你需要构建一个层次结构的子系统时，使用Facade模式定义子系统中每层的入口点。如果子系统间是相互依赖的，
            可以让它们仅通过Facade进行通信，从而简化了它们之间的依赖关系。
    已知应用：Tomcat中的Servlet中doGet,doPost方法参数：HttpServletRequest，HttpServletResponse；
        Tomcat中传递给Servlet的真正参数是RequestFacade和ResponseFacade；
        RequestFacade是Request的外观，ResponseFacade是Response的外观。
   5）组合（Composite）：将对象组合成树形结构以表示“部分-整体”的层次结构。
    用途：将对象组合成树形结构以表示“部分-整体”的层次结构。Composite使得用户对单个对象和组合对象的使用具有一致性。
    场景：
        a、你想表示对象的部分-整体层次结构。
        b、你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
    已知应用：JDK中HashMap的Node；
        Node实现了Map.Entry接口，Node中可以添加Node；
        地图绘制；
        Map包括：Line，Point，Polygon，Text；
        都实现了Graphic接口；
        Map.draw会触发各个子部件的draw。
   6）代理（Proxy）：控制原对象的直接访问。
    用途：为其他对象提供一种代理以控制对这个对象的访问。
    场景：
        a、远程代理，代理远程对象的访问。
        b、虚代理，根据需要创建开销大的对象。
        c、保护代理，控制对原始对象的访问。
    已知应用：JDK中动态代理；Dubbo等RPC框架。




