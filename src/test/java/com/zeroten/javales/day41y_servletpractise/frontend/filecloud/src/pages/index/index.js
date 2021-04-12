import React, { Component } from 'react';
// HashRouter 不会看到真实URL 实际部分使用hash(#)去创建路由
// BrowserRouter 以真实的路由展示
import { HashRouter as Router, Route, Redirect, Switch } from 'react-router-dom';
import { createHashHistory } from 'history';
import Header from '../layout/header';
import Aside from '../layout/aside';
import Main from '../layout/main';
// import Footer from '../layout/footer';
import Login from './../../pages/user/login';
import Register from './../../pages/user/register';
import Params from '../../components/params';
import Api from '../../config/siteinfo';

// 配置路径
function homePath() {
    return (
        <>  
            <Router>
                <Route path='/' component={ Header }/>
                <Route path='/' component={ Aside }/>
                <Route path='/' component={ Main }/>
                {/* <Route path='/' component={ Footer }/> */}
                {/* <Redirect exact path='/user/login'  to='/user/login' /> */}
            </Router>
        </>
   )
}

// 默认路径
function guestPath() {
    return (
        <>
            <Router>
               {/* 重要的事情说N遍，Redirect一定要放在Switch的最后一个 Switch规则如此 (Seitch限制重复渲染的现象。) */}
               {/* exact 严格匹配 匹配成功后不会再继续往下匹配 */}
                <Switch>
                    <Route path='/user/login' component={Login} />
                    <Route path='/user/register' component={Register} />
                    <Route path='/index/index' component={Index} />
                    <Redirect exact path='/' to='/user/login' />
                    <Redirect exact path='/index/index' to='/user/login' />
                    <Redirect exact path='/user/register' to='/user/register' />
                </Switch>
            </Router>
        </>
    )
}

export default class Index extends Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.history = createHashHistory();
        
        let token = typeof(this.props) !== 'object' ? 
                    this.props.location.query.token : null;
        
        token = token ? token : localStorage.getItem('token');
        // console.log(props,this.props.location,token);
        this.user = { token: token };
        
    }
    renderInfo = () => {
        if (this.user.token) {
          return homePath();
        } else {
          return guestPath();
        }
    }
    render() {
        return (
            <>  
                {this.renderInfo()}  
            </>
        );
    }

    // 获取token
    getToken = () => {
        let par = Params(this.history);
        return par ? par['token'] : '';
    }

    // 获取用户信息
    userMessage = () => {
        // console.log(sessionStorage.getItem('realName'))
        let token = this.getToken();
        fetch(Api.siteroot + '/fc/getUserMessage.do?token=' + token, {
            method: 'GET'
        }).then( async (res) => {
            return await res.json();
        }).then((json) => {
            if (json.realName) sessionStorage.setItem("realName", json.realName);
        }).catch((err) => {
            throw err;
        })
    }

    // 获取用户容量信息
    userVolume = () => {
        let token = this.getToken();
        fetch(Api.siteroot + '/fc/getUserVolume.do?token=' + token, {
            method: 'GET'
        }).then(async (res) => {
            return await res.json();
        }).then((json) => {
            if (json.maxSize) sessionStorage.setItem("maxSize", json.maxSize);
        }).catch((err) => {
            throw err;
        })

    }

    // 获取文件列表信息
    userFiles = () => {
        let token = this.getToken();
        fetch(Api.siteroot + '/fc/getUserFiles.do?token=' + token, {
            method: 'GET'
        }).then( async (res) => {
            return res.json();
        }).then((json) => {

        }).catch((err) => {
            throw err;
        });
    }

    componentDidMount() {
       if (this.user.token) {

        this.userMessage();
        this.userVolume();
        this.userFiles();

        // sessionStorage.setItem('realName', 'ZackLee');

        // push传的state 刷新页面后会丢失 变成undefined
        // this.history.push({
        //     pathname: '/index/index',
        //     search: 'aaa',
        //     hash: 'bbb',
        // })
    
       } 
    }

}