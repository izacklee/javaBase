import React, { Component } from 'react';

class Aside extends Component {

    constructor(props) {
        super(props)
        this.state = {};
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
                            <img  alt="" src={[require('../../assets/images/index_02.png')]}/>
                        </div>
                    </a>
                </div>
                <div className="left-menu-one">
                    <a href="my.html">
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
            maxSize: sessionStorage.getItem("maxSize")
        })

    }
}

export default Aside;