#### 1.EL(Expression Language)表达式和JSTL
    <%--解决EL表达式不解析 在头部设置isELIgnored是否忽略EL表达式为false即可--%>
    <%@ page isELIgnored="false" %>
   （1）EL的出现主要解决JSP数据处理过于复杂的问题
   （2）EL表达式是可以通过简单的表达式语法，获取相应作用域中的数据
   （3）可通过key的方式获取值，不只局限与对象、字符串，基本数据型，数组，集合等都可以
   （4）注意：如果需要获取对象属性方法，那么必须要有get类型方法，set方法可无
   （5）EL表达式可以用于页面任意位置，但是外部引用不行
    (6) EL所有表达式必须在表达式内部完成
   （7）empty验证属性是否存在

#### 2.JSTL(JavaServerPages Standard Tag Library)：JSP标准标签库
  （1）使用前先导入两个包：jstl1.2.jar和standard1.1.2jar  
  （2）在JSP当中引入标签库
        2.1）判断
            test属性：是判断，写EL表达式
        2.2）循环
            a.items属性：保存的集合，写EL表达式
            b.var属性：遍历后的元素对象
            c.varStatus属性：遍历的状态对象（index索引在这对象当中）
        2.3）格式化
            使用格式化标签，例子：<fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
        2.4）JSTP实际上有非常丰富的内容，但毕竟太古老了，2009年就停止维护了，不建议花太多时间
   (3)一个简单的web业务流程
                