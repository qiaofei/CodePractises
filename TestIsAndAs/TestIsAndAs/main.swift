//
//  main.swift
//  TestIsAndAs
//
//  Created by Fei on 15/12/19.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import Foundation

//print("Hello, World!")
//类型检查符 is 用于检查一个实例是否属于特定类型
//定义一个
//let Data = [
    let dataString: String = "asd"
    let dataInt: Int = 10
    let dataFloat: Float = 11
//]
if dataInt is Int{
    print("dataInt is Integer")
}
else{
print("dataInt is not Integer")
}
