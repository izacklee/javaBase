#### 1.今天的内容是JSP最核心，最重要，也是所有交互层概念中最需要掌握的地方
#### 2.JSP：其本质是JAVA的Servlet，将HTML的编码以文本流的方式交给客户端下载，在HTML当中我们实际看到的就是一个前端页面
   为什么要有Servlet？因为我们自己写输出流是一件很麻烦的事情
#### 3.如何把浏览器当中的值，提交到服务器上 
   3.1）9个内置对象（在JSP当中都属于局部变量，也就是在_jspService方法中）
   * 3.1.1）请求对象：request
     3.1.2）输出对象：out
   * 3.1.3）响应对象：response
   * 3.1.4）应用程序对象：application
   * 3.1.5）会话对象：session
     3.1.6）页面上下文对象：pageContext
     3.1.7）页面对象：page（只作用于JSP）
     3.1.8）配置对象：config
     3.1.9）异常对象：exception
  3.2）Request请求：由浏览器客户端，向服务器发起请求携带的所有信息 ，都包含在Request对象当中  
     3.2.1）向服务器发起请求的方式：
        HTTP协议：是明文协议
        HTTP密文协议：SSL 
        a.表单：action指向服务器请求的资源
        b.请求方式GET/POST，默认GET
                                GET                                         PSOT
                        从服务器获取数据                                    向服务器提交数据
          参数出现在URL中         是                                           否
          长度限制                有(URL总长度2048个字符,建议不超255个字符)       无
          安全性                  低                                           高
          URL可传播               是                                           否     
          提示：面试提问Servlet时，GET/POST区别必问      
        c.获取请求的参数，获取到的所有数据都是String类型
            例：String username = request.getParameter("username");
    3.2.2）如何处理中文乱码？
        a.指定编码格式 编码格式默认IS0-8859-1
            request.setCharacterEncoding("UTF-8")  // 默认只对POST起作用  
        b.get请求方式乱码解决方法
            方法1：直接对进行字符串处理String username = new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");  
            方法2：在tomcat配置文件/usr/local/tomcat/conf/server.xml中加URIEncoding="UTF-8"，进行统一字符集编码，粗暴，不能在使用别的字符集了
            方法3：在tomcat配置文件server.xml加useBodyEncodingForURI="true"，不对任何项目做字符集的限制，相对温柔
                  可以使用request.setCharacterEncoding("UTF-8")，针对GET请求方式 
        c.保证整个项目中，所有字符集统一 
        d.属性的移交
            设置属性：setAttribute
            获取属性值：getAttribute
  3.3）转发和重定向（必问）
     3.3.1）转发
        i.所有的数据流转，都是在后台完成
        ii.用户一次请求，一次响应
        iii.请求和响应一并带走，可以获取request原本的所有参数和属性值
        iiii.URL没有发生变化
        iiiii.没有办法转发到工程外部资源（仅限于本web应用）
     3.3.2）重定向
        i.重定向一次，将会通过响应流告诉客户端重新请求服务器
        ii.原本的request和response全部丢失，将会产生新的请求和响应  
        iii.重定向就是一个普通的get请求
        iiii.URL会变化
        iiiii.可以重定向到任意网络资源，比如百度等   
  3.4）session
     3.4.1）在客户端和服务器建立会话后，会在该会话当中产生若干次请求和响应
     3.4.2）客户端和服务器交流，只可能是客户端轮询，服务器是找不到客户端推送的
     3.4.3）session可以保存属性
            i.客户端第一次请求服务器，抵达服务器后，服务器会自动生成一个sessionId，
                把响应返回给客户端并携带该sessionId，之后的客户端与服务器交流都是通过该sessionId完成
            ii.正常情况下不超时，浏览器不关闭，session就不会消失
            iii.session可以作为客户端与服务器一次会话的缓存
            iiii.session为客户端用户独享
            iiiii.session默认无操作的情况下保留30分钟
  3.5）Application
     3.5.1）整个服务器共享
     3.5.2）所有用户都可以获取这里的数据                       
  3.6）4个作用域（当前数据可以作用的范围）【面试极大可能问】 
     共同点都可以存储属性  
     3.6.1）Page：只作用于当前的JSP  // 平时用不到
     3.6.2）Request：只作用于一次请求
     3.6.3）Session：只只用于一次会话
     3.6.4）Application：作用于整个工程
  3.7）Cookie
     3.7.1）将数据保存在客户端
     3.7.2）保存上限是7天
     3.7.3）有极大安全隐患（浏览器可查看Cookie相关的信息）
     3.7.4）用户可以禁止Cookie  
     3.7.5）Cookie第一次请求，如果没有sessionId，会由客户端生成一个sessionId交给服务器（和session相反）
     3.7.6）不要把敏感的数据存到Cookie里
      
     
   Wireshark抓包工具