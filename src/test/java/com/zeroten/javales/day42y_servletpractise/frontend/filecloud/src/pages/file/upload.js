import React, { Component } from 'react'
import Http from '../../components/http'
import Api from '../../config/siteinfo'

// 测试demo
export default class Upload extends Component {

    constructor(props) {
        super(props)
        this.state = {
            uploadedFile: '',
            uploadedFileGetUrl: ''
        }
    }

    error() {
        alert('error')
    }

    callback(result) {
        this.setState({
            uploadedFile: result.uploadedFile,
            uploadedFileGetUrl: result.uploadedFileGetUrl
        })
    }

    handleImageUpload(e) {
        e.preventDefault()
        let file = e.target
        const URL = Api.siteroot + '/fc/fileUpload.do'
        Http.post(URL, file, this.callback.bind(this), this.error)
    }

    render() {

        return (
            <>  
                {/* 异步上传 */}
                {/* <input type="file" name="uploadFile" /> */}
                {/* 使用表单完成同步上传 */}
                {/* <form action="" method="post" encType="multipart/form-data">
                    <input type="text" name="username" />
                    <input type="text" name="password" />
                    <input type="file" name="uploadFile1" />
                    <input type="file" name="uploadFile2" />
                    <input type="file" name="uploadFile3" />
                </form> */}

                <input type="file" name="uploadFile" onChange={this.handleImageUpload.bind(this)}/>
                <div>
                    {this.state.uploadedFileGetUrl === '' ? null : 
                    <div>
                        <p>{this.state.uploadedFile}</p>
                        <img src={this.state.uploadedFileGetUrl}  alt='你选的图片'/>
                    </div>}
                </div>
            </>
        );
    }

}