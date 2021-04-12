import React, { Component } from 'react';

class Main extends Component {

    render() {
        return (
            // <!--菜单右边的iframe页面-->
                <div id="right-content" className="right-content">
                    <div className="content">
                        <div id="page_content">
                            <div className="search">
                                <div>
                                    <span>搜索&nbsp;&nbsp;"合同"&nbsp;&nbsp;结果:</span>
                                </div>
                                <div className="y serach_box">
                                    <input tyep="text" placeholder="搜索"/>

                                </div>
                                <button className="y">搜索</button>
                            </div>
                            <a href="/">
                                <div className="dir_box cl">
                                    <div className="dir z">
                                        <img  alt="" src={[require('../../assets/images/dir.png')]}/>
                                        <span>合同管理</span>
                                    </div>
                                    <div className="dir_small y">
                                        <span className="file_size">32M</span>
                                        <span className="time">2016-06-20 16:20:01</span>
                                    </div>
                                </div>
                            </a>
                            <a href="/">
                                <div className="dir_box nomargin cl">
                                    <div className="dir dir_file z">
                                        <img  alt="" src={[require('../../assets/images/dir_word.png')]}/>
                                        <span>劳动合同模板</span>
                                    </div>
                                    <div className="dir_small y">
                                        <span className="file_size">32M</span>
                                        <span className="time">2016-06-20 16:20:01</span>
                                    </div>
                                </div>
                            </a>
                            <a href="/">
                                <div className="dir_box nomargin cl">
                                    <div className="dir dir_file z">
                                        <img  alt="" src={[require('../../assets/images/dir_word.png')]}/>
                                        <span>劳动合同模板01</span>
                                    </div>
                                    <div className="dir_small y">
                                        <span className="file_size">32M</span>
                                        <span className="time">2016-06-20 16:20:01</span>
                                    </div>
                                </div>
                            </a>
                            <a href="/">
                                <div className="dir_box nomargin cl">
                                    <div className="dir dir_file z">
                                        <img  alt="" src={[require('../../assets/images/dir_word.png')]}/>
                                        <span>劳动合同模板02</span>
                                    </div>
                                    <div className="dir_small y">
                                        <span className="file_size">32M</span>
                                        <span className="time">2016-06-20 16:20:01</span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
        )
    }
}

export default Main;