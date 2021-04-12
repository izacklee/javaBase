let params = function (props) {
    let params = props.location.search
        if (!params) {
            console.log('search为空')
            return
        } 
        let par = {}
        params.split('?')[1].split('&').map((e) => {
            let parArr = e.split('=')
            par[parArr[0]] = parArr[1]
            return par
        })
        
        return par
}

export default params; 