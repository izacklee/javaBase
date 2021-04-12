import React, {Component} from 'react';
import Api from './../../config/siteinfo';
import Header from '../layout/header';
import Footer from '../layout/footer';
import './../../assets/css/register.css';


export default class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.history = this.props.history;
    }
    submitForm = (event) => {
        let username = this.refs.username.value + "";
        let password = this.refs.password.value + "";
        let realname = this.refs.realname.value + "";
        if (username.length === 0) {
            alert("用户名为空");
            return;
        }
        if (password.length === 0) {
            alert("密码为空");
            return;
        }

        // 注册
        // let formData = new FormData();
        // formData.append("username", username);
        // formData.append("password", password);
        // formData.append("realname", realname);
        let formData = 'username='+username+'&password='+password+'&realname='+realname;
        fetch(Api.siteroot + "/fc/registerUser.do", {
            method: "POST",
            body: formData,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then( async function(res){
            // console.log(res); // 响应流 Response
            return await res.json();
        }).then((json) => {
            if (json.message === '注册成功') {
                this.history.push('/user/login');
            } else {
                alert(json.message);
            }
            return;
        }).catch((err) => {
            throw err;
        });
    }
    render() {
        return (
            <>
                <Header />
                {RegisterMain(this)}
                <Footer />
            </>
        );
    }
}

function RegisterMain(register) {
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
                <form action="/user/login" method="POST">
                    <div className="main_y_content">
                        <div className="main_input">
                            <input type="text" placeholder="请输入用户名" className="phone" ref="username"/>
                            <img alt="" src={[require('../../assets/images/register03.png')]}/>
                        </div>
                        <div className="main_input">
                            <input type="password" placeholder="请输入密码" className="password" ref="password"/>
                            <img alt="" src={[require('../../assets/images/register03.png')]}/>
                        </div>
                        <div className="main_input">
                            <input type="password" placeholder="请再次输入密码" className="repassword" ref="repassword" />
                            <img alt="" src={[require('../../assets/images/register03.png')]}/>
                        </div>    
                        <div className="main_input">
                            <input type="text" placeholder="请输入真实姓名" className="phone" ref="realname"/>
                            <img alt="" src={[require('../../assets/images/register03.png')]}/>
                        </div>
                        <div className="login-submit" onClick={register.submitForm}>
                            <div className="register">
                                注&nbsp;册
                            </div>
                        </div>
                        <div className="main_y_content_buttom">
                            <a href="#/user/login">登录</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    );
}