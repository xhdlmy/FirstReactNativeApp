import React, { Component } from 'react';
import { Dimensions, StyleSheet } from 'react-native';
import {WebView} from 'react-native-webview'
import RCTWebView from './js/WebView';

const {width, height} = Dimensions.get('window');

const LOLLIPOP = 21;
const LOLLIPOP_MR1 = 22;

var styles = StyleSheet.create({
    container: {
        flex:1,
        backgroundColor:  '#33FF0000'
    },webView :{
        height: 320,
        width : 480,
    }
});



export default class App extends Component {

    constructor(props){
        super(props);
    }

    render() {
        console.log("sdk_version", this.props.sdkVersion);
        console.log("brand", this.props.brand);
        console.log("model", this.props.model);
        if(this.props.sdkVersion < LOLLIPOP_MR1){
            return (
                <RCTWebView
                    url = "https://www.baidu.com"
                    style = {{ width, height }}
                />
            );
        }else{
            return (
                <WebView
                    source = {{uri:"https://cn.bing.com/?mkt=zh-CN&mkt=zh-CN"}}
                    style = {{ width, height }}
                />
            );
        }

    }
}

