<% request.setAttribute("title", "登录"); %>
<%@ include file="header.jsp"%>
    <div class="main cl">
        <div class="main_z z">
            <img src="images/register02.png"/>
        </div>
        <div class="main_y y">
            <div class="main_y_title">
                欢迎使用
            </div>
            <div class="meta"></div>
            <form action="/fc/loginUser.do" method="post">
                <div class="main_y_content">
                    <div class="main_input">
                        <input type="text" placeholder="请输入用户名" class="phone" name="username" maxlength="11"/>
                        <img src="images/register03.png"/>
                    </div>
                    <div class="main_input">
                        <input type="password" placeholder="请输入密码" class="password" name=password" maxlength="18"/>
                        <img src="images/register03.png"/>
                    </div>
                    <a href="">
                        <div class="bn-login">
                            登&nbsp;录
                        </div>
                    </a>
                    <div class="main_y_content_buttom">
                        <a href="/register.jsp">尚未注册?</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
<script>
    $('.bn-login').click(function() {
        $('form').submit();
    });
</script>