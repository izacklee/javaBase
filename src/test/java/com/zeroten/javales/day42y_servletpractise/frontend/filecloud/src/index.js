import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import Index from './pages/index/index';


class Container extends Component {
    render() {
        return ( 
            // Error: Invariant failed: You should not use <withRouter(Index) /> 
            // outside a <Router> 用BrowseRouter把<Index /> 包裹起来可以解决上述问题
            <BrowserRouter>
                <Index />
            </BrowserRouter>
        );
    }
}

ReactDOM.render(<Container />,
    document.getElementById('root')
);