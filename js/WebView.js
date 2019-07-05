import React, {Component} from 'react'
import PropTypes from 'prop-types'
import {View, requireNativeComponent} from 'react-native'

const RCTWebView = requireNativeComponent('RCTWebView',{
    propTypes : {
        url : PropTypes.string,
        html : PropTypes.string,
        ...View.propTypes // 默认包含的属性
    }
});

module .exports = RCTWebView;




