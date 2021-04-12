import React, { Component } from 'react';
import Api from '../../config/siteinfo';
import { createHashHistory } from 'history';

// import Http from '../../components/http';

class Aside extends Component {

    constructor(props) {
        super(props)
        this.state = {
            uploadedFile: '',
            uploadedFileGetUrl: ''
        }
        
        this.history = createHashHistory();
    }

    error() {
        alert('error')
    }

    callback(result) {
        // this.setState({
        //     uploadedFile: result.uploadedFile,
        //     uploadedFileGetUrl: result.uploadedFileGetUrl
        // })

        // console.log(result)
    }

    // 上传文件
    fileUpload = (e) => {
        // var t = this;
        e.preventDefault(); // 阻止表单提交跳转
        // e.persist(); // 调用了target才有值，才不会为null
        // let file = e.target
        let token = localStorage.getItem('token');
        let path = document.querySelector('.myPath').textContent;
        // const URL = Api.siteroot + '/fc/fileUpload.do?token=' + token + '&path=' + path;
        // Http.post(URL, file, this.callback.bind(this), this.error);

        const URL = Api.siteroot + '/fc/fileUpload.do';
        let data =new FormData();
        data.append('file',document.querySelector('input[name="uploadFile"]').files[0]);
        data.append('token',token);
        data.append('path',path);
        const option ={
                    method:'post',
                    mode:'cors', 
                    // headers: {
                    //     'Content-Type': 'multipart/form-data'
                    // },                                                                          
                    body:data
        };
        
        fetch(URL,option)
        .then(function(response){
            if(response.ok){
                console.log('suc')
                return response.json();
            }else{
                console.log('网络错误，请稍后再试')
                return ;
            }
        }).then(function(data){
            if (data.message) {
                window.location.reload();
                // return t.history.push({
                //     pathname: '/file/myfile',
                //     search: t.history.location.search.split("?")[1]
                // });
            }
        })
    }
    
    render() {
        return (
            // <!--菜单-->
            <div className="left-menu">
                <div className="left-menu-top">
                    <a href="/">
                        <div className="left-menu-top-small">
                            <img  alt="" src={[require('../../assets/images/index_01.png')]}/>
                        </div>
                    </a>
                    <a href="/">
                        <div className="left-menu-top-small">
                            <form encType='multipart/form-data'>
                                <img  alt="" src={[require('../../assets/images/index_02.png')]}/>
                                <input type="file" name="uploadFile" className="uploadFile"  style={{
                                    height: '48px', width: '174px', position: 'absolute', left: '22px',
                                    opacity: 0
                                }} onClick={(event) => event.target.value = null }
                                 onChange={this.fileUpload.bind(this)} />
                            </form>
                        </div>
                    </a>
                </div>
                <div className="left-menu-one">
                    <a href={'#/file/myfile?token=' + this.state.token}>
                        <div className="left-menu-one-small">
                            <img  alt="" src={[require('../../assets/images/index_03.png')]}/>
                        </div>
                    </a>
                    <a href="zuijin.html">
                        <div className="left-menu-one-small">
                            <img  alt="" src={[require('../../assets/images/index_05.png')]}/>
                        </div>
                    </a>
                </div>
                <div className="left-menu-two">
                    <a href="/">
                        <div className="left-menu-two-small">
                            <img  alt="" src={[require('../../assets/images/excel01.png')]}/>
                        </div>
                    </a>
                    <a href="/">
                        <div className="left-menu-two-small">
                            <img  alt="" src={[require('../../assets/images/ppt01.png')]}/>
                        </div>
                    </a>
                    <a href="/">
                        <div className="left-menu-two-small">
                            <img  alt="" src={[require('../../assets/images/word01.png')]}/>
                        </div>
                    </a>
                </div>
                <div className="left-menu-three">
                    <a href="caogao.html">
                        <div className="left-menu-three-small">
                            <img  alt="" src={[require('../../assets/images/caogaoxiang01.png')]}/>
                        </div>
                    </a>
                    <a href="lajixiang.html">
                        <div className="left-menu-three-small">
                            <img  alt="" src={[require('../../assets/images/lajixiang01.png')]}/>
                        </div>
                    </a>
                </div>
                <div className="left-menu-four">
                    <div className="left-menu-four-small">
                        <div className="left-menu-four-small-new"></div>
                    </div>
                    <div className="contain_four">
                        <div className="contain_four_main">
                            <span>容量：</span>
                            <span className="cont">{this.state.maxSize}</span>GB；可用
                            <span className="use">3</span>GB
                        </div>
                        <div className="max_add">
                            <button className="max_container" >升级容量</button>
                        </div>
                    </div>
                </div>

                <div className="foot">
                    <a href="/">返回意见</a>丨
                    <a href="/">帮助中心</a>
                </div>
            </div>
            // <!--菜单end-->
        );
    }

    componentDidMount() {
        let t = this;
        t.setState({
            token: localStorage.getItem('token'),
            maxSize: sessionStorage.getItem("maxSize")
        })

    }
}

export default Aside;