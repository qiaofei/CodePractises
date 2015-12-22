//
//  main.swift
//  TestGenerics
//
//  Created by Fei on 15/12/22.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import Foundation

//print("Hello, World!")
//尖括号中间的类型为泛型
//写一个泛型的数组添加函数,将后一个数组添加到前一个数组后面,遍历后一个数字使用append逐个添加
func copyArray<T>(var first: [T],inout second: [T]) -> [T]{
    for element in second {
    first.append(element)
    }
    return first
}
//func toString<T>(items: [T]) ->T{
//    var result: T
//    for item in items{
//    result += item
//    }
//    return result
//}
var first: [String]=["我","怎","么"]
var second: [String]=["知","道"]
func showArray(arrays: [String]){
    var item :String = ""
    for element in arrays{
    item += element
    }
    print(item)
}
first = copyArray(first, second: &second)
showArray(first)