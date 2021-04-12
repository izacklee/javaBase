  <%@ include file="header.jsp"%>
  <div class="main cl">
        <div class="main_z z">
            <img src="images/register02.png"/>
        </div>
        <div class="main_y y">
            <div class="main_y_title">
                用户注册
            </div>
            <div class="meta"></div>
            <form action="/fc/registerUser.do" method="post">
                <div class="main_y_content">
                    <div class="main_input">
                        <input type="text" placeholder="请输入用户名" class="phone" name="username" maxlength="11"/>
                        <img src="images/register03.png"/>
                    </div>
                    <div class="main_input">
                        <input type="password" placeholder="请输入密码" class="password" name="password" maxlength="18"/>
                        <img src="images/register03.png"/>
                    </div>
                    <div class="main_input">
                        <input type="password" placeholder="请再次输入密码" class="password" name="repassword" maxlength="18"/>
                        <img src="images/register03.png"/>
                    </div>
                    <div class="main_input">
                        <input type="text" placeholder="请输入真实姓名" class="realname" name="realname" maxlength="20"/>
                        <img src="images/register03.png"/>
                    </div>
                    <a>
                        <div class="register">
                            注&nbsp;册
                        </div>
                    </a>
                </div>
            </form>
        </div>
    </div>
  <%@ include file="footer.jsp"%>
    <script>
        $('.register').click(function(){
            $('form').submit();
        });
        $(".phone").blur(function () {
//                    电话号码验证
            var sw = /^(1)[3-9]{1}[0-9]{9}$/;//验证手机号
//                    var str=17757425590;
//                    alert(sw.test(str));
            var valu = sw.test(parseInt($(this).val()));
            if ($(this).val().length == 0 || valu == false) {
                $('.meta').text('用户名或者密码错误，重新输入后再次尝试');
            }
            else {
                $('.meta').text('');
            }
        });

    </script>