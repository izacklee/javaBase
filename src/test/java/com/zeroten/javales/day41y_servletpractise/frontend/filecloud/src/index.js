import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Index from './pages/index/index';


class Container extends Component {
    render() {
        return ( 
            <Index />
        );
    }
}

ReactDOM.render(<Container />,
    document.getElementById('root')
);