import React, { Component } from 'react';
import Api from '../../config/siteinfo';
import Header from '../layout/header';
import Footer from '../layout/footer';
import Qs from 'qs';

export default class Login extends Component {
    constructor(props) {
        super(props);
        require('../../assets/css/register.css');
        this.state = {};
        this.history = this.props.history;
    }
    submitForm = (event) => {
        let username = this.refs.username.value + '';
        let password = this.refs.password.value + '';
        if (username.length < 6 || username.length > 20) {
            alert('用户名为6~20个字符');
            return;
        }
        if (password.length < 6 || password.length > 20) {
            alert("密码为6~20个字符");
            return;
        }

        // 登录
        // let formData = new FormData();
        // formData.append('username', username);
        // formData.append('password', password);

        fetch(Api.siteroot + '/fc/loginUser.do',{
                method: "POST",
                body: Qs.stringify({
                    username: username,
                    password: password
                }),
                headers: new Headers({
                    'Content-Type': 'application/x-www-form-urlencoded'
                })
        }).then( async function(res){
            return await res.json();
        }).then((json) => {
            if (json.token) {
                // 可以通过Vue把token保存到MongoDB中
                localStorage.setItem("token",json.token);
                return this.history.push({
                    pathname : '/file/myfile',
                    search: 'token='+json.token
                });
            }
        }).catch((err)=>{
            alert(err);
            throw err;
        });  
    }
    render() {
        return (
            <>
                <Header />
                {LoginMain(this)}
                <Footer />
            </>
        );    
    }
}

function LoginMain(login) {
    return (
        <div className="main cl">
            <div className="main_z z">
                <img alt="" src={[require('../../assets/images/register02.png')]}/>
            </div>
            <div className="main_y y">
                <div className="main_y_title">
                    欢迎使用
                </div>
                <div className="meta"></div>
                <form action="#/user/login" method="POST">
                    <div className="main_y_content">
                        <div className="main_input">
                            <input type="text" placeholder="请输入用户名" className="phone" ref="username"/>
                            <img alt="" src={[require('../../assets/images/register03.png')]}/>
                        </div>
                        <div className="main_input">
                            <input type="password" placeholder="请输入密码" className="password" ref="password"/>
                            <img alt="" src={[require('../../assets/images/register03.png')]}/>
                        </div>
                        <div className="login-submit" onClick={login.submitForm}>
                            <div className="register">
                                登&nbsp;录
                            </div>
                        </div>
                        <div className="main_y_content_buttom">
                            <a href="#/user/register">尚未注册?</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    );
} 