//
//  main.swift
//  TestEnum
//
//  Created by Fei on 15/12/20.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import Foundation

//print("Hello, World!")
//枚举类型,大体讲就是将一系列常量放到一个数组中,比如color中放几个颜色的定义,planet中放一些星球的定义
//定义一个color的枚举,注意枚举命名最好大写开头,并且为单数形式而不是复数
enum Color{
    case White
    case Black
    case Blue
    case Red
    case Green
    case Orange
}
//定义枚举常量
var color = Color.Black
//使用switch
switch color {
case .Black:
    print("black")
    break
case .White:
    print("white")
    break
case .Blue:
    print("blue")
    break
default:
    print("not include this color")
}



