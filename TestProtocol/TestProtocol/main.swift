//
//  main.swift
//  TestProtocol
//
//  Created by Fei on 15/12/21.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import Foundation

//print("Hello, World!")
//定义一个接口,以及两个函数,声明函数的返回值以及参数
protocol People{
    func getName() -> NSString
    func getAge() -> Int
}

//接口的实现,实现接口中的函数

class Man :People{
    var name :String = ""
    var age :Int! = 0
    //构造方法
    init(){
    name = ""
        age = 0
    }
    func setName(myName :String){
    name = myName
    }
    func setAge(myAge :Int){
    age = myAge
    }
    func getAge() -> Int {
        return age
    }
    func getName() -> NSString {
        return name
    }
}

//实例化man类
var man = Man()

man.setName("joey")
man.setAge(18)
let myName = man.getName()
let myAge = man.getAge()
print("I am \(myName), my age is \(myAge)")
