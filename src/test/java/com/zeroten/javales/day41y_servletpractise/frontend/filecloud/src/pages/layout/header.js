import React, { Component } from "react";
import '../../assets/css/index.css';

class Header extends Component {

    constructor(props) {
        super(props)
        this.state = {}
    }

    render() {
        return (
            <div className="nav" id="root">
                <div className="nav cl">
                    <div className="nav_z z">
                        <img alt="" src={[require('../../assets/images/register01.png')]}/>
                    </div>
                    <div className="nav_y y">
                        <a href="http://www.bootstrapmb.com/">关于我们</a>
                        <span>丨</span>
                        <a href="/">联系我们</a>
                    </div>
                    <div className="userNumber y">
                        你好，<span>{this.state.realName}</span>
                    </div>
                </div>
            </div>
        );
    }

    // 页面挂载完毕执行
    componentDidMount() {
        let t = this;
        t.setState({
            realName: sessionStorage.getItem("realName")
        })
    }
}

export default Header;
