import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import { createHashHistory } from 'history';
import Script from 'react-load-script';
import Api from '../../config/siteinfo';
import Qs from 'qs';
// import '../../assets/css/index.css';

class Myfile extends Component {

    constructor(props) {
        super(props)
        require('../../assets/css/my.css')
        require('../../assets/page/base.css')
        require('../../assets/page/pageGroup.css')
        this.state = {
            scriptStatus: 'no',
            fileItems: {},
            count: 0
        }
        this.history = createHashHistory();
    }

    handleScriptCreate() {
        this.setState({scriptLoaded: false})
    }

    handleScriptError() {
        this.setState({scriptError: true})
    }

    handleScriptLoad() {
        this.setState({scriptLoaded: true, scriptStatus: 'yes'})
    }

    // 新建文件夹
    mkdir =() => {
        var t = this;
        var token = localStorage.getItem('token');
        var dirName = prompt("请输入目录名称"); // 用于显示可提示用户进行输入的对话框。
        var path = document.querySelector('.myPath').textContent;
        fetch(Api.siteroot + '/fc/mkdir.do', {
            method: 'POST',
            body: Qs.stringify({
                token: token,
                dirName: dirName,
                path: path
            }),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then( async (res)=>{
            return await res.json();
        }).then((json)=>{
            if (json.message) {
                // 刷新文件列表数据
                t.userFiles();
            }
        }).catch((err)=>{
            alert(err)
            throw err;
        });
        
    }

    // 获取文件列表信息
    userFiles = (p) => {
        var t = this;
        var token = localStorage.getItem("token");
        
        var path = document.querySelector('.myPath').textContent;
        var searchUrl = t.history.location.search.split("path=")[1];
        path = path !== '/' ?  path : searchUrl ? searchUrl : '/'
        path = p ? p : path;
        document.querySelector('.myPath').innerHTML = path;
        fetch(Api.siteroot + '/fc/getUserFiles.do?token=' + token + "&path=" + path, {
            method: 'GET'
        }).then( async (res) => {
            return await res.json();
        }).then((json) => {
            t.setState({
                fileItems: json.fileItems
            });
            if (p || path === '/') {
                t.history.push({
                    pathname: '/file/myfile',
                    search: 'token=' + token + "&path=" + path
                })
            }
        }).catch((err) => {
            throw err;
        });
    }

    // 点击打开文件夹
    showDir = (s) => {
        var t = this;
        var path = document.querySelector(".myPath").textContent;
        var fileName = s.currentTarget.getAttribute("file-name");
        t.setState({count: t.state.count + 1});
        setTimeout(() => {
            // 双击
            if (t.state.count === 2) {
                path = (path === "/") ? fileName : path + "/" + fileName;

                document.querySelector(".myPath").innerHTML = path
                t.userFiles(path) 
            }
            t.setState({count:0});
        }, 200);
    }

    // 下载文件
    fileDownload = (s) => {
        var t = this;
        var token = localStorage.getItem('token');
        var path = document.querySelector('.myPath').textContent;
        var fileName = s.currentTarget.getAttribute('file-name');
        t.setState({count: t.state.count + 1});
        setTimeout(() => {
            // 双击
            if (this.state.count === 2) {
                // 打开新页面下载
                window.open(Api.siteroot + '/fc/fileDownload.do' +
                '?token=' + token + '&path=' + path + '&fileName=' + fileName);
            }

        }, 200);
    }

    render() {
        return (
            <>  
                { this.myfileHtml() }
            </>
        );
    }

    componentDidMount() {
        this.userFiles();
    }

    
    componentWillReceiveProps(nextProps) {
        // 解决URL不变 参数变的情况下 也刷新页面
        if ((this.props.location.hash !== nextProps.location.hash) 
        && (nextProps.location.hash.search('&path') === -1)) {
            this.userFiles('/');
            document.querySelector('.myPath').innerHTML = '/';
        }
    }

    myfileHtml = () => {
        // <!--菜单右边的iframe页面-->
        return <div id="right-content" className="right-content">
                {/* <Script 
                    url='/js/jquery-1.8.3.min.js'
                    // onCreate={this.handleScriptCreate.bind(this)}
                    // onError={this.handleScriptError.bind(this)}
                    // onLoad={this.handleScriptLoad.bind(this)}
                /> */}
                <Script url='/page/pageGroup.js' />
                <Script url='/js/index.js' />
                <Script url='/js/myfile.js' />     

                <div className="content" style={{ width:window.visualViewport.width-237 +'px' }}>
                    <div id="page_content" style={{ width:window.visualViewport.width-237 +'px'}}>
                        <div className="zuijinTop cl">
                            <img src={require('../../assets/images/xiazai.png')} className="xiazai z" alt="" />
                            <img src={require('../../assets/images/yidong.png')} className="yidong z" alt="" />
                            <img src={require('../../assets/images/chong.png')} className="chong z" alt="" />
                            <img src={require('../../assets/images/shanchu.png')} className="shanchu z" alt="" />
                            <img src={require('../../assets/images/xinjian.png')} className="xin z" alt=""  onClick={ this.mkdir } />
                            <div className="sousuo y">
                                <div className="ss1 z"></div>
                                <input type="text" placeholder="请输入关键字搜索文件" className="z sousouInput" />
                            </div>
                        </div>
                        <div className="zuijinTitle cl" style={{ width:window.visualViewport.width-237 +'px' }}>
                            <img src={require('../../assets/images/select.png')} data-all="no" className="z allIcon allSelect" alt="" />
                            <div className="z the">我的文档</div>
                            <div className="z the myPath">/</div>
                        </div>
                        <div className="content cl fileList" style={{paddingLeft: '2%',height:'500px',overflowY:'auto',pisition:'relative', width:window.visualViewport.width-237 +'px'}}>

                            {
                                this.state.fileItems.length > 0 ? this.state.fileItems.map((item, index) => {

                                    if (item.isDir === 1) {
                                        return (
                                            <div key={ index } onClick={this.showDir.bind(this)} file-name={item.fileName} className="box template" data-show="no" style={{minWidth: '0px'}}>
                                                <img src={require('../../assets/images/wenjian.png')} className="icon" alt="" />
                                                <div>
                                                    <p path={item.filePath} className="fileName">{item.fileName}</p>
                                                    <input type="text" className="none" />
                                                </div>
                                                <img src={require('../../assets/images/select.png')} className="select" alt="" />
                                            </div>
                                        )
                                    } else {
                                        return (
                                            <div key={ index } className="box2 template" onClick={this.fileDownload.bind(this)} file-name={item.fileName} data-show="no">
                                                <img src={require('../../assets/images/icon'+item.fileType+'.png')} className="icon" alt="" />
                                                <div>
                                                    <p path={item.filePath} className="fileName">{item.fileName}</p>
                                                    <input type="text" className="none" />
                                                </div>
                                                <img src={require('../../assets/images/select.png')} className="select" alt="" />
                                            </div>
                                        )
                                    }
                                }) : "数据为空。"
                            }
                        </div>
                        <div style={{width:'90%',position:'fixed',bottom:'10px',margin:'auto'}}>
                                <div id="pageGro" className="cb">
                                    <div className="pageUp">上一页</div>
                                    <div className="pageList">
                                        <ul>
                                            <li>1</li>
                                            <li>2</li>
                                            <li>3</li>
                                            <li>4</li>
                                            <li>5</li>
                                        </ul>
                                    </div>
                                    <div className="pageDown">下一页</div>
                                </div>
                            </div>
                        {/* <!--移动弹窗--> */}
                        <div className="moveBox none">
                            <div className="moveTitle">
                                    <span>移动到</span>
                            </div>
                            <div className="closeMove">+</div>
                            <div className="wenjian cl">
                                <img src={require('../../assets/images/icon3.png')} className="z"  alt="" />
                                <p className="z name">劳动合同XX</p>
                                <p className="z size">29.8K</p>
                            </div>
                            <div className="urlBox">
                                    <div className="urlBoxTitle">
                                        选择目标文件夹
                                    </div>
                                <div className="contentMain cl">
                                    <div className="templateUrl z">
                                        <div className="arrow z none"></div>
                                        <img src={require('../../assets/images/wenjian.png')} className="z" alt="" />
                                        <p className="z">我的文档</p>
                                    </div>
                                    <div className="templateUrl z">
                                        <div className="arrow z"></div>
                                        <img src={require('../../assets/images/wenjian.png')} className="z" alt="" />
                                        <p className="z">我的文档</p>
                                    </div>
                                    <div className="templateUrl z">
                                        <div className="arrow z"></div>
                                        <img src={require('../../assets/images/wenjian.png')} className="z" alt="" />
                                        <p className="z">我的文档</p>
                                    </div>
                                </div>
                            </div>
                            <input type="button" className="y quxiao" value="取消" />
                            <input type="button" className="y ok" value="确定" />
                        </div>
                    </div>
                </div>
            </div>;
    }


}

export default withRouter(Myfile);


