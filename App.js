/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, { Component } from 'react';
import { Text, View } from 'react-native';

export default class App extends Component {
    render() {
        return (
            <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
                <Text>Hello, world!</Text>
            </View>
        );
    }
}

// 自定义组件
// class MyText extends Text {
//
//     render() {
//         return (
//             <View>
//                 <Text style={{marginTop: 100, alignContent: 'center'}}>Hello {this.props.myprop}!</Text>
//             </View>
//         );
//     }
// }

// class MySubText extends MyText {
//
//     constructor(props) {
//         super(props);
//     }
//
//     render() {
//         return (
//             <View>
//                 <Text>Hello {this.props.myprop} {this.props.subprop}!</Text>
//             </View>
//         );
//     }
// }

